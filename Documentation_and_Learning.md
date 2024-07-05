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
* 1. StudentService
  * Don't make column names in caps in MySQL, as when mapping with the Entity Class, the columns was giving error
  * Update the SQL-connector dependency in pom.xml file to almost same version as your version in MySql server.
  * Example <dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.12</version>
		</dependency>
  * My mysql --version in my local machine was : 8.0.37
  * Connection settings in the settings.xml file will be same as we have written here. But you can check for port number and how to make password as encrypted form => NEED TO CHECK <=




