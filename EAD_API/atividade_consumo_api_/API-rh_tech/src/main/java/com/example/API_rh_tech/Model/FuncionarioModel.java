package com.example.API_rh_tech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
public class FuncionarioModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String nome;
private String email;
private String senha;
private String cep; 
private String endereco; 
private int numero;
private String bairro; 
private String cidade; 
private String estado; 

}
