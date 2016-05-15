# WTISC - 2016

Este projeto tem como objetivo implementar um sistema utilizando as tecnologias: SpringBboot, Spring Data JPA e Maven.

Com isso, esse projeto irá disponibilizar serviços REST que permitam realizar a manipulação de um sistema que gerêncie a compras de ingressos por usuários.

## Criação do Banco de Dados ##

No seu MySQL local, é necessário a criação de uma base vazia chamada `wtisc`, usando seguinte comando:

```sql

CREATE DATABASE wtisc WITH ENCODING='UTF8';

```


## Configuração dos dados do banco na aplicação##

Para rodar localmente, alterar as seguintes configurações no arquivo "aplication.properties" da aplicação de acordo os dados do seu banco MySQL:
```code

spring.datasource.url = jdbc:mysql://localhost:3306/wtisc
spring.datasource.username = [seu_usuario_do_banco]
spring.datasource.password = [sua_senha_do_banco]

```

Feito isso, basta partir para os próximo passos.


## Configuração do JAVA ##

O projeto utiliza o jdk 1.6, então, o mesmo precisa ser instalado.


## Configuração do Projeto na IDE ##

O projeto é do tipo Maven, então basta importá-lo como tal.

## Diagrama Modelo Relacional ##

![alt text](https://www.assembla.com/spaces/modelo_projeto_uml/documents/aiTcRQKp4r3OiPeJe5aVNr/download/aiTcRQKp4r3OiPeJe5aVNr "Logo Title Text 1")

