<h1>API de Jogos</h1>

<h2>Sobre o projeto</h2>

Esta API RESTful foi desenvolvida em Java com Spring Boot, seguindo o padrão Arquitetura em Camadas 
(Layered Architecture) para garantir a separação de responsabilidades e a organização do código.
Ela permite a consulta e organização de uma base de dados de jogos, fornecendo endpoints para
recuperar informações e modificar a ordem dos jogos dentro das listas.

<h3>Diagrama da Arquitetura</h3>

![image](https://github.com/user-attachments/assets/16888315-48a9-46bc-b528-1b55d35b1bd0)

<h3>Modelo de domínio</h3>

![image](https://github.com/user-attachments/assets/2664e82a-4acb-4839-a2c0-df257515d3f9)

<h2>Tecnologias utilizadas</h2>

- Java
- Spring Boot
- Maven
- PostgreSQL (Banco de dados principal)
- H2 Database (Banco de dados em memória para testes)
- Postman (Teste de endpoints)

<h2>Endpoints Disponíveis</h2>

A API possui cinco endpoints:

<h3>1. Listar todos os jogos</h3>

![image](https://github.com/user-attachments/assets/dd27c879-c979-49ce-8a8e-6c0e107107af)

  
<h3>2. Buscar Jogo por ID</h3>

![image](https://github.com/user-attachments/assets/942834c2-59d3-4619-82a4-3d2b1ef47a7c)

  
<h3>3. Listar Categorias de Jogos</h3>

![image](https://github.com/user-attachments/assets/b22dd50f-5a6b-46b4-9425-65d9f1d061ac)

  
<h3>4. Listar Jogos por Categoria</h3>

![image](https://github.com/user-attachments/assets/d1d01848-c9c2-4e4a-a2b4-6c21a316b8b6)

  
<h3>5. Alterar Ordem dos Jogos na Lista</h3>

![image](https://github.com/user-attachments/assets/f33b986f-8280-44a4-a1af-881abde23e39)

<h2>Como Executar o Projeto</h2>

<h3>Pré-requisitos</h3>

- JDK +17
- Maven
- PostgreSQL
- Postman (opcional, para testar os endpoints)

<h3>Passos para Rodar</h3>

<h4>1. Clone o repositório:</h4>
   
```
git clone https://github.com/joaogabrielsp/games-api.git
```
   
<h4>2. Acesse o diretório do projeto:</h4>
   
```
cd games-api
```
   
<h4>3. Configure o ambiente</h4>

<h4>application.properties</h4>

```
spring.profiles.active=${APP_PROFILE:test}
spring.jpa.open-in-view=false

cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
```

<h4>system.properties</h4>

```
java.runtime.version=sua-versão-do-java
```

<h4>4. Configure a conexão com os bancos de teste, desenvolvimento e produção:</h4>

<h4>application-test.properties</h4>
   
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

<h4>application-dev.properties (utilize variáveis de ambiente com um arquivo .env ou substitua por suas credenciais)</h4>
   
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

<h4>application-prod.properties</h4>
  
```
spring.datasource.url=${PROD_DB_URL}
spring.datasource.username=${PROD_DB_USERNAME}
spring.datasource.password=${PROD_DB_PASSWORD}
  
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

<h4>5. Instale as depêndencias</h4>
  
```
mvn clean install
```

<h4>6. Execute a aplicação com o Maven:</h4>
   
```
mvn spring-boot:run
 ```






  
