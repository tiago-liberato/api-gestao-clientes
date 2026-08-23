# API Gestão de Clientes
## Objetivo
O presente projeto consiste em uma atividade prática realizada durante o **Bootcamp Java Santander - 2026**, a qual tem como objeto de estudo o uso de padrões de projetos pelo spring framework.
Escolhi como projeto uma API simplificada de gestão de clientes, que fornece operações de CRUD em banco MySQL utilizando Docker, além de consumir a api ViaCep para busca de endereço completo com base no CEP.



## Funcionalidades

- Cadastro, consulta, atualização e remoção de clientes (CRUD completo)
- Validação de CPF
- Busca automática de endereço a partir do CEP informado (integração com ViaCEP)
- Reutilização de endereços já cadastrados para o mesmo CEP
- Documentação interativa da API via Swagger/OpenAPI

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA / Hibernate
- MySQL 8.0
- Flyway (migrations de banco de dados)
- Docker para banco de dados
- Lombok
- SpringDoc OpenAPI (Swagger UI)
- OpenFeign (integração com a API ViaCEP)

## Pré-requisitos

- [Docker](https://www.docker.com/)
- Java 21 (JDK)
- Maven 3.9+

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/GestaoClientes.git
cd GestaoClientes
```

### 2. Configure as variáveis de ambiente

Copie o arquivo de exemplo e ajuste os valores:

```bash
cp .env.exemplo .env
```

Edite o `.env` com uma senha de sua escolha:

```
MYSQL_DATABASE=DB_Clients
MYSQL_ROOT_PASSWORD=sua_senha_aqui
```

### 3. Execute a aplicação

O projeto usa `spring-boot-docker-compose`, então o container MySQL é iniciado automaticamente ao rodar a aplicação (não é necessário `docker compose up` manual):

```bash
mvn clean spring-boot:run
```

O Flyway aplica automaticamente as migrations e cria as tabelas na primeira execução.

A aplicação estará disponível em `http://localhost:8080`.

### 4. Acesse a documentação da API

Com a aplicação rodando, acesse:

```
http://localhost:8080/swagger-ui.html
```

## Endpoints principais

| Método | Endpoint          | Descrição                          |
|--------|-------------------|-------------------------------------|
| GET    | `/clientes`       | Lista todos os clientes             |
| GET    | `/clientes/{id}`  | Busca um cliente por ID             |
| POST   | `/clientes`       | Cadastra um novo cliente            |
| PUT    | `/clientes/{id}`  | Atualiza um cliente existente       |
| DELETE | `/clientes/{id}`  | Remove um cliente                   |

### Exemplo de requisição (POST /clientes)

```json
{
  "name": "Tiago",
  "cpf": "097.436.923-39",
  "endereco": {
    "cep": "62748-000"
  }
}
```

O endereço completo é preenchido automaticamente a partir do CEP informado.

## Estrutura do banco de dados

- **cliente**: dados do cliente (nome, CPF) e referência ao endereço
- **endereco**: dados de endereço, obtidos e cacheados a partir da API ViaCEP por CEP

As migrations do Flyway estão em `src/main/resources/db/migration`.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.