# 🌐 Interface Web + API - Gerenciamento de Alunos

Este projeto integra uma **interface web desenvolvida com HTML, CSS (Tailwind) e JavaScript**, conectada à uma **API RESTful em Java/Spring Boot**. A proposta é oferecer uma aplicação didática e funcional para **cadastro, listagem, edição e remoção de alunos**.

---

## 🖥️ Tecnologias Utilizadas

- 🧩 HTML5 + CSS3 com TailwindCSS
- ⚙️ JavaScript (ES6+)
- 🔗 Integração com API REST via Fetch
- 💬 SweetAlert2 (alertas de confirmação e feedback)
- 📡 Backend: Java + Spring Boot (API)
- 🧪 Testes no navegador via Live Server

---

## 🧰 Funcionalidades da Interface

| Função      | Descrição                                           |
|-------------|-----------------------------------------------------|
| 📋 Listar    | Mostra todos os alunos registrados via API         |
| ➕ Cadastrar | Formulário com validação que envia dados via `POST`|
| 🗑️ Remover   | Botão com confirmação, que envia `DELETE` à API    |
| ✏️ Editar    | Permite atualizar dados de um aluno via `PUT`      |
| 🌙 Tema     | Botão para alternar entre modo escuro e claro       |

---

## 📂 Estrutura do Projeto

```
API_Interface/
├── index.html           # Página principal com formulário e tabela
├── script.js            # Lógica JS (fetch, DOM, interações)
├── style.css (opcional) # Se quiser personalizações extras
├── logo.png             # Logo da plataforma
└── README.md            # Explicações do projeto
```

---

## 💻 Como Executar

1. **Clone este projeto ou copie os arquivos**
2. **Abra no VS Code**
3. **Instale a extensão Live Server (Ritwick Dey)**
4. Clique com o botão direito no `index.html` → `Open with Live Server`

⚠️ Certifique-se que a **API está rodando em `http://localhost:8080/api/alunos`**

---

## 📦 Backend Esperado

A interface envia requisições para uma API compatível com:

```http
GET     /api/alunos
POST    /api/alunos
PUT     /api/alunos
DELETE  /api/alunos/{id}
```

---

## 🧑‍💻 Autor

- **Ryan** – https://github.com/LordMister
