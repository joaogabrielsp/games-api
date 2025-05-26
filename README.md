# API de Jogos

## Sobre o projeto

Esta API RESTful foi desenvolvida em Java com Spring Boot, seguindo o padrão de Arquitetura em Camadas (Layered Architecture), garantindo a separação de responsabilidades e uma melhor organização do código.

O projeto foi criado durante o intensivo de Java Spring do [DevSuperior](https://github.com/devsuperior), ministrado pelo professor Nélio Alves. O código é baseado no material do curso e adaptado para fins de estudo e prática pessoal.

A API permite consultar e organizar uma base de dados de jogos, oferecendo endpoints para recuperar informações e modificar a ordem dos jogos nas listas.

### Diagrama da Arquitetura

![image](https://github.com/user-attachments/assets/16888315-48a9-46bc-b528-1b55d35b1bd0)

### Modelo de domínio

![image](https://github.com/user-attachments/assets/2664e82a-4acb-4839-a2c0-df257515d3f9)

## Tecnologias utilizadas

- **Java** - Linguagem principal do back-end
- **Spring Boot** - Framework para aplicação web
- **Spring Data JPA** - Abstração para persistência de dados
- **Maven** - Gerenciador de dependências
- **PostgreSQL** - Banco de dados relacional principal
- **H2 Database** - Banco de dados em memória para testes
- **Postman** - Teste de endpoints

## Endpoints Disponíveis

A API possui cinco endpoints:

### 1. Listar todos os jogos

![image](https://github.com/user-attachments/assets/dd27c879-c979-49ce-8a8e-6c0e107107af)

  
### 2. Buscar Jogo por ID

![image](https://github.com/user-attachments/assets/942834c2-59d3-4619-82a4-3d2b1ef47a7c)

  
### 3. Listar Categorias de Jogos

![image](https://github.com/user-attachments/assets/b22dd50f-5a6b-46b4-9425-65d9f1d061ac)

  
### 4. Listar Jogos por Categoria

![image](https://github.com/user-attachments/assets/d1d01848-c9c2-4e4a-a2b4-6c21a316b8b6)

  
### 5. Alterar Ordem dos Jogos na Lista

![image](https://github.com/user-attachments/assets/f33b986f-8280-44a4-a1af-881abde23e39)

## Como Executar o Projeto

### Pré-requisitos

- JDK +17
- Maven
- PostgreSQL
- Postman (opcional, para testar os endpoints)

### Passos para Rodar

#### 1. Clone o repositório:

```

git clone https://github.com/joaogabrielsp/games-api.git

```
   
#### 2. Acesse o diretório do projeto:

```

cd games-api

```

   
#### 3. Configure o ambiente

#### application.properties

```
spring.profiles.active=${APP_PROFILE:test}
spring.jpa.open-in-view=false

cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
```

#### system.properties

```

java.runtime.version=sua-versão-do-java

```

#### 4. Configure a conexão com os bancos de teste, desenvolvimento e produção:

#### application-test.properties

```
# H2 Connection
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
    
# H2 Client
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
    
# Show SQL
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

#### application-dev.properties (utilize variáveis de ambiente com um arquivo .env ou substitua por suas credenciais)

```
#spring.jpa.properties.jakarta.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
  
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
  
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

#### application-prod.properties

```
spring.datasource.url=${PROD_DB_URL}
spring.datasource.username=${PROD_DB_USERNAME}
spring.datasource.password=${PROD_DB_PASSWORD}
  
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

#### 5. Instale as dependências

```

mvn clean install

```

#### 6. Execute a aplicação com o Maven:

```

mvn spring-boot:run

```
