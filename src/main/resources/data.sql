CREATE TABLE Pessoa (
    id INT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL
);

INSERT INTO Pessoa (id, nome, data_nascimento)
VALUES
    (1, 'Fulano de Tal', '1990-01-01');