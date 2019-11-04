package com.mum.edu.batch.configuration;

import com.mum.edu.batch.dao.entity.Student;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

@Component
public class StudentFieldSetMapper implements FieldSetMapper<Student> {

    @Override
    public Student mapFieldSet(FieldSet fieldSet) {
        final Student student = new Student();

        student.setFirstName(fieldSet.readString("first_name"));
        student.setLasttName(fieldSet.readString("last_name"));
        student.setGpa(fieldSet.readDouble("gpa"));
        student.setAge(fieldSet.readInt("age"));
        return student;

    }
}
