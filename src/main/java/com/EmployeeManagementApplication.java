package com;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.service.EmployeeService;
import com.EmployeeManagement.service.HumanResourcesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EmployeeManagementApplication.class, args);

        ApplicationContext context = SpringApplication.run(EmployeeManagementApplication.class, args);

        EmployeeService llst = context.getBean(EmployeeService.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(llst.addEmployee(new Employee()));
        }
    }

}
