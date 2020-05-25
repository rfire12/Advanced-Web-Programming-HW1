package edu.pucmm.crud.controllers;

import edu.pucmm.crud.entities.Student;
import edu.pucmm.crud.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api")
public class StudentsController {
    @Autowired
    private StudentsServices studentsServices;

    @GetMapping("/students")
    public List<Student> ListStudents() {
        return studentsServices.findAll();
    }

    @GetMapping("/students/{id}")
    public Student ShowStudent(@PathVariable(value = "id") Long id) {
        return studentsServices.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find Student"));
    }

    @PostMapping("/students")
    public Student CreateStudent(@RequestBody Student student) {
        return studentsServices.save(student);
    }

    @PutMapping("/students/{id}")
    public Student UpdateStudent(@PathVariable(value = "id") Long id, @RequestBody Student student) {
        Student std = studentsServices.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find Student"));
        std.setFirstName(student.getFirstName());
        std.setLastName(student.getLastName());
        std.setPhoneNumber(student.getPhoneNumber());
        return studentsServices.save(std);
    }

    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> DeleteStudent(@PathVariable(value = "id") Long id) {
        Student std = studentsServices.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find student"));
        studentsServices.delete(std);

        Map<String, Boolean> response = new HashMap<>();
        response.put("success", true);
        return response;
    }
}
