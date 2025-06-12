package com.example.API_rh_tech.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "funcionario_por_cargo")
@Getter
@Setter

public class FuncionarioporCargoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long funcionario_id;
    private Long cargo_id;
    private String detalhes;
    private Date data_inicio;
    private Date data_fim;

}
