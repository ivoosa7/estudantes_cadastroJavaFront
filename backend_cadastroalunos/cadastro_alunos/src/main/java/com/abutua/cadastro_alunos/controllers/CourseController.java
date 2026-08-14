package com.abutua.cadastro_alunos.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.cadastro_alunos.models.Course;

@RestController
public class CourseController {
    // Criando uma lista mock de cursos
    private final List<Course> courses = Arrays.asList(
        new Course(1, "Inteligência Artificial"),
        new Course(2, "Desenvolvimento Web"),
        new Course(3, "Banco de Dados"),
        new Course(4, "Redes de Computadores"),
        new Course(5, "Segurança da Informação")
    );

    // Endpoint para obter um curso específico pelo ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById (@PathVariable int id){
        Course course = courses.stream()
                            .filter(c -> c.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!")); 
                            //Retorna 404 se o curso não for encontrado e lança uma exceção com a mensagem "Curso não encontrado"
        return ResponseEntity.ok(course);
    }

    // Endpoint para obter todos os cursos
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courses;
    }
}
