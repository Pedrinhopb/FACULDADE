Java

Usando Spring Boot | Banco de dados H2 | Lombok | JPA | Spring Web

Ecommerce de uma loja

-------------------------------------------------------------------

Roteiro para criação do projeto:
1. Criem um projeto Spring Boot com as dependências Lombok, JPA, H2 e Spring Web
2. Modifique o arquivo application.properties para a conexão com o banco de dados H2
3. Escreva as classes de entidade para o projeto. Classes de entidade têm atributos, id e as anotações @Data, @Entity e @Id
4. Escreva, para cada entidade, o respectivo Repository
5. Para cada entidade, crie um controller com os endpoints para uma API RESTFul (GET / GET /id POST / PUT /id DELETE /id)
6. Adicione as referências para os repositories no respectivo controller
7. Insira valores usando Postman ou Insomnia
8. Implemente a lógica para as situações de erro (ex. quando se tentar acessar um registro que não existe)
