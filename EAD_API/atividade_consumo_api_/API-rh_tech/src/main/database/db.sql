-- Active: 1747265743914@@127.0.0.1@3306@rh_tech
CREATE DATABASE RH_Tech;

USE RH_Tech;

CREATE TABLE funcionario (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(50) NOT NULL,
senha VARCHAR(50) NOT NULL,
cep VARCHAR(8) NOT NULL,
endereco VARCHAR(50) NOT NULL,
numero INTEGER NOT NULL,
bairro VARCHAR(50) NOT NULL,
cidade VARCHAR(30) NOT NULL,
estado VARCHAR(30) NOT NULL

);

CREATE TABLE cargos (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
descricao VARCHAR(100) NOT NULL
);

INSERT INTO funcionarios (nome, email, senha, cep, endereco, numero, bairro, cidade, estado) VALUES
('Ana Paula', 'ana.paula@email.com', 'senha123', '01311000', 'Rua Augusta', 1500, 'Consolação', 'São Paulo', 'SP'),
('Carlos Silva', 'carlos.silva@email.com', 'senha456', '20040002', 'Av. Rio Branco', 45, 'Centro', 'Rio de Janeiro', 'RJ'),
('Juliana Rocha', 'juliana.rocha@email.com', 'senha789', '30140071', 'Rua da Bahia', 120, 'Lourdes', 'Belo Horizonte', 'MG'),
('Fernando Souza', 'fernando.souza@email.com', 'senha321', '80010010', 'Av. Cândido de Abreu', 800, 'Centro Cívico', 'Curitiba', 'PR');

INSERT INTO cargos (nome, descricao) VALUES
('Administrador', 'Responsável por gerenciar o sistema'),
('Atendente', 'Atende clientes e agenda serviços'),
('Cuidador', 'Responsável pelo cuidado direto dos idosos'),
('Enfermeiro', 'Presta cuidados de enfermagem aos pacientes');


