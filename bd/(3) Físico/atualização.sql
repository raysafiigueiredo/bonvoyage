-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Pacote (
id_pacote INTEGER PRIMARY KEY,
nome VARCHAR(10),
preco DECIMAL(10),
promocao DECIMAL(10)
);

CREATE TABLE Passageiro (
id_passageiro INTEGER PRIMARY KEY,
nome VARCHAR(50),
idade INTEGER,
genero VARCHAR(10),
telefone VARCHAR(11),
endereco VARCHAR(100),
email VARCHAR(30),
senha VARCHAR(10)
);

CREATE TABLE Reserva (
id_reserva VARCHAR(10) PRIMARY KEY,
id_pacote INTEGER,
id_destino INTEGER,
id_passageiro INTEGER,
checkin VARCHAR(10),
checkout VARCHAR(10),
status BOOLEAN,
FOREIGN KEY(id_pacote) REFERENCES Pacote (id_pacote),
FOREIGN KEY(id_passageiro) REFERENCES Passageiro (id_passageiro)
);

CREATE TABLE Destino (
id_destino INTEGER PRIMARY KEY,
nome VARCHAR(50)
);

ALTER TABLE Reserva ADD FOREIGN KEY(id_destino) REFERENCES Destino (id_destino)
