package org.m.practice.Controllers;

import org.m.practice.Entities.Student;
import org.m.practice.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String listStudents(Model model)
    {
        model.addAttribute("students",studentService.GetAllStudents());
        return "students";
    }
    @GetMapping("/students/new")
    public String CreateStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return  "create_student";

    }
    @PostMapping("/students")
    public String SaveStudent(@ModelAttribute("student")Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public  String editStudentForm(@PathVariable Long id,Model model)
    {
        model.addAttribute("student", studentService.getByID(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
    @ModelAttribute("student") Student student,Model model)
    {
     Student existingStudent = studentService.getByID(id);
     existingStudent.setId(id);
     existingStudent.setFirstName(student.getFirstName());
     existingStudent.setLastName(student.getLastName());
     existingStudent.setEmail(student.getEmail());

    studentService.updateStudent(existingStudent);
    return"redirect:/students";
    }
    @GetMapping("/students/{id}")
    public  String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return "redirect:/students";

    }
}
