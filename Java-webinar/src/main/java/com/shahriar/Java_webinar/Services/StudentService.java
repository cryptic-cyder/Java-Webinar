package com.shahriar.Java_webinar.Services;

import com.shahriar.Java_webinar.Entity.StudentAccount;
import com.shahriar.Java_webinar.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public StudentAccount registration(StudentAccount student){



        return studentRepo.save(student);
    }

    public boolean passwordMatching(String gmail, String password){

        Optional<StudentAccount> studentOptional = studentRepo.findByEmail(gmail);

        if(studentOptional.isEmpty()){
            throw new NoSuchElementException("No such account is found");
        }

        StudentAccount student = studentOptional.get();
        String passwordFromDB = student.getPassword();

        if(password.equals(passwordFromDB))
            return true;

        return false;
    }
}
