package com.abutua.cadastro_alunos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "API de Cadastro de Alunos rodando com sucesso!";
    }
}
