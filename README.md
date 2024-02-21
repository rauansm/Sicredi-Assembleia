# 🗳 Sistema de Votação Cooperativa

## 📑 Sobre o Projeto
Este sistema é um back-end desenvolvido em Java Spring Boot para gerenciar sessões de votação em cooperativas. Ele permite o cadastramento de pautas, abertura de sessões de votação, recebimento e contabilização de votos dos associados, e fornece os resultados das votações. O sistema opera na nuvem e é acessível via API REST.

## Architecture Haiku
### Objetivos do Negócio
- Facilitar a gestão democrática em cooperativas.
- Assegurar a integridade e confiabilidade dos votos.
- Prover resultados rápidos e precisos das votações.

### Restrições
- Operação na nuvem.
- Persistência de dados.
- Foco no back-end.

### Atributos de Qualidade
Segurança > Disponibilidade > Escalabilidade

### Decisões de Design
- Java Spring Boot, Maven, Docker Compose.
- API RESTful.
- Integração com sistema externo para validação de CPF. (SERPRO Receita Federeal)
- Mensageria para divulgação de resultados.
- Estratégia de versionamento da API.

## Pré-Requisitos
- Java 11
- Maven
- Docker e Docker Compose
