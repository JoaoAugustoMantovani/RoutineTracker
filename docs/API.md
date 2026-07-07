# Documentação da API e Segurança

## Autenticação
O sistema utiliza duas estratégias de autenticação:
1. **Local:** E-mail e Senha (com geração de token JWT).
2. **Social (OAuth2):** Google Login.

### Configuração OAuth2 (Google)
- **Provedor:** Google Cloud Platform.
- **Client Type:** Web Application.
- **Scopes Solicitados:** `openid`, `profile`, `email`.
- **Redirect URI (Local):** `http://localhost:8080/login/oauth2/code/google`