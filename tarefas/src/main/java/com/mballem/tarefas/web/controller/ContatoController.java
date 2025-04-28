package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    @GetMapping("/getContatoById/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato contato = contatoService.getById(id);
        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 3
    @GetMapping("/getContatoByNome/{nome}")
    public ResponseEntity<Contato> getContatoByNome(@PathVariable String nome) {
        Contato contato = contatoService.getContatoByNome(nome);
        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 4
    @GetMapping("/getQuantidadeDeContatos")
    public ResponseEntity<Integer> getQuantidadeDeContatos() {
        int contatos = contatoService.getAll();
        return ResponseEntity.ok(contatos);
    }

    // EXERCICIO 5
    @GetMapping("/getContatoByDataNascimento/{date}")
    public ResponseEntity<List<Contato>> getContatosByDataNascimento(@PathVariable LocalDate date) {
        List<Contato> contatos = contatoService.getByDataNascimento(date);
        return ResponseEntity.ok(contatos);
    }

    // EXERCICIO 6
    @PatchMapping("/updateContato/{id}")
    public ResponseEntity<Contato> updateContatoById(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        Contato contato = contatoService.update(id, contatoAtualizado);
        return ResponseEntity.ok(contato);
    }

    // EXERCICIO 7
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String resultado = contatoService.delete(id);
        return ResponseEntity.ok(resultado);
    }
}
