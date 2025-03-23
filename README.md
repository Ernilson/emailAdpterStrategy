# Desafio Back-end Viasoft - Serviço de Envio de Email

Este projeto consiste em uma API RESTful para envio de emails, implementando um sistema de adaptação para diferentes provedores (AWS e OCI) com base em configurações dinâmicas.

## Descrição

A aplicação permite enviar emails através de diferentes provedores (AWS e OCI) sem modificar o objeto de entrada. A escolha do provedor é feita através de uma configuração no arquivo `application.properties`. O objeto de entrada é adaptado para o formato específico do provedor selecionado.

## Requisitos

-   Java 17
-   Maven
-   Spring Web
-   Spring Boot
-   Swagger (springdoc-openapi-starter-webmvc-ui)
-   Postman (ou ferramenta similar para testar a API)

## Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Ernilson/emailAdapter.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd emailAdapter
    ```

3.  **Compile e execute a aplicação usando Maven:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse o Swagger UI:**
    -   Abra o navegador e acesse `http://localhost:8080/swagger-ui/index.html`.

5.  **Configure o provedor no `application.properties`:**
    -   Abra o arquivo `src/main/resources/application.properties`.
    -   Defina a propriedade `mail.integracao` com `AWS` ou `OCI`.
        ```properties
        mail.integracao=AWS # ou OCI
        ```
    -   Reinicie a aplicação para que a configuração seja aplicada.

6.  **Teste os endpoints com Postman ou Swagger UI:**
    -   Use o Swagger UI ou Postman para enviar requisições POST para `/api/email`.
    -   O corpo da requisição deve ser um objeto JSON no formato `EmailDTO`.
    -   A aplicação adaptará o objeto para o formato correto (AWS ou OCI) com base na configuração.

## Estrutura do Projeto

-   `src/main/java/br/com/emailAdapter/`: Pacote principal da aplicação.
    -   `config/`: Classes de configuração (Swagger).
    -   `controller/`: Classes Controller para expor os endpoints.
    -   `dto/`: Classes DTO para transferência de dados.
    -   `service/`: Classes de serviço com a lógica de adaptação.
-   `src/main/resources/`: Recursos da aplicação (application.properties).

## Classes DTO

-   `EmailDTO`: Classe DTO para a requisição de entrada.
-   `EmailAwsDTO`: Classe DTO para formatação de dados para AWS.
-   `EmailOciDTO`: Classe DTO para formatação de dados para OCI.

## Configuração

-   `application.properties`:
    -   `mail.integracao`: Configura o provedor de email (`AWS` ou `OCI`).

## Padrões de Design

-   **Strategy Pattern:** Para adaptar os dados para diferentes provedores.
-   **Adapter Pattern:** Adapta o objeto de entrada para os formatos específicos dos provedores.
-   **Camadas (Layers):** A aplicação é estruturada em camadas para melhor organização e manutenção.

## Testes

-   Este projeto inclui testes unitários para validar a lógica de adaptação.

## Status da Aplicação

-   Retorna `204 No Content` em caso de sucesso.
-   Retorna `400 Bad Request` ou `500 Internal Server Error` em caso de falha.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests ou relatar problemas.

## Licença

Este projeto está sob a licença [MIT](LICENSE) (ou a licença de sua escolha).

![Requisição no Postman](images/postman.png)
