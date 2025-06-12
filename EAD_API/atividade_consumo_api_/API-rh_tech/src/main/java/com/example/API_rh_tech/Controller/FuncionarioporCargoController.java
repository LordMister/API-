package com.example.API_rh_tech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_rh_tech.Model.FuncionarioporCargoModel;

import com.example.API_rh_tech.Service.FuncionarioporCargoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RequestMapping ("/api/alocar")
@RestController
@CrossOrigin (origins = "*")

public class FuncionarioporCargoController {

    @Autowired
    private FuncionarioporCargoService service;

 @PostMapping
 public ResponseEntity<FuncionarioporCargoModel> registrar(@RequestBody FuncionarioporCargoModel funcionarioporCargoModel){
    return ResponseEntity.ok(service.registrarPorCargo(funcionarioporCargoModel));
 }

 @GetMapping
 public ResponseEntity<List<FuncionarioporCargoModel>> listar(){
    return ResponseEntity.ok(service.listar());
    
 }
 
 @GetMapping ("/{id}")
 public ResponseEntity<FuncionarioporCargoModel> buscar(@PathVariable Long id){
    return service.buscarPorId(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
    
 }

 @PutMapping ("/{id}")
 public ResponseEntity<FuncionarioporCargoModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioporCargoModel funcionarioporCargoModel) {
    return ResponseEntity.ok(service.atualizarPorCargo(id, funcionarioporCargoModel));

 }
    
@DeleteMapping ("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) {
     service.DeletarPorCargo(id);
    return (ResponseEntity.noContent().build());
}

}
