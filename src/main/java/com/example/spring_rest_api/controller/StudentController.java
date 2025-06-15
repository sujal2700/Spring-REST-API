package com.example.spring_rest_api.controller;

import com.example.spring_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student= new Student(1, "Sujal", "Singh");
      //  return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","sujal")
                .body(student);
    }

    @GetMapping("students")
    public ResponseEntity <List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "ABC", "DEF"));
        students.add(new Student(2, "ABC", "DEF"));
        students.add(new Student(3, "ABC", "DEF"));
        return ResponseEntity.ok(students);
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentID,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
            Student student = new Student(studentID, firstName, lastName);
            return ResponseEntity.ok(student);
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName)
                                          {
        return new Student(id, firstName, lastName);
    }

    // Spring boot REST API that handles HTTP POST Request
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
         return student;
    }
    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentID){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Details deleted successfully!";
    }
}
