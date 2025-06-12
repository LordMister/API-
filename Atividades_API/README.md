# 🎓 API de Gerenciamento de Alunos - Projeto Escola

Este repositório contém uma API RESTful desenvolvida em **Java com Spring Boot**, com persistência em banco de dados **MySQL**. A aplicação permite o gerenciamento de registros de alunos com operações CRUD (`GET`, `POST`, `PUT`, `DELETE`).

---

## 🚀 Tecnologias Utilizadas

- ✅ Java 17
- 🌱 Spring Boot
- 📦 Maven
- 🗃️ MySQL
- 📫 Spring Data JPA
- 📬 Postman ou Insomnia (para testes)
- 💻 Visual Studio Code

---

## 📁 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/com/example/Escola/
 │   │   ├── controller/       # Controladores (REST)
 │   │   ├── model/            # Modelo de dados (Entidades)
 │   │   ├── repository/       # Interface JPA para o banco
 │   │   └── services/         # Lógica de negócio
 │   └── resources/
 │       ├── application.properties  # Configurações do MySQL
 ├── test/                     # Testes automatizados
 └── db/banco.sql              # Script de criação do banco
```

---

## 📡 Endpoints disponíveis

| Método | Endpoint       | Descrição                    |
|--------|----------------|------------------------------|
| GET    | `/aluno`       | Lista todos os alunos        |
| POST   | `/aluno`       | Cadastra um novo aluno       |
| PUT    | `/aluno`       | Atualiza dados de um aluno   |
| DELETE | `/aluno`       | Remove um aluno              |

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Configure o banco MySQL**:
   - Crie o banco de dados com o script `src/db/banco.sql`
   - Atualize o arquivo `application.properties` com suas credenciais

3. **Execute o projeto**:
   - Pelo terminal:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou abra no VS Code e clique em "Run"

4. **Acesse**: `http://localhost:8080/aluno`

---

## ✍️ Autor

- **Ryan** – https://github.com/LordMister

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
