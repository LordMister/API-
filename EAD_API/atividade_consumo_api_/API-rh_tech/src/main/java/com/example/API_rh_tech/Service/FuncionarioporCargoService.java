package com.example.API_rh_tech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_rh_tech.Model.FuncionarioporCargoModel;
import com.example.API_rh_tech.Repository.FuncionarioporCargoRepository;

@Service
public class FuncionarioporCargoService {
    
    @Autowired
    private FuncionarioporCargoRepository repository;

    public FuncionarioporCargoModel registrarPorCargo(FuncionarioporCargoModel funcionarioporCargoModel) {
            return repository.save(funcionarioporCargoModel);
    }

    public List<FuncionarioporCargoModel> listar() {
           return repository.findAll();
    }

    public Optional<FuncionarioporCargoModel> buscarPorId(Long id){
          return repository.findById(id);
    }

    public void DeletarPorCargo (Long id){
        repository.deleteById(id);
    }

    public FuncionarioporCargoModel atualizarPorCargo(Long id, FuncionarioporCargoModel funcionarioporCargoModel) {
        funcionarioporCargoModel.setId(id);
        return repository.save(funcionarioporCargoModel);


    }

}
