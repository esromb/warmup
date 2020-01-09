create database IF NOT EXISTS warm_up;

use warm_up;

create table IF NOT EXISTS users
(
 id int auto_increment,
 primary key(id)
);

create table if not exists skills(
skill_id int(11) not null primary key,
name varchar(20) not null
);

create table if not exists role (
role_id int(11) not null primary key,
skill_id int(11) not null,
level int(1) not null,
geo varchar(10) not null,
grade_level int(1) not null,
location varchar(20) not null,
cost_bucket varchar(10) not null,
role_status varchar(10) not null, 
FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
);

create table if not exists team_member (
member_id int(11) not null primary key,
first_name varchar(25) not null,
last_name varchar(25) not null,
skill_id int(11) not null,
level int(1) not null,
role_id int(11) not null,
location varchar(20) not null,
grade_level int(1) not null,
member_status varchar(12) not null,
training_stage int(1) not null,
domain varchar(20) not null,
comments varchar(50),
employee_id int(6) not null,
racf_id int(7),
FOREIGN KEY (skill_id) REFERENCES skills(skill_id),
FOREIGN KEY (role_id) REFERENCES role(role_id)
);

create table if not exists esa (
esa_id int(11) not null primary key,
member_id int(11) not null,
esa_status varchar(20) not null,
allocation_date date,
comments varchar(50),
FOREIGN KEY (member_id) REFERENCES team_member(member_id)
);

create table if not exists ebs (
ebs_id int(11) not null primary key,
member_id int(11) not null,
submitted_date date,
start_date date,
confirmed_date date,
comments varchar(50),
racf_id int(11),
has_badge bool not null,
has_laptop bool not null,
orientation bool not null,
FOREIGN KEY (member_id) REFERENCES team_member(member_id)
);