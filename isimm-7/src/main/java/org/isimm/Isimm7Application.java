package org.isimm;

import org.isimm.dao.StudentRepository;
import org.isimm.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class Isimm7Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Isimm7Application.class, args);
        StudentRepository studentDao = ctx.getBean(StudentRepository.class);
    }

}
