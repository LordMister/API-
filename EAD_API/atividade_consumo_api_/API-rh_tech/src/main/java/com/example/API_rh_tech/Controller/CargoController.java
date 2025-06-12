package com.example.API_rh_tech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_rh_tech.Model.CargoModel;
import com.example.API_rh_tech.Service.CargoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/cargos")

public class CargoController {

    @Autowired
    private CargoService cargoservice;
    
    @PostMapping
    public ResponseEntity<CargoModel> registrarCargo(@RequestBody CargoModel cargoModel) {
        return ResponseEntity.ok(cargoservice.registrarCargo(cargoModel));

    }

    @GetMapping 
    public ResponseEntity<List<CargoModel>> listarcargo() {
        return ResponseEntity.ok(cargoservice.listarcargo());
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<CargoModel> buscarCargo (@PathVariable Long id) {
        return cargoservice.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
     

    @DeleteMapping
    public ResponseEntity<Void> deletarcargo(@PathVariable Long id) {
       cargoservice.deletarcargo(id);
       return ResponseEntity.noContent().build();

    }

    @PutMapping ("/{id}")
    public ResponseEntity<CargoModel> atualizarcargo (@PathVariable Long id, @RequestBody CargoModel cargoModel) {
       return ResponseEntity.ok(cargoservice.atualizaCargoModel(id, cargoModel));
    }   

}
