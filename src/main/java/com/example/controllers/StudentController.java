package com.example.controllers;

import com.example.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    static List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student("Radek", "Kowalski", 21, "ADMIN"));
        students.add(new Student("John", "Smith", 22, "USER"));
        students.add(new Student("Mateusz", "Nowak", 23, "USER"));
    }

    @GetMapping(value = "/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello there...");
        return "helloWorld";
    }
    @GetMapping(value = "/")
    public @ResponseBody String test() {
        return "helloWorld";
    }

    @GetMapping(value = "/style")
    public String style() {
        return "add-css-js-demo";
    }
    @GetMapping(value = "/bootstrap")
    public String bootstrap() {
        return "add-bootstrap";
    }

    @GetMapping(value = "/iteration")
    public String iterate(Model model) {
//        List<Student> students = new ArrayList<>(List.of(
//                new Student("Radek", "Kowalski", 21),
//                new Student("John", "Smith", 22),
//                new Student("Mateusz", "Nowak", 23)
//                )
//            );
        model.addAttribute("students", students);
        return "iteration";
    }

    @GetMapping(value = "/if-students")
    public String ifStudents(Model model) {
        model.addAttribute("students", students);
        return "if-students";
    }

    @GetMapping(value = "/switch-students")
    public String switchStudents(Model model) {
        model.addAttribute("students", students);
        return "switch-students";
    }
}
