It is JDBC and servlet project of employee Authentication and management for this i have used mysql workbench to store database

1) create database and table using these command mysql workbench

create database EMS
use Ems
CREATE TABLE product (
    empid INT,
    ename VARCHAR(25),
    salary INT,
    pass varchar(25),
    address varchar(45)
);

2) Add Jar file of mysql-connector-j-8.4.0 in eclipse
3) Add apache tomcat 9.0 server
4) Run the project
