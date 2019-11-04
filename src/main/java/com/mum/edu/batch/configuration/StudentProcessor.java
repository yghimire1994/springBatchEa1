package com.mum.edu.batch.configuration;

import com.mum.edu.batch.dao.entity.Student;

import org.springframework.batch.item.ItemProcessor;

import java.sql.Date;
import java.time.LocalDate;

public class StudentProcessor implements ItemProcessor<Student, Student>{

    @Override
    public Student process(final Student student) {
        final String firstName = student.getFirstName();
        final String lastName = student.getLasttName();
        final double gpa = student.getGpa();
        final int age = student.getAge();
        LocalDate currentDate = LocalDate.now().withDayOfMonth(1);
        Date dob = java.sql.Date.valueOf(LocalDate.of(currentDate.getYear()-student.getAge(),currentDate.getMonth(),currentDate.getDayOfMonth()));


        System.out.println("processed data ======"+ student.getFirstName()+","+student.getLasttName());

        final Student processedStudent = new Student();
        processedStudent.setFirstName(firstName);
        processedStudent.setLasttName(lastName);
        processedStudent.setGpa(gpa);
        processedStudent.setAge(age);
        processedStudent.setDob(dob);


        return processedStudent;
    }
}
