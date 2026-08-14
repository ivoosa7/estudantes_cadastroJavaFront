package com.abutua.cadastro_alunos.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.cadastro_alunos.models.Student;

@RestController
public class StudentController {
    //Creating a mock list of students
    private final List<Student> students = Arrays.asList(

        new Student(1, "João Silva", "joao.silva@example.com", "123456789", 1, 2),
        new Student(2, "Maria Oliveira", "maria.oliveira@example.com", "987654321", 2, 3),
        new Student(3, "Pedro Santos", "pedro.santos@example.com", "456789123", 3, 1),
        new Student(4, "Ana Costa", "ana.costa@example.com", "321654987", 4, 4),
        new Student(5, "Lucas Pereira", "lucas.pereira@example.com", "654987321", 5, 2)
    );

    // Endpoint to get all students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // Endpoint to get a specific student by ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return students.stream()
                    .filter(student -> student.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado!"));
    }
}
