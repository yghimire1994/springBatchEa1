package com.mum.edu.batch.controller;

import com.mum.edu.batch.dao.entity.Student;
import com.mum.edu.batch.dao.repository.IStudentRepository;
import com.mum.edu.batch.configuration.BatchConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Import(BatchConfiguration.class)
@EnableBatchProcessing
public class BatchController {
        @Autowired
        JobLauncher jobLauncher;

        @Autowired
        Job job;

        @Autowired
        IStudentRepository studentRepository;

        @RequestMapping("/processJob")
        public void handle() throws Exception{
//            jobLauncher.run(job, new JobParameters());
            try {
                JobParameters jobParameters =
                        new JobParametersBuilder()
                                .addLong("time",System.currentTimeMillis()).toJobParameters();

                JobExecution execution = jobLauncher.run(job, jobParameters);
                System.out.println("Exit Status : " + execution.getStatus());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @ResponseBody
    @RequestMapping("/displayData")
    public List<Student> getData(){
            return studentRepository.findAll();
        }
    }
