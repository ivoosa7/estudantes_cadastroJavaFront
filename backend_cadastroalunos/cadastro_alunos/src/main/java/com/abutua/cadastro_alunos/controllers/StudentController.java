package com.abutua.cadastro_alunos.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
