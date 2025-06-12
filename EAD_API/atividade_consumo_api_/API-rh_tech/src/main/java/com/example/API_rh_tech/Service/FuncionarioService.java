package com.example.API_rh_tech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_rh_tech.Model.FuncionarioModel;
import com.example.API_rh_tech.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioModel registrarFuncionario(FuncionarioModel funcionario) {
        return repository.save(funcionario);
    }

    public List<FuncionarioModel> listarFuncionario() {
        return repository.findAll();
    }

    public Optional<FuncionarioModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarFuncionario(Long id) {
        repository.deleteById(id);
    }

    public FuncionarioModel atualizarFuncionario(Long id, FuncionarioModel funcionarioModel) {
       funcionarioModel.setId(id);
       return repository.save(funcionarioModel);
    }

}
