# LibraryManagementSystem Documentation
* Overview : UI will have 3 category : 
  * Admin => who can check the website for development
  * Librarian => Can add the new book in library, 
  * Student => Can subscribe/issue a book, pay the fine, return the book

* Tools used :
	* JDK java 11 (Open Source - free)
     		* There are various options are available to test which java version is using your eclipse. The best way is to find first java installed in your machine.
		* run java -version command on terminal
		* then to check whether your eclipse pointing to the right version or not.
		* For that go to Eclipse >> Preferences >>Java >>Installed JREs
	* To switch between java version check this short youtube video : https://www.youtube.com/watch?v=A5FHcR3cE-w&t=102s&ab_channel=CodeWithArjun
   	* MySql version 8.0.37 (Open Source - free)
   	* MySQL IDE - MySql Workbench (Open Source - free)
   	* Eclipse - Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)  (Open Source - free)
   	* Project Build initiate from : https://start.spring.io/;
 
* Setting up the Environment with the latest Spring Version 3.x :
  * SpringBoot Version 3.x
    	* Here you can use only minimum possible Java version of 17 and higer versions only for compatibility
    	* More detail about springboot 3.x : Read this below documentation
    	* https://docs.spring.io/spring-boot/docs/3.0.11/reference/html/getting-started.html#:~:text=Spring%20Boot%20dependencies%20use%20the%20org.springframework.boot%20group%20id.,and%20declares%20dependencies%20to%20one%20or%20more%20%E2%80%9CStarters%E2%80%9D.
  * springBoot Version 2.x
    	* Here you can use max possible Java version of 17 (7, 8, 11, 13)
  * To understand more the difference between SpringBoot 2.x vs 3.x version check this youtube video : https://www.youtube.com/watch?v=_TSjkSn2yvQ&ab_channel=JavaTechie
    	* Here you can understand what are depreciated, Like Persistence is deprecated and instead now we are using jakarta.

  * My Observation and Learning :
    
    * Many old codes has been deprecated when moving/migrating from SpringBoot 2.x to 3.x
    * You can see the errors when some annotation does not work, even if it's  a dependency you have added.
      	* Example for Spring DATA JPA
      	  	* This was working fine in Entity class annotation in Student (In spring 2.x)
      	  	  	* import javax.persistence.Column;
			* import javax.persistence.Entity;
			* import javax.persistence.Id;
			* import javax.persistence.Table;
      	  	* But in Spring 3.x these are deprecated and instead we have to import this. We can import by hovering over the annotation and doing import jakarta, for entity, table, id and columnname in all the annotation
      	  	  	* import jakarta.persistence.Column;
			* import jakarta.persistence.Entity;
			* import jakarta.persistence.Id;
			* import jakarta.persistence.Table;
      	  
      	* More errors you can see if you build the project. In the red text. just search for them in stack overflow and resolve it. Example like
      	  	* https://stackoverflow.com/questions/52032739/loading-class-com-mysql-jdbc-driver-this-is-deprecated-the-new-driver-class
      	  	* I resolved this problem by change application.properties of
			* spring.datasource.driver-class-name=com.mysql.jdbc.Driver
			* to
			* spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
			* Hope it help

## Steps and Progress of my project
### Step 1 :  Builded the DB Schema of Student, Books, IssuedBook, Payment
* MySQL Bench (user is root password is Vihaha19haha@123)
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
#### STUDENTSERVICE SPRINGBOOT PROJECT PREPARATION
* NOTE : Directly copying old microservices project code and using in your latest springboot version code may not work as many are depreciated as migration from springboot 2.x to 3.x
* 1. StudentService (More Comment of Project dependencies, I have added in Code Project only check there)
  * Create project in spring Initializer
  * Select Project : Maven, Language : Java,  Spring Boot : 3.3.1 (as this is default selected, and max version is this only), groupName/Artifact/Name : com.studentservice
  * In description add this : Demo project for Spring Boot Student service, In package name add this : com.studentservice
  * Select Packaging : jar (As this is web API we are building and not website, so this is normal application), Select java 17 only as this was the lowest and our system has java 11.
  * Select Dependency : 1. Spring Web (Because this includes libraries for Restful apis and also includes embedded tomcat server)
    	* For Web MVC
  * Select Dependency : 2. Spring Data JPA (This is data table configuration library, build on top of  Hibernate JPA, which is build on top of Spring JDBC - helps to give predefined query in method form )
    	* JPA is the one which is giving us this pre-defined method to do crud operations on Sql Table. It will have all the crud operation
  * We have to add one more dependency
  * You need to also add mySQL Driver connector dependency if you are using mySQL driver to connect to database.
   	* check in the code, you can add manually also and save the pom.xml file to download. No need to get all dependency from initializer only.
    	* Just right click on the project folder. and do run as maven install, once you have added new dependency in the pom.xml file, it will download all the required libraries and shows successful build in the console.
       	* right now taken 2.7.1 only in spring boot version again.
  * Now Generate the Project, Zip file will be created, Open the zip file, extract all, open this project from eclipse, open eclipse, goto file, import, maven project, import existing project and select this repo folder in browse.
  * --InSide Code ---
  * Studentserviceapplication.java => This will be the starting point of every spring project, here we will have main class and annotation @SpringBootApplication. for more detail see code only, all explained in comment there
  * setting.xml => here add following settings for DB connection and port number in which port you want to run
    	spring.application.name=studentservice
	spring.datasource.url=jdbc:mysql://localhost:3306/librarymanagementsystem
	spring.datasource.username=root
	spring.datasource.password=Vicky1995@123  (Need to find way to encrypt this password)
	spring.datasource.driverClassName=com.mysql.jdbc.Driver (Deprecated in spring 3.x, only works in spring 2.x)
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver (Use this in spring 3.x)
	spring.datasource.initial-size=10  (This is the number of connection instance you want to create, so that multiple request from users come then make sure we have enough connection in our connection pool)
	server.port=1111 (Port in which you want to run this Rest Service
  * Now the connection details added, map the table with class entity
  * Don't make column names in caps in MySQL, as when mapping with the Entity Class, the columns was giving error
  * Update the SQL-connector dependency in pom.xml file to almost same version as your version in MySql server.
  * Example <dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.12</version>
		</dependency>
  * <version>8.0.12</version> This version is not important as they are not mySql connection we are using, but they are dependencies version, we can have 5.x version instead.
  * End
  * 
  * JAYSPT ENCRYPTION DEPENDENCIES FOR MYSQL PASSWORD IN ENCRYPTED FORM
    	* Dependency link : https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot-starter/3.0.5
  	* We can make use of jayspt dependencies to make our password encrypted : Watch this below youtube video to make it encrypted
    	* https://www.youtube.com/watch?v=SCOJ1zyGrE4&ab_channel=Easy2Excel
       	* Here you create the Encryption of your password, using two way and also add secret code so that during runtime it will decrypt and use : https://www.devglan.com/online-tools/jasypt-online-encryption-decryption
       	* Some new changes in default settings for jayspt 3.x, check below stackoverflow link:
       	* https://stackoverflow.com/questions/63999220/spring-boot-jasypt-failure-failed-to-bind-properties-under-spring-datasource-pa
       	* End
       	* 
  * SWAGGER DEPENDENCIES FOR SELF TESTING ALL THE APIS IN THIS STUDENT SERVICE
  	* !-- for swagger - just add below spring 3.x dependency and no need to do enable thing in main class 
	*	Use this url to check swagger working : http://localhost:8181/swagger-ui/index.html  
	*	Use this url to get the data in doc json format : http://localhost:8181/v3/api-docs
	*	For more detail learning follow this youtube video : https://www.youtube.com/watch?v=xZyUOhRpuQ0&ab_channel=ProgRank -
	*	dependency
	*	groupId>org.springdoc<groupId
	*	<artifactId>springdoc-openapi-starter-webmvc-ui<artifactId
	*	<version>2.0.3<version
	*	dependency
 
#### Now once the project is ready we can add Junit Test Cases and then deploy this project in docker in AWS, and then later we can move in next service viz book, bookIssue, payment etc.
	
* JUNIT TESTING (Done) (Includes Service Method Testing using mockito, Controller method Testing using mockito, ControllerMvc Url Testings using mockito and MockMvc, some simple test also added)
          * Unit Testing means testing a single method, so controller class and service class can have different methods, we need to test those.
   	  * Watch this youtube video for more details : https://www.youtube.com/watch?v=KwXl20f_v1w&list=PLUDwpEzHYYLtg-RO06RVFsauoAv241TNE&index=8&ab_channel=SDET-QA
	  * Check how it is done
          * Testing is done for Methods we have made in our service class.
          * Testing should be light weight, should not be time-consuming. So to test APIs related methods which call for DBs, we should better use mockito by mocking DB to test the methods.
     	* MOCKITO TESTING (TODO) : 
          * VERY IMP :  This is also JUNIT testing only, This is mainly used to test crud methods in Repository,
          * Here we mock the repository methods like (findAll(), findById(), etc)
          * Mocking means : To mock the repository methods like findAll(), So this method which is actually acessing data from DB, But instead we mock this method to return only our data
          * which we have added in our testClass, so it won't call data from DB, instead get data from that test class only which we will be preparing.
          * So in this way we can test our findAll() methods without actually depdending on DB. These methods are present in service class under it's methods, or say the methods
          * used in service class are dependent in this crud repository methods, and internally called.
          * -- Done--
	  * Why we need mock testing, mocking of database to test api's related service methods.
     	  * Because unit testing should be light, should not always connect with DB as it will be heavy and time consuming. so we test by mocking the DBs data.
          * Also sometimes we may not find DB accessible as it may be in maintenance, like in jenkins pipeline so better mock and test.
          * More detail learn here about why we need mocking testing for DBs : https://springframework.guru/mocking-unit-tests-mockito/
          * Implementation and understanding the working you can check this : https://www.youtube.com/playlist?list=PLUDwpEzHYYLtg-RO06RVFsauoAv241TNE
          * Using mokito and unit test : https://www.youtube.com/watch?v=_2fs_qjc0RQ&ab_channel=SDET-QA
          * IMP LEARNING : sometimes you get error in importing studentService in mockitoTestClass, then just hover over it, scroll down and there you find import. just import that and save.
          * To run the junit test : Just right click on the mockitoTestClass and run as Junit Test. You will see all the test and there success and failure.
        * MOCKMVC Testing  : To test Controller methods without starting the spring boot project.
* COMMAND LINE PASS STRING ARGS FOR PORT VALUE - Helpful when we want to run same service in different ports to scale our microservice.
	  * Check how it is done.
* DEPLOY IN DOCKER AWS (TODO)
	  * Check how we can deploy MySQL Server in AWS, And how connection string is picked there.
        * Also add try catch in Controller, just in case in findbyid, that id is not present then we need to throw some exception, That code you can check in mockito one only.
          * This will return HTTP Status exception



