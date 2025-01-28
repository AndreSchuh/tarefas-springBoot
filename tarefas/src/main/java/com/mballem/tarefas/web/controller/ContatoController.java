package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    // EXERCICIO 1
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato contact = contatoService.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    // EXERCICIO 2
    public Object getContatoById() {

        return null;
    }

    // EXERCICIO 3
    public Object getContatoByNome() {
        return null;
    }

    // EXERCICIO 4
    public Object getQuantidadeDeContatos() {

        return null;
    }

    // EXERCICIO 5
    public Object getContatosByDataNascimento() {

        return null;
    }

    // EXERCICIO 6
    public Object updateContatoById() {

        return null;
    }

    // EXERCICIO 7
    public Object deleteById() {

        return null;
    }
}
