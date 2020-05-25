package edu.pucmm.crud;

import edu.pucmm.crud.controllers.StudentsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses= StudentsController.class)
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

}
