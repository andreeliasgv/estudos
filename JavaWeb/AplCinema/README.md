# 🎬 AplCinema - Sistema Web de Gerenciamento de Cinema

Sistema Web desenvolvido em Java utilizando JSP, Servlets, JDBC e PostgreSQL para gerenciamento de filmes e funcionários de um cinema.

O projeto implementa operações de cadastro, listagem, edição e exclusão (CRUD), seguindo o padrão MVC (Model-View-Controller) e utilizando conexão com banco de dados PostgreSQL.

---

# 📌 Funcionalidades

## 🎥 Gerenciamento de Filmes

- Cadastrar filmes
- Listar filmes cadastrados
- Editar informações de filmes
- Excluir filmes
- Registrar data de lançamento
- Registrar duração em minutos

## 👨‍💼 Gerenciamento de Funcionários

- Cadastrar funcionários
- Listar funcionários cadastrados
- Editar funcionários
- Excluir funcionários
- Registrar função/cargo
- Registrar telefone e e-mail

## 🔐 Controle de Acesso

- Filtro de autenticação
- Controle de acesso às páginas do sistema

---

# 🛠 Tecnologias Utilizadas

- Java
- JSP (Java Server Pages)
- Servlets
- JDBC
- PostgreSQL
- HTML5
- CSS3
- JavaScript
- Apache Tomcat
- NetBeans

---

# 📂 Estrutura do Projeto

```text
AplCinema/
│
├── src/java/br/com/aplcinema/
│
├── controller/
│   ├── filme/
│   └── funcionario/
│
├── dao/
│   ├── FilmesDAO.java
│   ├── FuncionariosDAO.java
│   └── GenericDAO.java
│
├── filter/
│   └── FilterAutenticacao.java
│
├── model/
│   ├── Filme.java
│   └── Funcionario.java
│
├── utils/
│   └── SingleConnection.java
│
└── web/
    ├── cadastros/
    │   ├── filme/
    │   └── funcionario/
    │
    ├── index.jsp
    ├── home.jsp
    ├── menu.jsp
    ├── header.jsp
    └── footer.jsp
```

---

# 🏗 Arquitetura

O projeto utiliza o padrão MVC:

## Model

Responsável pelas entidades do sistema:

- Filme
- Funcionario

## View

Responsável pela interface gráfica:

- JSP
- HTML
- CSS
- JavaScript

## Controller

Responsável pelo processamento das requisições:

### Filmes

- FilmeCadastrar
- FilmeListar
- FilmeCarregar
- FilmeExcluir
- FilmeNovo

### Funcionários

- FuncionarioCadastrar
- FuncionarioListar
- FuncionarioCarregar
- FuncionarioExcluir
- FuncionarioNovo

---

# 🎥 Entidade Filme

Representa os filmes cadastrados no sistema.

## Atributos

| Campo | Tipo |
|---------|---------|
| id_filme | Integer |
| nome_filme | String |
| data_lancamento | Date |
| duracao_minutos | Integer |

---

# 👨‍💼 Entidade Funcionário

Representa os funcionários do cinema.

## Atributos

| Campo | Tipo |
|---------|---------|
| id_funcionario | Integer |
| nome_funcionario | String |
| funcao | String |
| telefone | String |
| email | String |

---

# 🗄 Banco de Dados

O sistema utiliza PostgreSQL.

## Configuração de Conexão

Arquivo:

```java
SingleConnection.java
```

Exemplo:

```java
private static String servidor =
"jdbc:postgresql://localhost:5432/bdaplcinema";

private static String usuario = "postgres";

private static String senha = "sua_senha";
```

---

# 📋 Exemplo de Estrutura SQL

## Tabela FILME

```sql
CREATE TABLE FILME (
    ID_FILME SERIAL PRIMARY KEY,
    NOME_FILME VARCHAR(100),
    DATA_LANCAMENTO DATE,
    DURACAO_MINUTOS INTEGER
);
```

## Tabela FUNCIONARIO

```sql
CREATE TABLE FUNCIONARIO (
    ID_FUNCIONARIO SERIAL PRIMARY KEY,
    NOME_FUNCIONARIO VARCHAR(100),
    FUNCAO VARCHAR(50),
    TELEFONE VARCHAR(20),
    EMAIL VARCHAR(100)
);
```

---

# 🚀 Como Executar

## Pré-requisitos

- JDK 8 ou superior
- PostgreSQL
- Apache Tomcat
- NetBeans IDE

---

## 1. Criar o Banco

```sql
CREATE DATABASE bdaplcinema;
```

---

## 2. Criar as Tabelas

Execute os scripts SQL do projeto.

---

## 3. Configurar a Conexão

Editar:

```java
SingleConnection.java
```

Informando:

- Banco
- Usuário
- Senha

---

## 4. Importar na IDE

Importe o projeto no NetBeans.

---

## 5. Executar

Deploy no Tomcat:

```text
Run Project
```

---

## 6. Acessar

```text
http://localhost:8080/AplCinema
```

---

# 📚 Conceitos Aplicados

- Programação Orientada a Objetos
- MVC
- CRUD
- JSP
- Servlets
- JDBC
- PostgreSQL
- DAO Pattern
- Filtros de Autenticação
- Conexão Singleton
- Java Web

---

# 🎯 Objetivo do Projeto

Desenvolver uma aplicação web para gerenciamento de informações de um cinema, aplicando conceitos de desenvolvimento Java Web, integração com banco de dados e arquitetura MVC.

---

# 👨‍💻 Autor

Projeto desenvolvido para fins acadêmicos e prática de desenvolvimento Java Web utilizando JSP, Servlets e PostgreSQL.