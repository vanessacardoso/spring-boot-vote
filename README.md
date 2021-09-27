# Spring Boot Vote
Projeto backend que gerencia sessões de votação.

## Funcionalidades
* Cadastrar uma nova pauta
* Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default)
* Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associadoé identificado por um id único e pode votar apenas uma vez por pauta)
* Contabilizar os votos e dar o resultado da votação na pauta

# Getting Started
`> gradle clean check` 
* ` Build project`
* Run > VoteApplication

## Resources
* H2: http://localhost:8080/h2-console (adicionar DataBase gerado em H2ConsoleAutoConfiguration)
* Swagger UI: http://localhost:8080/swagger-ui/

### Stack
Informações sobre as tecnologias usada na aplicação:
* Java 11
* Spring boot 2.5.1
* Banco de dados em memória H2 
* Lombok
* Swagger - Springfox
* Mockito
* Junit

## TODO
* Aumentar a cobertura de testes unitários
* Melhorar o tratamento de erros 
* Implementar Builder para seguir o padrão do projeto sem usar o lombok
