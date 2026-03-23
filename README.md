Um sistema desktop simples e direto para gestão de alunos, desenvolvido em Java com interface gráfica Swing. O projeto aplica o padrão de arquitetura MVC e utiliza Hibernate para guardar os dados na base de dados.

✨ O que o sistema faz?

  - Cadastrar: Adiciona novos alunos com validação de dados (Matrícula, Nome, Idade, CPF, Telefone).
  - Listar: Exibe todos os alunos matriculados numa tabela organizada.
  - Pesquisar: Procura alunos específicos utilizando o número de matrícula.
  - Remover: Exclui alunos da base de dados de forma simples.
  - Integração CSV: Além da base de dados, mantém um histórico/registo das operações num ficheiro .csv.

🛠️ Tecnologias Utilizadas

  - Java (JDK 8+)
  - Java Swing (Interface Gráfica)
  - Hibernate / JPA (Mapeamento e persistência na Base de Dados)
  - Padrão MVC (Model-View-Controller)
  - Apache NetBeans (IDE e gestão de Build via Ant)

🚀 Como executar o projeto na sua máquina

1.  Faça o clone do repositório.

2.  Prepare a Base de Dados:

  - Crie uma base de dados no seu servidor local (ex: MySQL, PostgreSQL).
  - Localize o ficheiro de configuração do Hibernate no projeto (geralmente hibernate.cfg.xml ou persistence.xml).
  - Altere as credenciais (url, username, password) para as da sua base de dados local.


3.  Abra e Execute:

  - Abra o IDE Apache NetBeans.
  - Vá a Ficheiro \> Abrir Projeto e selecione a pasta transferida.
  - Adicione o Driver JDBC da sua base de dados nas bibliotecas (Libraries) do projeto, se necessário.
  - Clique com o botão direito no projeto e selecione Executar (Run).
