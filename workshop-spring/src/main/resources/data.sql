INSERT INTO `departamentos` (`id`, `descricao`) VALUES (NULL, 'Administrativo'), (NULL, 'Vendas'), (NULL, 'Contábil'), (NULL, 'Fiscal'), (NULL, 'Manutenção'), (NULL, 'Atendimento ao Cliente');

INSERT INTO `cargos` (`id`, `descricao`, `id_departamento`) VALUES (NULL, 'Gerente', '6'), (NULL, 'Gerente', '3'), (NULL, 'Gerente', '2'), (NULL, 'Vendedor', '2'), (NULL, 'Técnico', '5'), (NULL, 'Diretor', '1'), (NULL, 'Atendente', '6'), (NULL, 'Contador', '3'), (NULL, 'Assistente Adm.', '1');

INSERT INTO `estados` (`id`, `descricao`) VALUES (NULL, 'Acre'), (NULL, 'Alagoas'), (NULL, 'Amapá'), (NULL, 'Bahia'), (NULL, 'Ceará'), (NULL, 'Espírito Santo'), (NULL, 'Goiás'), (NULL, 'Maranhão'), (NULL, 'Mato Grosso');

INSERT INTO `cidades` (`id`, `descricao`, `id_estado`) VALUES (NULL, 'SALVADOR', '4'), (NULL, 'FEIRA DE SANTANA', '4'), (NULL, 'VITÓRIA DA CONQUISTA', '4'), (NULL, 'JUAZEIRO', '4'), (NULL, 'TEIXEIRA DE FREITAS', '4'), (NULL, 'BARREIRAS', '4'), (NULL, 'SIMÕES FILHO', '4'), (NULL, 'EUNÁPOLIS', '4');

INSERT INTO `cidades` (`id`, `descricao`, `id_estado`) VALUES (NULL, 'RIO BRANCO', '1'), (NULL, 'CRUZEIRO DO SUL', '1'), (NULL, 'FEIJÓ', '1'), (NULL, 'XAPURI', '1'), (NULL, 'PORTO ACRE', '1');

INSERT INTO `cidades` (`id`, `descricao`, `id_estado`) VALUES (NULL, 'GOIÂNIA', '7'), (NULL, 'ANÁPOLIS', '7'), (NULL, 'RIO VERDE', '7'), (NULL, 'LUZIÂNIA', '7'), (NULL, 'TRINDADE', '7'), (NULL, 'JATAÍ', '7');

INSERT INTO `projetos` (`id`, `nome_contratante`, `data_inicio`, `nome_projeto`) VALUES (NULL, 'Gabrielly e Nicole Joalheria Ltda', '01-01-2021', 'Sistema de segurança'), (NULL, 'Raul e Leonardo Contábil Ltda', '12-02-2021', 'Controle de tarefas contábil'), (NULL, 'Miguel e Iago Eletrônica ME', '23-03-2021', 'Site de venda de Eletrônicos');

INSERT INTO `enderecos` (`id`, `bairro`, `numero`, `rua`, `id_cidade`) VALUES (NULL, 'Arutef', '2674', 'AVENIDA BRASIL', '19'), (NULL, 'santa rita', '1463', 'RUA SAO PAULO', '12'), (NULL, 'Liberdate 1', '140', 'RUA SAO JOSE', '17');

INSERT INTO `funcionarios` (`id`, `cpf_funcionario`, `nome_funcionario`, `id_cargo`, `id_endereco`) VALUES (NULL, '11111111111', 'Fulano coiso dos Treco', '9', '1'), (NULL, '22222222222', 'Andreia Estrela Cadente', '3', '3'), (NULL, '33333333333', 'Vinicius Bons Dias', '5', '2');

INSERT INTO `contatos` (`id`, `numero`, `tipo`, `id_funcionario`) VALUES (NULL, '075 99954 2467', 'CELULAR', '1'), (NULL, '073 9 2648 2154', 'CELULAR', '2'), (NULL, '073 9 3265 5821', 'TELEFONE', '2'), (NULL, '075 9 3265 1111', 'CELULAR', '3');