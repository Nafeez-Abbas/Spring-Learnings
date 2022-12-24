package com.learnings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan("com.learnings")
//Cmt:7 - To specify the package that must be added which is not a sub-package of main application

//Cmt:3 - Specifies to run as a Spring Boot Application
@SpringBootApplication
public class LearningsApplication {

	public static void main(String[] args) {
//		Cmt:4 - creates a container and loads all classes (Beans) in it
		SpringApplication.run(LearningsApplication.class, args);
	}

}



//Cmt:1 - Spring - framework
//Encompasses sub-frameworks
//Spring Core, key principle that it helps to achieve - Loose coupling
//Spring JDBC
//Spring Security
//Spring AOP
//Spring Rest Services
//Spring MVC - to develop web apps, similar to JSP, ASP, Angular
//Spring JPA
//Spring Batch
//Commonly used : Spring Core, Security, JPA

//Spring Core (is the Spring framework itself) is the core (nuclei) of Spring as the name suggests
//key concepts - DI, IOC

//Spring Boot - built on top of Spring framework, provides all features of spring
//helps in auto-configuration (automatically configures the classes based on the requirement), used to develop REST API's

//Spring Boot provides a tool set called Spring Tool Suite(STS) using which a Spring Boot project can be created
//We choose a version of Spring Boot while creating a project and Spring Boot takes care of installing
//the compatible versions of other frameworks (say core, jpa, etc.,)
