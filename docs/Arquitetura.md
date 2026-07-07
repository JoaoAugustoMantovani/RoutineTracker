# Arquitetura do Sistema

## Backend (Spring Boot)
O projeto adota uma Arquitetura em Camadas (Layered Architecture) para separar as responsabilidades, estruturada nos seguintes pacotes principais:

1. **`domain` (ou `entity`)**: Contém as classes de modelo mapeadas para o banco de dados (JPA Entities).
2. **`repository`**: Contém as interfaces do Spring Data JPA responsáveis pela persistência de dados.
3. **`service`**: Contém as regras de negócio puras do sistema.
4. **`controller`**: Contém a camada de exposição da API REST, responsável por receber requisições HTTP e retornar respostas estruturadas (JSON).

*Regra de Ouro:* A comunicação deve ser estritamente sequencial e de cima para baixo: `Controller -> Service -> Repository`. Um Controller nunca deve acessar um Repository diretamente.


## 1. Uso Obrigatório de DTOs nas Requisições (Inbound)
- **Decisão:** É estritamente proibido receber Entidades JPA (Models) diretamente nos Controllers. Todo payload de entrada deve ser mapeado para um Request DTO.
- **Motivo 1 (Segurança):** Prevenir ataques de Mass Assignment (Over-posting), onde usuários mal-intencionados injetam propriedades não autorizadas (ex: alteração de roles ou status).
- **Motivo 2 (Design):** Separar as validações da camada Web (Bean Validation, como `@NotBlank`) das regras de persistência da Entidade.
- **Motivo 3 (Resiliência):** Permitir que o esquema do banco de dados evolua sem quebrar os contratos (contratos de API) consumidos pelos clientes (Frontend).