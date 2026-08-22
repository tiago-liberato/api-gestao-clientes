CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(9) NOT NULL UNIQUE,
    logradouro VARCHAR(200),
    complemento VARCHAR(100),
    unidade VARCHAR(50),
    bairro VARCHAR(100),
    localidade VARCHAR(100),
    uf CHAR(2),
    estado VARCHAR(50),
    regiao VARCHAR(50),
    ibge VARCHAR(20),
    gia VARCHAR(20),
    ddd VARCHAR(5),
    siafi VARCHAR(10)
) ENGINE=InnoDB;

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    endereco_id BIGINT NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
) ENGINE=InnoDB;