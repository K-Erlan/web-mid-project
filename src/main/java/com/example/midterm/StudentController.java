package com.example.midterm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping(path = "/getStudents")
    public String tablePage(Model model){
        List<Student> studentList = studentService.getStudents();
        model.addAttribute("studentList", studentList);
        return "table";
    }

    @GetMapping(path = "/addNewStudent")
    public String newStudentPage(Model model){
        model.addAttribute("student", new Student());
        return "newStudent";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/getStudents";
    }

    @RequestMapping(path = "/edit/{studentId}")
    public ModelAndView editStudent(
            @PathVariable ("studentId") Long studentId
    ){
        ModelAndView modelAndView = new ModelAndView("newStudent");
        Student student = studentService.getStudentById(studentId);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{studentId}")
    public String deleteStudent(
            @PathVariable ("studentId") Long studentId
    ){
        studentService.deleteStudent(studentId);
        return "redirect:/getStudents";
    }
}
