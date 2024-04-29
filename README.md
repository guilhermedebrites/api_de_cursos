# API de Cursos - Spring Boot
## Descrição
Este projeto é uma API REST desenvolvida com Spring Boot para a gestão de cursos. Foi criada para fins educacionais e permite operações CRUD (criar, ler, atualizar e deletar) em uma lista de cursos.

## Tecnologias Utilizadas
- Java 11
- Spring Boot 2.7.x
- Maven 3.8.x
- H2 Database

## Configuração e Execução

### Pré-requisitos
- JDK 11
- Maven 3.8.x
  
### Configurar o Ambiente
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-cursos-springboot.git
   cd api-cursos-springboot
   ```
2. Configure as variáveis de ambiente necessárias no application.properties.
   
## Executar a Aplicação
Para rodar a aplicação, utilize o seguinte comando:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.

### Listar Todos os Cursos
- **GET** `/cursos`
- **Descrição**: Retorna uma lista de todos os cursos disponíveis.

### Obter um Curso por ID
- **GET** `/cursos/{id}`
- **Descrição**: Retorna detalhes de um curso específico.

### Criar um Novo Curso
- **POST** `/cursos`
- **Descrição**: Adiciona um novo curso. Requer um payload JSON com dados do curso.

### Atualizar um Curso Existente
- **PUT** `/cursos/{id}`
- **Descrição**: Atualiza os dados de um curso existente. Requer um payload JSON com os novos dados do curso.

### Deletar um Curso
- **DELETE** `/cursos/{id}`
- **Descrição**: Remove um curso do sistema.

