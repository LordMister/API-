package com.example.API_rh_tech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_rh_tech.Model.FuncionarioModel;
import com.example.API_rh_tech.Service.FuncionarioService;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("/api/funcionario")
@RestController
@CrossOrigin(
    origins = "*"
)


public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    
    @PostMapping
    public ResponseEntity<FuncionarioModel> registrar(@RequestBody FuncionarioModel funcionarioModel) {
        return ResponseEntity.ok(service.registrarFuncionario(funcionarioModel));
    }
    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listar() {
        return ResponseEntity.ok(service.listarFuncionario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

  @PutMapping("/{id}")
  public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel) {
      return ResponseEntity.ok(service.atualizarFuncionario(id, funcionarioModel));
  }

}
