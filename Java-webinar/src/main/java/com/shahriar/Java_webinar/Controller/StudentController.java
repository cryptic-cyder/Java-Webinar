package com.shahriar.Java_webinar.Controller;


import com.shahriar.Java_webinar.Entity.StudentAccount;
import com.shahriar.Java_webinar.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Registration Page - GET method
    @GetMapping("/showRegister")
    public ModelAndView showRegistrationForm() {

        ModelAndView modelAndView = new ModelAndView("Registration");

        return modelAndView;
    }

    // Registration Submission - POST method
    @PostMapping("/register")
    public ModelAndView registerStudent(StudentAccount student) {

        studentService.registration(student);

        ModelAndView modelAndView = new ModelAndView("Login");

        modelAndView.addObject("successMessage", "Registration successful! Please login.");

        return modelAndView;
    }

    // Login Page - GET method
    @GetMapping("/ShowLogin")
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView("Login");
        return modelAndView;
    }

    // Login Submission - POST method
    @PostMapping("/login")
    public ModelAndView loginStudent(String email, String password) {

        ModelAndView modelAndView;

        boolean student = studentService.passwordMatching(email, password);
        if (student) {

            modelAndView = new ModelAndView("Welcome");
            return modelAndView;
        }

        modelAndView = new ModelAndView("Login");

        return modelAndView;
    }
}
