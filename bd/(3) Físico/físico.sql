-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Destination (
id_destino VARCHAR(10) PRIMARY KEY,
nome VARCHAR(10),
categoria VARCHAR(10),
condicao VARCHAR(10),
preco VARCHAR(10),
quantidade VARCHAR(10)
)

CREATE TABLE Reservation (
id_reserva VARCHAR(10) PRIMARY KEY,
data VARCHAR(10),
checkin VARCHAR(10),
checkout VARCHAR(10),
pagamento VARCHAR(10),
total VARCHAR(10),
status VARCHAR(10),
id_destino VARCHAR(10),
id_cliente VARCHAR(10),
FOREIGN KEY(id_destino) REFERENCES Destination (id_destino)
)

CREATE TABLE Cliente (
id_cliente VARCHAR(10) PRIMARY KEY,
nome VARCHAR(10),
email VARCHAR(10),
senha VARCHAR(10),
cadastrado VARCHAR(10),
logado INTEGER,
data_nascimento VARCHAR(10),
telefone VARCHAR(10),
documento VARCHAR(10),
sexo VARCHAR(10)
)

ALTER TABLE Reservation ADD FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente)
