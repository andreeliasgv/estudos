# 🌐 JavaWeb — Sistema de Cadastro de Usuários

Projeto Java Web desenvolvido utilizando **JSP, Servlets, JDBC e PostgreSQL**, com funcionalidades de cadastro, listagem, carregamento, exclusão e validação de usuários.

O sistema implementa operações CRUD básicas e aplica conceitos importantes de desenvolvimento web com Java EE.

---

# 📌 Funcionalidades

* ✅ Cadastro de usuários
* ✅ Listagem de usuários
* ✅ Exclusão de usuários
* ✅ Carregamento de dados para edição
* ✅ Validação de CPF
* ✅ Controle de autenticação via Filter
* ✅ Integração com banco de dados PostgreSQL
* ✅ Interface Web com JSP
* ✅ Máscaras e validações com JavaScript/jQuery

---

# 🛠 Tecnologias Utilizadas

| Tecnologia    | Finalidade               |
| ------------- | ------------------------ |
| Java          | Backend                  |
| JSP           | Interface Web            |
| Servlet       | Controle das requisições |
| JDBC          | Conexão com banco        |
| PostgreSQL    | Banco de dados           |
| HTML/CSS      | Estrutura e estilização  |
| JavaScript    | Interatividade           |
| jQuery        | Manipulação do frontend  |
| Apache Tomcat | Servidor de aplicação    |

---

# 📂 Estrutura do Projeto

```text
AplCurso2/
│
├── src/java/br/com/aplcurso/
│   ├── controller/
│   │   └── usuario/
│   ├── dao/
│   ├── filter/
│   ├── model/
│   └── utils/
│
├── web/
│   ├── cadastros/usuario/
│   ├── js/
│   ├── header.jsp
│   ├── footer.jsp
│   ├── menu.jsp
│   ├── home.jsp
│   └── index.jsp
│
└── build.xml
```

---

# 🧱 Arquitetura do Projeto

O projeto segue uma estrutura baseada em:

* **Model**
* **DAO**
* **Controller**
* **View (JSP)**

---

# 📦 Principais Pacotes

## 📁 `controller.usuario`

Responsável pelo controle das ações relacionadas aos usuários.

| Classe                | Função                              |
| --------------------- | ----------------------------------- |
| `UsuarioCadastrar`    | Cadastro de usuários                |
| `UsuarioListar`       | Listagem de usuários                |
| `UsuarioExcluir`      | Exclusão de usuários                |
| `UsuarioCarregar`     | Carregamento de dados               |
| `UsuarioNovo`         | Redirecionamento para novo cadastro |
| `UsuarioVerificarCPF` | Verificação/validação de CPF        |

---

## 📁 `dao`

Responsável pela comunicação com o banco de dados.

| Classe       | Função                             |
| ------------ | ---------------------------------- |
| `GenericDAO` | Conexão genérica                   |
| `UsuarioDAO` | Operações CRUD da entidade usuário |

---

## 📁 `model`

Contém as entidades do sistema.

| Classe    | Função                           |
| --------- | -------------------------------- |
| `Usuario` | Representa um usuário do sistema |

---

## 📁 `filter`

Responsável pelo controle de autenticação.

| Classe               | Função                               |
| -------------------- | ------------------------------------ |
| `FilterAutenticacao` | Filtra acessos e valida autenticação |

---

## 📁 `utils`

Classes auxiliares do projeto.

| Classe               | Função                        |
| -------------------- | ----------------------------- |
| `SingleConnection`   | Gerenciamento da conexão JDBC |
| `DocumentoValidador` | Validação de CPF              |
| `banco.sql`          | Script SQL do banco           |

---

# 🗄 Banco de Dados

O projeto utiliza PostgreSQL.

---

## 📌 Estrutura da tabela

```sql
CREATE TABLE USUARIO (
	ID SERIAL PRIMARY KEY,
	NOME VARCHAR(100) NOT NULL,
	DATANASCIMENTO DATE NOT NULL,
	CPF VARCHAR(100) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	SENHA VARCHAR(20) NOT NULL,
	SALARIO DECIMAL(15,2) NOT NULL
);
```

---

## 📌 Inserção de exemplo

```sql
INSERT INTO USUARIO
(NOME, DATANASCIMENTO, CPF, EMAIL, SENHA, SALARIO)
VALUES
('João José Gomes da Silva',
 '1990-08-10',
 '08243060073',
 'joaojosegomes@gmail.com',
 'senha123',
 5200.00);
```

---

# 🖥 Interface Web

O sistema possui páginas JSP organizadas em:

```text
web/cadastros/usuario/
```

Principais páginas:

| Página                 | Função          |
| ---------------------- | --------------- |
| `usuario.jsp`          | Listagem        |
| `usuarioCadastrar.jsp` | Cadastro        |
| `index.jsp`            | Página inicial  |
| `home.jsp`             | Home do sistema |

---

# ⚙️ Recursos Frontend

O projeto utiliza:

* jQuery
* Máscaras de input
* Máscara monetária
* Scripts JavaScript personalizados

Arquivos disponíveis em:

```text
web/js/
```

---

# ▶️ Como Executar

## ✅ Pré-requisitos

* JDK 8+
* Apache Tomcat
* PostgreSQL
* NetBeans ou IDE Java compatível

---

# 🔧 Configuração do Banco

1. Criar banco PostgreSQL
2. Executar o script:

```text
src/java/br/com/aplcurso/utils/banco.sql
```

3. Configurar credenciais no arquivo:

```text
SingleConnection.java
```

---

# 🚀 Executando o Projeto

1. Importar o projeto na IDE
2. Configurar o servidor Tomcat
3. Executar o projeto
4. Acessar:

```text
http://localhost:8080/AplCurso2
```

---

# 📚 Conceitos Trabalhados

* JSP
* Servlets
* JDBC
* MVC
* DAO Pattern
* Filtros de autenticação
* CRUD
* PostgreSQL
* Java Web

---

# 🎯 Objetivo do Projeto

Projeto desenvolvido para prática de:

* Desenvolvimento Web com Java
* Integração com banco de dados
* Arquitetura MVC
* Manipulação de formulários
* Operações CRUD
* Validação de dados

---

# 👨‍💻 Autor

Projeto desenvolvido para fins de estudo e prática em Java Web utilizando JSP, Servlets e PostgreSQL.
