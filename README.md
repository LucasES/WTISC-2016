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

## Configuração do Ambiente de Desenvolvimento ##

**IDE:** Eclipse JAVA EE Mars.1 Release (4.5.1).
**Banco de dados**: MySQL Workbench 6.3 Community.
**Teste serviços REST**: Postman 4.2.1.
**Sistema Operacional**: Windows 7 x64.

OBS: O sistema operacional não restringe a sua utilização em outros SO's.

## Configuração do Projeto na IDE ##

O projeto é do tipo Maven, então basta importá-lo como tal.

## Modelo Relacional ##

![alt text](https://www.assembla.com/spaces/modelo_projeto_uml/documents/aiTcRQKp4r3OiPeJe5aVNr/download/aiTcRQKp4r3OiPeJe5aVNr "Logo Title Text 1")


## Coleções Postman ##

Abaixo segue os link's das coleções utilizadas no Postman para testar os serviços REST.
Para instalar a extensão do Postman no Google Chrome [click aqui](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)

	* Buy (Compra): https://www.getpostman.com/collections/4cf98c7b3856b5352363
	* Category (Categoria): https://www.getpostman.com/collections/92f8d384703ae10ded02
	* Environment (Ambiente): https://www.getpostman.com/collections/17c517ce1e74642e0aa2
	* Environment Type (Tipo Ambiente): https://www.getpostman.com/collections/921d5a8cece7c081e70a
	* Event (Evento): https://www.getpostman.com/collections/22d2eda72741e0b16d15
	* Member (Integrantes): https://www.getpostman.com/collections/3f8dbade7bebaa4ff39b
	* Sector (Setor): https://www.getpostman.com/collections/5aee91b9342d0c713aa4
	* Ticket (Ingresso): https://www.getpostman.com/collections/6b4af2799600f6733b56
	* User (Usuário): https://www.getpostman.com/collections/efa50b9d80960c1373da