package com.example.Atividade_API_3.repository;

import com.example.Atividade_API_3.model.ImagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<ImagemModel, Long> {
}