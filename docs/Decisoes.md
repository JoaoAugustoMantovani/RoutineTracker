# Registro de Decisões Arquiteturais

## [06/07/2026] - Estratégia de Herança do Módulo de Atividades
- **Contexto:** Precisávamos definir como armazenar Tarefas, Rotinas e Compromissos no banco de dados PostgreSQL.
- **Decisão:** Utilizar a estratégia de `Single Table` (Tabela Única) no JPA.
- **Motivo:** Otimização de performance para consultas de listagem diária (Resumo do Dia) e forte compartilhamento de atributos em comum entre as entidades.

## [06/07/2026] - Modelagem de Recorrência de Rotinas
- **Contexto:** Precisávamos definir como armazenar os padrões de repetição das Rotinas (ex: "toda segunda e quarta às 19h") no banco de dados.
- **Decisão:** Utilizar strings contendo "Cron Expressions" armazenadas diretamente na tabela de atividades.
- **Motivo:** O ecossistema Spring Boot possui suporte nativo para leitura e execução de Cron Expressions, evitando a necessidade de criar múltiplas tabelas relacionais complexas (Dias da Semana, Frequência, etc.) para gerenciar o agendamento.

## [06/07/2023] - Estratégia de Chave Primária (PK)
- **Contexto:** Definição do tipo de dado para a chave primária das tabelas do sistema.
- **Decisão:** Utilizar UUID em vez de IDs sequenciais (Serial/BigInt).
- **Motivo:** Aumentar a segurança da API evitando a enumeração de recursos (ID guessing) e facilitar futuras integrações ou migrações de dados sem conflitos de chave.