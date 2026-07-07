# Entidades Principais (Rascunho)

## Domínio: Atividades
- AtividadeBase
- Tarefa
- Rotina
- Compromisso

## Domínio: Performance
- CategoriaPerformance
- SessaoTreino
- Metrica

## Tabela: `atividades`
- **Estratégia:** Single Table (Acomoda Tarefas, Rotinas e Compromissos).
- **Colunas:**
  - `id`: UUID (Primary Key)
  - `tipo_atividade`: VARCHAR (Discriminador)
  - `titulo`: VARCHAR(255)
  - `descricao`: TEXT
  - `data_hora_inicio`: TIMESTAMP
  - `expressao_cron`: VARCHAR(100)
  - `minutos_notificacao`: INTEGER
  - `status`: VARCHAR(50)

## Tabela: `usuarios`
- **Descrição:** Armazena os dados de autenticação, perfil e preferências do usuário.
- **Colunas:**
  - `id`: UUID (Primary Key)
  - `nome`: VARCHAR(255) (NOT NULL)
  - `email`: VARCHAR(255) (UNIQUE, NOT NULL)
  - `senha`: VARCHAR(255) (NULLABLE - Para OAuth2)
  - `provedor`: VARCHAR(50) (NOT NULL)
  - `provedor_id`: VARCHAR(255) (NULLABLE)
  - `role`: VARCHAR(50) (NOT NULL, DEFAULT 'ROLE_USER')
  - `ativo`: BOOLEAN (NOT NULL, DEFAULT TRUE)
  - `fuso_horario`: VARCHAR(50) (NOT NULL)
  - `criado_em`: TIMESTAMP (Gerenciado pelo JPA Auditing)
  - `atualizado_em`: TIMESTAMP (Gerenciado pelo JPA Auditing)