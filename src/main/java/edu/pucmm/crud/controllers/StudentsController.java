package edu.pucmm.crud.controllers;

import edu.pucmm.crud.entities.Student;
import edu.pucmm.crud.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("")
public class StudentsController {
    @Autowired
    private StudentsServices studentsServices;

    @GetMapping("/")
    public ModelAndView main() {
        var params = new HashMap<String, Object>();
        params.put("students", studentsServices.findAll());
        return new ModelAndView("main", params);
    }

    @GetMapping("/crear-estudiante")
    public ModelAndView createStudent() {
        var params = new HashMap<String, Object>();
        Student student = new Student((long) 0,"","","");
        params.put("student", student);
        params.put("mode_title", "Crear");
        params.put("id_enabled", "true");
        params.put("method", "POST");
        return new ModelAndView("formulario", params);
    }

    @GetMapping("/modificar-estudiante/{id}")
    public ModelAndView editStudent(@PathVariable(value = "id") Long id) {
        var params = new HashMap<String, Object>();
        Student student = studentsServices.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find Student"));
        params.put("student", student);
        params.put("mode_title", "Editar");
        params.put("id_enabled", "false");
        params.put("method", "PUT");
        return new ModelAndView("formulario", params);
    }


    @PostMapping("/students")
    public String CreateStudent(@RequestBody Student student) {
        studentsServices.save(student);
        return "redirect:/";
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
