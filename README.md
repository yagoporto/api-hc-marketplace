# 🧩 API - HC Marketplace

Este projeto é a API backend de um marketplace especializado em peças do jogo **HeroClix**, desenvolvido com Java e banco de dados MySQL. Ele permite o gerenciamento de usuários, produtos, carrinhos de compra e pedidos.

## 📑 Índice

- [Tecnologias Utilizadas](#🚀-tecnologias-utilizadas)
- [Funcionalidades](#📦-funcionalidades)
- [Endpoints User](#📌-endpoints-user)



## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **MySQL**
- **Maven**
- **JAVALIN** *(caso esteja usando)*
- **RESTful API**



## 📦 Funcionalidades

- Cadastro e autenticação de usuários
- CRUD de produtos HeroClix
- Sistema de carrinho de compras
- Finalização de pedidos
- Consulta de produtos por nome, edição ou coleção (a definir)



## 📌 Endpoints User

| Método | Rota           | Descrição                   |
|--------|----------------|-----------------------------|
| POST   | /adduser       | Adicionar usuário           |
| PUT    | /updateuserid  | Atualizar usuário           |
| GET    | /consultarid   | Consultar usuário por ID    |
| GET    | /consultartodos| Consultar todos os usuários |

---

Desenvolvido por **Yago Porto**
