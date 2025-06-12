package com.example.Escola.services;

import com.example.Escola.model.AlunoModel;
import com.example.Escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public AlunoModel registrarAluno(AlunoModel aluno) {
        return repository.save(aluno);
    }

    public List<AlunoModel> listarAlunos() {
        return repository.findAll();
    }

    public Optional<AlunoModel> buscarPorId(Long id_aluno) {
        return repository.findById(id_aluno);
    }

    public void deletarAluno(Long id_aluno) {
        repository.deleteById(id_aluno);
    }

    public AlunoModel atualizarAluno(Long id_aluno, AlunoModel aluno) {
    aluno.setId_aluno(id_aluno);
    return repository.save(aluno); 
}
}
