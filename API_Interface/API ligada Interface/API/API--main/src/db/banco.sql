CREATE DATABASE Escolinha;
USE Escolinha;

CREATE TABLE IF NOT EXISTS Alunos (
    id_aluno BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
     email VARCHAR(30)
);

INSERT INTO Alunos (nome, email) VALUES 
('João da Silva', 'joao.silva@email.com'),
('Maria Oliveira', 'maria.oliveira@email.com'),
('Carlos Pereira', 'carlos.pereira@email.com');