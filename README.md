#  PSA_TF - Back-End

Trabalho final da cadeira de PSA (01/2023). Alunos: Josias Vidal e Israel

#  PSA_TF - Back-End - Documentação do Projeto
Documentação do projeto com uma explicação de cada classe e interface, informações sobre o uso do Swagger, o banco de dados utilizado e os endpoints disponíveis.

## Versões utilizadas
- Spring Boot: 2.5.2
- Springfox: 3.0.0
- Banco de dados H2: 1.4.199
- JDK: 17


## Classes e Interfaces

### SwaggerConfiguracao
Essa classe é responsável pela configuração do Swagger no projeto. Ela habilita o Swagger usando a anotação @EnableSwagger2 e define um bean do tipo Docket para configurar as opções do Swagger. Também configura o mapeamento dos recursos estáticos necessários para a interface do Swagger.

### ReembolsoController
Essa classe é um controlador REST que define os endpoints para manipulação dos reembolsos. Ela contém os seguintes endpoints:

#### cadastrarReembolso
Endpoint para cadastrar um novo reembolso. Recebe os parâmetros nome e valor via requisição POST. Retorna o reembolso cadastrado ou uma mensagem de erro se os parâmetros forem inválidos.

#### listarTodosReembolsos
Endpoint para listar todos os reembolsos cadastrados. Realiza uma busca no repositório de reembolsos e retorna uma lista com todos os reembolsos encontrados.

#### aprovarReembolso
Endpoint para aprovar um reembolso. Recebe o parâmetro id via requisição POST. Realiza a busca do reembolso pelo ID no repositório e, se encontrado, marca o reembolso como aprovado e o salva novamente. Retorna o reembolso aprovado ou uma mensagem de erro se o reembolso não for encontrado.

#### gerarRelatorio
Endpoint para gerar um relatório com todos os reembolsos aprovados. Realiza uma busca no repositório de reembolsos filtrando apenas os reembolsos aprovados. Retorna uma lista com os reembolsos encontrados ou uma lista vazia se nenhum reembolso aprovado for encontrado.

### Reembolso
Essa classe é uma entidade JPA que representa um reembolso. Ela possui os seguintes atributos:

id: Identificador único do reembolso.
nome: Nome do reembolso.
valor: Valor do reembolso.
aprovado: Indica se o reembolso está aprovado ou não.
ReembolsoRepositorio
Essa interface estende a interface JpaRepository do Spring Data JPA e define métodos para acesso aos dados dos reembolsos no banco de dados. Além dos métodos herdados da interface JpaRepository, ela possui um método personalizado findAllAprovados que realiza uma consulta para buscar todos os reembolsos aprovados.

### ReembolsoService
Essa classe é responsável pela lógica de negócio relacionada aos reembolsos. Ela possui os seguintes métodos:

#### criaReembolso
Cria um novo reembolso com base nos parâmetros nome e valor recebidos. O reembolso é salvo no repositório e retornado.

#### valida
Valida os parâmetros nome e valor recebidos. Retorna true se os parâmetros forem válidos ou false caso contrário.

#### aprovarReembolso
Marca um reembolso como aprovado e o salva novamente no repositório. Retorna o reembolso aprovado.

#### gerarRelatorio
Busca todos os reembolsos aprovados no repositório e retorna uma lista com os reembolsos encontrados.

### Application
Essa é a classe principal do projeto que contém o método main. Ela inicia a aplicação Spring Boot.

## Swagger
O projeto utiliza o Swagger para fornecer uma documentação interativa da API. O Swagger permite explorar os endpoints, seus parâmetros e respostas, além de facilitar o teste e consumo da API. 
Para acessar a documentação do Swagger, você pode abrir o navegador e acessar a seguinte URL: http://localhost:8080/swagger-ui.html, substituindo 8080 pela porta em que o aplicativo está sendo executado.

## Banco de Dados
O projeto utiliza o banco de dados H2, que é um banco de dados em memória leve e fácil de configurar. O H2 é ideal para desenvolvimento e testes, pois não requer uma instalação separada e os dados são armazenados na memória.

## Endpoints
A seguir, estão listados os endpoints disponíveis no projeto:

- POST /reembolso/: Cadastra um novo reembolso. Parâmetros: nome (String) e valor (double). Retorna o reembolso cadastrado ou uma mensagem de erro.
- GET /listarTodosReembolsos: Lista todos os reembolsos cadastrados.
- POST /aprovarReembolso/: Aprova um reembolso. Parâmetro: id (Long). Retorna o reembolso aprovado ou uma mensagem de erro.
- GET /gerarRelatorio/: Gera um relatório com todos os reembolsos aprovados.

