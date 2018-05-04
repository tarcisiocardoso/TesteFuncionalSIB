# Teste Funcional SIB
Teste ambiente em desenvolvimento

## Iniciando o projeto
Siga as instruções abaixo para ter o ambiente pronto para rodar os testes funcionais

### Pre-requisitos

Ter o ambiente SIB mctic configurado e rodando em modo desenvolvimento local:


Front: http://localhost:8092/sib/private \n
Back:  http://localhost:8080/sib-backend/

### Instalando

git clone do projeto

Compilar a aplicação: mvn clean install

## Executando os testes

executar os testes:

#### Cadastro Intituição: 
mvn exec:java -Dexec.mainClass="br.gov.mctic.sib.test.CadastroInstituicao"


