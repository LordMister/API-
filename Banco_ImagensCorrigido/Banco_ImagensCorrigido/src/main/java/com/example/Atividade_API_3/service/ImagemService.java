package com.example.Atividade_API_3.service;

import com.example.Atividade_API_3.model.ImagemModel;
import com.example.Atividade_API_3.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository repository;

    public ImagemModel salvar(ImagemModel imagem) {
        return repository.save(imagem);
    }

    public List<ImagemModel> listar() {
        return repository.findAll();
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

    public ImagemModel atualizar(Long id, ImagemModel imagem) {
        imagem.setId(id);
        return repository.save(imagem);
    }
}