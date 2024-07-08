package com.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/** #Theory
// This SpringBootApplication, is what makes this project as spring boot project
// Unlike Spring Project, where in MVC Project to create REST Api,
// we had to build Appconfig.java class (Configuration.xml type)
// for configuration of all beans
// and we also had AppInitializer class to initialize the beans. here this task will be done automatically internally
// if we use this @SpringBootApplication annotation.

# Spring boot auto configuration Working :
-his will find the libraries in the class path and create the configuration beans automatically
-example: spring boot auto configuration will find mvc libraries in the class path and create mvc configuration beans automatically
-when we add spring-boot-starter-web in pom. xm1, the mvc libraries will be added to classpath
-WebMvcAutoConfiguration : @EnableMvc - enable mvc functionality register dispatcher servlet
-which AppInitializer.java is doing
-@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration
-@Configuration (create spring beans)
-@ComponentScan ( scan for the @Component and create spring beans)
-@EnableAutoConfiguration (will trigger the auto configuration functionality)
**/ 


@SpringBootApplication
@EnableEncryptableProperties
//@EnableSwagger3
public class StudentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentserviceApplication.class, args);
	}

}
