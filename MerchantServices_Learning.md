# ABPA Merchant Services


## Spring Boot Project

### Internal Tech Stack Used within this project 

#### 1 (Done). Use of Jar file dependency in our project and Role of .m2 folder in Spring boot Application (Understand most of the concept, but better make your own sample project and check how it works)
* That is using other project in our project using the jar file.
* You can learn from this youtube to understand this concept
* https://www.youtube.com/watch?v=krtT499uI8Y&ab_channel=Easy2Excel
* To check the role of .m2 folder in our spring boot application, check this documentation : https://www.baeldung.com/maven-local-repository
  
#### 2 (Done). Multi Module Project (Understood most of the concept - Better Prepare a project of your own and try along)
* This is like we have small module project (Sub-module) within our project folder project.
* The root project will have the pom.xml file and other configurations.
* To Understand more about how to multi module projects works check this below Documentation link
* https://www.baeldung.com/maven-multi-module
* https://www.baeldung.com/spring-maven-bom
* For Understanding how Multi Module Services are created in Spring Root Project check this youtube video link : https://www.youtube.com/watch?v=QQ4oyr93B8k&ab_channel=EnggAdda
* Check how to run multiple spring modules at once, and they should be able to interact with each other.
* For that please check this below youtube link : https://www.youtube.com/watch?v=od6HHvuxgAo&list=PLJyMAT_Wb6qp9RiusxeWxvsfi7VeZtdcY&ab_channel=CodeForgeYT
* Here you can see how sub-module connect with some dependency managemet in pom.xml file of parent and sub-modules.
* Also check this video : Parent project is not of type of jar or war but of type pom (ignore this for now, as old video) : https://www.youtube.com/watch?v=YdAMoN1ZsXw&list=PLJyMAT_Wb6qp9RiusxeWxvsfi7VeZtdcY&index=7&ab_channel=ProDevAmit
* Also watch this video for understanding knowledge of module and some theory : https://www.youtube.com/watch?v=I1eE4BcI408&list=PLJyMAT_Wb6qp9RiusxeWxvsfi7VeZtdcY&index=2&ab_channel=GainJavaKnowledge
* Also check this (This is the recent videos) : https://www.youtube.com/watch?v=laF45Z2gI1I&ab_channel=ProgrammingKnowledge

#### 3 (Done). WebApplication Context and Servlet in Spring boot (This was extending SpringBootServletInitializer)
* So to learn about SpringBootServletInitializer (Check this documentation) : https://www.baeldung.com/spring-boot-servlet-initializer
* More about springboot initializer learn here : https://codippa.com/springboot-servletinitializer-example/
* https://www.concretepage.com/spring-boot/springbootservletinitializer-example
* Refer this docs also : https://docs.spring.io/spring-boot/api/java/org/springframework/boot/web/servlet/support/SpringBootServletInitializer.html
* THIS ONE IS VERY IMPORTANT AND IN DETAIL UNDERSTANDING OF SPRINGBOOTSERVLETINITIALIZER : https://howtodoinjava.com/spring-boot/spring-boot-servletinitializer/

#### 4 (Done). How to debug Spring boot project with frontend included
* You can debug by putting the break point, and on the main application file, right click and do debug as java application,
* This you can do the debug
* check this video of how debug works : https://www.youtube.com/watch?v=dqsTLFz4ers&ab_channel=LearnCodeWithDurgesh

#### 5. Logging in Spring Boot
* Check this youtube video
* https://www.youtube.com/watch?v=D7IVAidxcKE&list=PLzS3AYzXBoj8UcLsBN3UXd7Nf1T4ZyJa0&index=36&ab_channel=KKJavaTutorials
* 

#### 6. Mock Apis for frontend
* https://dev.to/sivaneshs/create-mock-apis-for-building-frontend-apps-quickly-without-the-backend-2lm2
* 

#### 7. IFlowConfiguration (To Understand the flow our project is doing within itself)
* Didn't find anything about this, May be it is company's own self made some library.
* This way of flow configuration using xml file is bit not implemented anywhere as checked in online.
* Need to ask to Padmarajan, what type of sub-technology is this.
* For now you can debug and check
* 

#### 8 (Ignore this as this is not spring related Project). HTTPServlet Request and Response 
* Learning
* Very very imp
* Servlet Lifecycle : first init(ServletConfig sc) method is called and then service(HttpServletRequest req, HttpServletResponse res) method. so this is the step
* During first request only object is called and init is called, later when it is reqeusted then it will start from service method only. Unless server is closed then and destroy method is called
* In Service method we can forward the HTML page, there only. You can make login page or signup page there only.
* xml is like html for servlet and java is backend.
* each servlet is mapped to there own url. servlet is web page. like each servlet is one web-page, and they can be form type and there you do crud operations also.
* servlet myapp project is stored in apache tomcat in web apps only folder only,,there you can check, as it is run from there only.
* ServletConfig and ServletContext : servlet config is used to read local servlet data <init-param> and servlet context is used to read global data <Context-param>. This is read from web.xml parameters
* ServletConfig reads all the data from web.xml file like driver, URL, username password under init tag, which is stored in ServletConfig class.
* This servlet also supports html tags in the strings.
* https://www.youtube.com/watch?v=vrNuroo9rmA&ab_channel=SumitThakkar
* This is the whole playlist on servlet : https://www.youtube.com/watch?v=XldqRAuvjdU&list=PLptQqlzcC-fNKxz_TPKFeYZElEDT2JfUF&ab_channel=SumitThakkar
* https://www.youtube.com/watch?v=XldqRAuvjdU&list=PLptQqlzcC-fNKxz_TPKFeYZElEDT2JfUF&ab_channel=SumitThakkar
* ALSO LEARN ABOUT SERVLET IN SPRING BOOT - HOW IT IS DONE
* 
#### 9. Spring MVC and WorkFlow using xml file (Which is a old way of doing configuration)
* This is spring MVC related project





