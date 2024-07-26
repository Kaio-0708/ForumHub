# FórumHub

Um fórum é um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos. Aqui na Alura, os alunos e alunas utilizam o fórum para tirar suas dúvidas sobre os cursos e projetos em que estão participando. Este lugar mágico está cheio de muita aprendizagem e colaboração entre alunos, professores e moderadores.

## 🚧 Em Construção 🚧

Este projeto está atualmente em construção. Estamos trabalhando ativamente no desenvolvimento e novas funcionalidades serão adicionadas em breve.
Projeto aceita contribuições! 

## Funcionalidades da API

Nossa API se concentrará especificamente nos tópicos, e deve permitir aos usuários:

- Criar um novo tópico;
- Mostrar todos os tópicos criados;
- Mostrar um tópico específico;
- Atualizar um tópico;
- Eliminar um tópico.

É o que conhecemos normalmente como CRUD (CREATE, READ, UPDATE, DELETE)* e é muito parecido com o que desenvolvemos no LiterAlura, mas agora de forma completa, agregando as operações de UPDATE e DELETE, e usando um framework que facilitará muito o nosso trabalho.

*Tradução livre (em ordem): Criar, Consultar, Atualizar e Deletar.

## Objetivo do Projeto

Em resumo, nosso objetivo com este challenge é implementar uma API REST com as seguintes funcionalidades:

- API com rotas implementadas seguindo as melhores práticas do modelo REST;
- Validações realizadas segundo as regras de negócio;
- Implementação de uma base de dados relacional para a persistência da informação;
- Serviço de autenticação/autorização para restringir o acesso à informação.

## Tecnologias Utilizadas

- Java (versão 17 ou superior)
- Spring Boot
- Maven
- PostgreSQL

## Estrutura do Projeto

A estrutura do projeto será dividida em pacotes conforme as seguintes convenções:

- `controller`: Contém os controladores REST da aplicação.
- `model`: Contém as classes de modelo (entidades).
- `repository`: Contém os repositórios para acesso aos dados.
- `service`: Contém a lógica de negócio da aplicação.
- `config`: Contém as configurações da aplicação.

## Contribuição

Sinta-se à vontade para contribuir com este projeto. Para isso, siga os passos:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)
