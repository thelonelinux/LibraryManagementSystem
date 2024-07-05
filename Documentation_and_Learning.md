# LibraryManagementSystem Documentation
* Overview : UI will have 3 category : 
  * Admin => who can check the website for development
  * Librarian => Can add the new book in library, 
  * Student => Can subscribe/issue a book, pay the fine, return the book

* Tools used :
	* JDK java 11 (Open Source - free)
   	* MySql version 8.0.37 (Open Source - free)
   	* MySQL IDE - MySql Workbench (Open Source - free)
   	* Eclipse - Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)  (Open Source - free)
   	* Project Build initiate from : https://start.spring.io/;

## Steps and Progress of my project
### Step 1 :  Builded the DB Schema of Student, Books, IssuedBook, Payment
* 
*



### Step 2 : Prepare the following service
* StudentService : To get student details.
  * Also add the JUNIT test cases for each of them.

* BookService : To get book service. (Like when student want's to check whether the certain book is present or not), (Librarian can add new book)

* BookIssueService : To get the details of book issued by a student, and then only give new book to the student, also to get fine per issued book of that student

* PaymentSerivce : To return the payment details made by the student for that issueReferenceId.




### Step 3 : Prepare the following service
* Prepare the UI to do the three main task for student, librarian, and admin

### Step 4 : Prepare to deploy in AWS or Docker and using pipeline and Ansible stuffs.



--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




## My Learnings while building this project


### Step 1 :  Builded the DB Schema of Student, Books, IssuedBook, Payment
* Setup the schema, and required tables done



### Step 2 : Making required services
* 1. StudentService (More Comment of Project dependencies, I have added in Code Project only check there)
  * Create project in spring Initializer
  * Select Project : Maven, Language : Java,  Spring Boot : 3.3.1 (as this is default selected, and max version is this only), groupName/Artifact/Name : com.studentservice
  * In desciption add this : Demo project for Spring Boot Student service, In package name add this : com.studentservice
  * Select Packaging : jar (As this is web API we are building and not website, so this is normal application), Select java 17 only as this was the lowest and our system has java 11.
  * Select Dependency : 1. Spring Web (Because this includes libraries for Restful apis and also includes embedded tomcat server)
    	* For Web MVC
  * Select Dependency : 2. Spring Data JPA (This is data table configuration library, build on top of  Hibernate JPA, which is build on top of Spring JDBC - helps to give predefined query in method form and make connection)
    	* JPA is the one which is giving us this pre-defined method to do crud operations on Sql Table.
  * Now Generate the Project, Zip file will be created, Open the zip file, extract all, open this project from eclipse, open eclipse, goto file, import, maven project, import existing project and select this repo folder in browse.
  * --InSide Code ---
  * Studentserviceapplication.java => This will be the starting point of every spring project, here we will have main class and annotation @SpringBootApplication. for more detail see code only, all explained in comment there
  * setting.xml => here add following settings for DB connection and port number in which port you want to run
    	spring.application.name=studentservice
	spring.datasource.url=jdbc:mysql://localhost:3306/librarymanagementsystem
	spring.datasource.username=root
	spring.datasource.password=Vicky1995@123  (Need to find way to encrypt this password)
	spring.datasource.driverClassName=com.mysql.jdbc.Driver
	spring.datasource.initial-size=10  (This is the number of connection instance you want to create, so that multiple request from users come then make sure we have enough connection in our connection pool) for more detail check 							microservice lecture
	server.port=1111 (Port in which you want to run this Rest Service
  * Now the connection details added, map the table with class entity
  * Don't make column names in caps in MySQL, as when mapping with the Entity Class, the columns was giving error
  * Update the SQL-connector dependency in pom.xml file to almost same version as your version in MySql server.
  * Example <dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.12</version>
		</dependency>
  * My mysql --version in my local machine was : 8.0.37
  * Connection settings in the settings.xml file will be same as we have written here. But you can check for port number and how to make password as encrypted form => NEED TO CHECK <=




