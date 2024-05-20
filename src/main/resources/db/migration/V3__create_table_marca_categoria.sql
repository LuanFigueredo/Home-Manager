CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    grupo ENUM('Patrimonio', 'Mercado', 'Farmacia'),
    PRIMARY KEY (id)
);

CREATE TABLE categoria (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    grupo ENUM('Patrimonio', 'Mercado', 'Farmacia'),
    PRIMARY KEY (id)
);