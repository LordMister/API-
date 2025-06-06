package com.example.Escola.controller;

import com.example.Escola.model.AlunoModel;
import com.example.Escola.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(
    origins = "http://127.0.0.1:5500",
    allowedHeaders = "*"
)
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoModel> registrar(@RequestBody AlunoModel aluno) {
        return ResponseEntity.ok(service.registrarAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoModel>> listar() {
        return ResponseEntity.ok(service.listarAlunos());
    }

    @GetMapping("/{id_aluno}")
    public ResponseEntity<AlunoModel> buscar(@PathVariable Long id_aluno) {
        return service.buscarPorId(id_aluno)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_aluno}")
    public ResponseEntity<Void> deletar(@PathVariable Long id_aluno) {
        service.deletarAluno(id_aluno);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id_aluno}")
public ResponseEntity<AlunoModel> atualizar(@PathVariable Long id_aluno, @RequestBody AlunoModel aluno) {
    return ResponseEntity.ok(service.atualizarAluno(id_aluno, aluno));
}
}
