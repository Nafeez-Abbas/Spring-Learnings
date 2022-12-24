package com.learnings.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnings.test.model.ApiTest;

@Repository
public interface ApiTestRepository extends JpaRepository<ApiTest, Integer> {

//	Cmt:8 - The DAO layer is tightly coupled with Database,
//	JPA (Java Persistence API), standard of Oracle
//	And it is a Specification (like an interface) - gives rules and all implementations must follow it.
//	There are a lot of JPA implementations - Hibernate, Ibatis, Spring JPA (internally uses Hibernate)
//	JPA is called ORM (Object Relational Mapping)
// 	change in database results in changing the queries written in dao layer
//	JPA resolves this issue and makes the dao and database loosely coupled

//  Cmt:8.1) When SQL queries are written, the query changes whenever the schema is changed to other database
//	JPA allows users to write OQL(Object Query Language)
//	Object - for each table there will be a class (Entity class/Model)
//	Queries are written using this objects and JPA internally converts the OQL to SQL query based on the database
//	Hence, the database and DAO are loosely coupled

//	Cmt:8.2) DAO is an interface annotated with @Repository and extends JpaRepository interface
//	Each Table will have an entity and a repository

//	Cmt:8.3) When the interface is autowired - 
//	Spring implements the interface(DAO) and inserts the appropriate object

}
