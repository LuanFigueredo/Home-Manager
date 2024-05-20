CREATE TABLE patrimonio (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    fk_categoria INT NOT NULL,
    fk_marca INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_categoria) REFERENCES categoria(id),
    FOREIGN KEY (fk_marca) REFERENCES marca(id)
);