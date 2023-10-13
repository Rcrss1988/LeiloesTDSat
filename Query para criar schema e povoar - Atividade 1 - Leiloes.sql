create schema leiloes_td_sat;

use leiloes_td_sat;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor INT NOT NULL,
    status VARCHAR(255) NOT NULL
);

-- Inserir produtos de leilão
INSERT INTO produtos (nome, valor, status)
VALUES
    ('Pintura a Óleo do Século XIX', 5000.00, 'Ativo'),
    ('Relógio de Bolso Antigo', 1500.00, 'Ativo'),
    ('Moeda Rara de Ouro', 20000.00, 'Ativo'),
    ('Móvel Antigo de Madeira Maciça', 2500.00, 'Ativo'),
    ('Violino Vintage', 3500.00, 'Ativo');

