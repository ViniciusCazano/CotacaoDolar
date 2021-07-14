# CotacaoDolar - Full stack
Aplicativo para exibir cotação do dolar em tempo real. <br/>
O projeto exibe os dados salvos na base de dados, com opção de filtrar, paginar e atualizar os dados a cada minuto. <br/>
Permitindo visualizar um historico de cotações e a cotação atual.
<br/><br/>
Para validar o projeto, ao iniciar o SpringBoot o mesmo ira gerar dados aleatorios e ficar inserindo registro a cada minuto.


# EXECUTAR APLICAÇÃO
1º)Verificar dados de configuração do banco de dados: <br/>
* DataBase: postgres <br/>
* Usuario: postgres <br/>
* Senha: postgres <br/>

2º)Executar o SpringBoot: <br/>
* cd ./CotacaoDolar-backend <br/>
* mvnw spring-boot:run <br/>
OBS: Aguardar até exibir a mensagem "BASE DE DADOS CARREGADA COM SUCESSO" <br/>

3º)Executar Angular: <br/>
* cd ./CotacaoDolar-frontend <br/>
* ng serve <br/>


# Tecnologia utilizada: <br/>
------> Backend: SpringBoot <br/>
------> FrontEnd: Angular <br/>
------> Banco de dados: PostgreSQL <br/>
