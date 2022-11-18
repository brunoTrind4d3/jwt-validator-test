<h1>Validação de JWT </h1>

<h3>Excutando o sistema</h3>
<p>Tenha o docker instalado na máquina ou siga instalação conforme <a target="_blank" href="https://www.docker.com/products/docker-desktop/">Docker</a></p>
<p>Na raiz do projeto execute o comando: <b>docker-compose up -d --build</b></p>

<h6>Alternativa de execução</h6>
<p>Faça o clone da aplicação, abra na sua IDE e execute o arquivo <b>src/main/java/com/itau/appjwtvalidator/AppJwtValidatorApplication.java</b></p>

<h3>Documentação da API</h3>
<p>Swagger: http://localhost:8080/swagger-ui/index.html#/ </p>

<h3>Acompanhamento de logs</h3>
<p>Os logs deverão ser acompanhados pelo console do docker desktop</p>

<h3>Detalhamento</h3>
<p>Controller: tem apenas a função de expor os métodos HTTP</p>
<p>Domain/Service: Execução das regras de negócio</p>
<p>Domain/Service/Validator: regras de negócio especificas da validação de cada parte do Claim</p>
<p>Domain/Entity: Dominios das entidades utilizadas no projeto</p>
<p>Config: Configuração dos beans</p>