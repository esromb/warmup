# warmup 

Warmup is an API for handling recruitment related task

#### TO RUN
you need the following tool installed locally

* docker
* gradle
* git-cli

Step to run:
#######
* checkout the project
* go to project root folder
* update run-docker-local.sh variable
   project_home=~/Downloads to the directory path where you checkout the above project
* run:
   sh run-docker-local.sh
* if you are using window you can convert the above bash file to windows .bat syntax
 format
 
 
 ### TO UPDATE DATE/SCHEMA/TABLE
 * you can modify db/dbinit.sql and re-run the above script
 * Make sure to execute the below command so that when mysql container reboot it will initialize the DB
 
 
 		`docker system prune --volumes`
 	
    		
    	`docker system prune`
    	
  ### ACCESSING ENDPOINTS
  
  * We are using SPRING DATA REST and the way to access them is
  
  localhost:8080/warmup/users or if you add query in repository with annotation @RestResource(path = "findByName")
  then localhost:8080/warmup/users/search/findByName and query parameters
  
  ###TO START MYSQL ALONE
  * first export project_home the directory where the project is checked out
    `export project_home=~/Downloads`
    
  * then cd to warmup root folder and 
  
  	`docker-compose up mysql`
  	
  * then for development you can run your application from eclipse or intellij
  
