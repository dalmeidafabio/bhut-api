# bhut-api
API de Teste da BHUT

## **Instruções para rodar o projeto**
1) Importar o projeto no STS - Spring Tool Suite.

2) Checar os starters habilitados no projeto e configurar os que eventualmente estejam faltando:

Spring BootDevTools
Lombok
Spring Data JPA
MySQL Driver
Thymeleaf
Spring Web

3) Instalar o MySQL ou, alternativamente, incluir o starter do banco de dados de preferência ao projeto e alterar a propriedade spring.jpa.properties.hibernate no application.properties, colocando a string correspondente ao banco de dados escolhido.

4) Configurar o usuário e senha do banco de dados no application.properties nas respectivas propriedades: 

spring.datasource.username=root
spring.datasource.password=mandrake

5) Rodar o projeto. Como é um teste, o projeto está configurado para dropar e criar as tabelas do banco de dados automaticamente.
