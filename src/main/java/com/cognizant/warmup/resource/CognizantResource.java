package com.cognizant.warmup.resource;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.warmup.domain.EBS;
import com.cognizant.warmup.domain.ESA;
import com.cognizant.warmup.domain.TeamMember;
import com.cognizant.warmup.domain.User;
import com.cognizant.warmup.model.LoginCredential;
import com.cognizant.warmup.repository.EBSRepository;
import com.cognizant.warmup.repository.ESARepository;
import com.cognizant.warmup.repository.TeamMemberRepository;
import com.cognizant.warmup.repository.UserRepository;

@RestController
public class CognizantResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@Autowired
	private ESARepository esaRepository;
	
	
	@Autowired
	private EBSRepository ebsRepository;
	
	
	@PostMapping("/login")
	public @ResponseBody String login(@RequestBody LoginCredential login) {
		
		User user = userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		
		if (user != null) {
			
			return "SUCCESS";
		}
		
		return "FAILURE";
		
	}
	
	@GetMapping("/export")
	public void export(HttpServletResponse response) throws IOException {
		
		Workbook workbook = new XSSFWorkbook();
		creatESASheet(workbook);
		creatEBSSheet(workbook);
		creatTeamSheet(workbook);
		
		response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "teamworksheet.xlsx"));
		OutputStream outStream = response.getOutputStream();
		workbook.write(outStream);
		
	}

	private void creatEBSSheet(Workbook workbook) {

		Sheet sheet = workbook.createSheet("EBS");
		
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Team Member Name");
		headerRow.createCell(1).setCellValue("Start Date");
		headerRow.createCell(2).setCellValue("confirmDate");
		headerRow.createCell(3).setCellValue("Submitted Date");
		headerRow.createCell(4).setCellValue("RacfId");
		headerRow.createCell(5).setCellValue("Has Badge");
		headerRow.createCell(6).setCellValue("Has Laptop");
		headerRow.createCell(7).setCellValue("Orientation");
		headerRow.createCell(8).setCellValue("Comments");
		
		Iterable<EBS>  ebses = ebsRepository.findAll();
		int rowNum = 1;
		
		for(EBS ebs: ebses) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ebs.getTeamMember().getFirstName() + ebs.getTeamMember().getLastName());
			row.createCell(1).setCellValue(ebs.getStartDate());
			row.createCell(2).setCellValue(ebs.getConfirmDate());
			row.createCell(3).setCellValue(ebs.getSubmittedDate());
			row.createCell(4).setCellValue(ebs.getRacfId());
			row.createCell(5).setCellValue(ebs.isHasBadge());
			row.createCell(6).setCellValue(ebs.isHasLaptop());
			row.createCell(7).setCellValue(ebs.isOrientation());
			row.createCell(8).setCellValue(ebs.getComments());
		}
		
	}

	private void creatESASheet(Workbook workbook) {

		Sheet sheet = workbook.createSheet("ESA");
		
		Iterable<ESA>  esas = esaRepository.findAll();
		
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("STATUS");
		headerRow.createCell(1).setCellValue("Allocation Date");
		headerRow.createCell(2).setCellValue("Team Member Name");
		headerRow.createCell(3).setCellValue("Comments");
		
		int rowNum = 1;
		for(ESA esa: esas) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(esa.getEsaStatus());
			row.createCell(1).setCellValue(esa.getAllocationDate());
			row.createCell(2).setCellValue(esa.getTeamMember().getFirstName() + esa.getTeamMember().getLastName());
			row.createCell(3).setCellValue(esa.getComments());
			
		}
	}

	private void creatTeamSheet(Workbook workbook) {
		
		Sheet sheet = workbook.createSheet("Teams");
		
		Iterable<TeamMember> teams = teamMemberRepository.findAll();
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("First Name");
		headerRow.createCell(1).setCellValue("Last Name");
		headerRow.createCell(2).setCellValue("Level");
		headerRow.createCell(3).setCellValue("Grade Level");
		headerRow.createCell(4).setCellValue("Location");
		headerRow.createCell(5).setCellValue("Member Status");
		headerRow.createCell(6).setCellValue("Training Stage");
		headerRow.createCell(7).setCellValue("Domain");
		headerRow.createCell(8).setCellValue("Comments");
		headerRow.createCell(9).setCellValue("Employee Id");
		headerRow.createCell(10).setCellValue("RacfId");
		headerRow.createCell(11).setCellValue("Skill");
		headerRow.createCell(12).setCellValue("Role Location");
		int rowNum = 1;
		for(TeamMember team: teams) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(team.getFirstName());
			row.createCell(1).setCellValue(team.getLastName());
			row.createCell(2).setCellValue(String.valueOf(team.getLevel()));
			row.createCell(3).setCellValue(String.valueOf(team.getGradeLevel()));
			row.createCell(4).setCellValue(team.getLocation());
			row.createCell(5).setCellValue(team.getMemberStatus());
			row.createCell(6).setCellValue(String.valueOf(team.getTrainingStage()));
			row.createCell(7).setCellValue(team.getDomain());
			row.createCell(8).setCellValue(team.getComments());
			row.createCell(9).setCellValue(team.getEmployeeId());
			row.createCell(10).setCellValue(team.getRacfId());
			row.createCell(11).setCellValue(team.getSkill().getName());
			row.createCell(12).setCellValue(team.getRole().getLocation());
		}
		
	}

}
