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

CREATE TABLE funcionario_por_cargo (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
funcionario_id BIGINT,
cargo_id BIGINT,
detalhes VARCHAR(100),
data_inicio DATE,
data_fim DATE,
FOREIGN KEY (funcionario_id) REFERENCES funcionario(id),
FOREIGN KEY (cargo_id) REFERENCES cargos(id)

);

INSERT INTO funcionario (nome, email, senha, cep, endereco, numero, bairro, cidade, estado) VALUES
('Ana Paula', 'ana.paula@email.com', 'senha123', '01311000', 'Rua Augusta', 1500, 'Consolação', 'São Paulo', 'SP'),
('Carlos Silva', 'carlos.silva@email.com', 'senha456', '20040002', 'Av. Rio Branco', 45, 'Centro', 'Rio de Janeiro', 'RJ'),
('Juliana Rocha', 'juliana.rocha@email.com', 'senha789', '30140071', 'Rua da Bahia', 120, 'Lourdes', 'Belo Horizonte', 'MG'),
('Fernando Souza', 'fernando.souza@email.com', 'senha321', '80010010', 'Av. Cândido de Abreu', 800, 'Centro Cívico', 'Curitiba', 'PR');

INSERT INTO cargos (nome, descricao) VALUES
('Administrador', 'Responsável por gerenciar o sistema'),
('Atendente', 'Atende clientes e agenda serviços'),
('Cuidador', 'Responsável pelo cuidado direto dos idosos'),
('Enfermeiro', 'Presta cuidados de enfermagem aos pacientes');

INSERT INTO funcionario_por_cargo (funcionario_id, cargo_id, detalhes, data_inicio, data_fim) VALUES
(1, 1, 'Admin principal do sistema', '2024-01-10', NULL),
(2, 2, 'Atendimento no turno da manhã', '2024-02-01', NULL),
(3, 3, 'Cuidadora da ala feminina', '2024-03-05', NULL),
(4, 4, 'Responsável pela medicação noturna', '2024-04-01', NULL);


