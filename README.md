# LeiloesTDSat

## Explicação do projeto
__LeiloesTDSat__ é o projeto do sistema para uma casa de leilões, para que este possa automatizar os processos utilizados na rotina dos funcionários. 
- O Software conta com duas telas: uma para o cadastro do novos produtos e outra para vizualização dos produtos já cadastrados;
- Na __tela de cadastro__, o usuário cadastrará um produto digitando seu nome e preço. Após isso, clicará no botão "cadastrar" para salvar o produto, enviando ao banco de dados. ALém disso, há um botão "consultar produtos" que, ao ser clicado, abrirá a tela de listagem de produtos;
- Na __tela de listagem__, há uma tabela, que listará todos os produtos cadastrado no banco de dados, com as colunas "ID", "Nome", "Valor" e "Status". Logo abaixo, há um campo de entrada para inserir o ID de um produto a ser vendido, clicando no botão "vender". Por fim, há os botões "voltar", que irá retornar à tela de cadastro, e "consultar vendas", que abrirá uma tela para vizualização de todas as vendas realizadas (em desenvolvimento).

<img src="https://i.imgur.com/nEeUQNd.png" alt="telas de cadastro e listagem" height="350" />

## Tecnologias utilizadas
Para o desenvolvimento do Software foi utilizado a linguagem de programação __Java__, e __Swing__ para o desenvolvimento visual das telas. Já para o banco de dados, foi usado __MySQL__. No entanto, não foi utilizado uma _ORM_ (Mapeador de Relação de Objetos), então importou-se o driver __MySQL Connector/J__ para realizar a conexão entre a aplicação e o banco de dados.
