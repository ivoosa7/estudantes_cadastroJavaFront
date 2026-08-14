package com.abutua.cadastro_alunos.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.cadastro_alunos.models.Student;

@RestController
public class StudentController {
    //Creating a mock list of students
    private final List<Student> students;

        //new Student(1, "João Silva", "joao.silva@example.com", "123456789", 1, 2),
        //new Student(2, "Maria Oliveira", "maria.oliveira@example.com", "987654321", 2, 3),
        //new Student(3, "Pedro Santos", "pedro.santos@example.com", "456789123", 3, 1),
        //new Student(4, "Ana Costa", "ana.costa@example.com", "321654987", 4, 4),
        //new Student(5, "Lucas Pereira", "lucas.pereira@example.com", "654987321", 5, 2)

    public StudentController(){
        this.students = new ArrayList<>();
    }

    // Endpoint to add a new student (mock implementation)
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(students.size() + 1); // Mock ID assignment
        students.add(student);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(student.getId())
                        .toUri();

        return ResponseEntity.created(location).body(student);      
    }

    // Endpoint to get a specific student by ID
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student student = students.stream()
                                .filter(s -> s.getId() == id)
                                .findFirst()
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado!"));
        return ResponseEntity.ok(student);  
    }

    // Endpoint to get all students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

}
