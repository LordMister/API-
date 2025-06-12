package com.example.API_rh_tech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "cargos")
@Getter
@Setter

public class CargoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

 private Long id; 
 private String nome;
 private String descricao;
 
}
