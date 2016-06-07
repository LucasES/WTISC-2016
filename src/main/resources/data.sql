INSERT INTO usuario(id, nome, email, cpf) VALUES (1, 'Lucas Araújo', 'lucas@gmail.com', 1234567891);
INSERT INTO usuario(id, nome, email, cpf) VALUES (2, 'Adail', 'lucas@gmail.com', 1234567891);
INSERT INTO usuario(id, nome, email, cpf) VALUES (3, 'Mauricio', 'lucas@gmail.com', 1234567891);
INSERT INTO usuario(id, nome, email, cpf) VALUES (4, 'Emerson', 'lucas@gmail.com', 1234567891);
INSERT INTO usuario(id, nome, email, cpf) VALUES (5, 'Felype', 'lucas@gmail.com', 1234567891);

INSERT INTO compra(id, usuario_id, data, total, quantidade, ativo) VALUES (1, 1, '2016-05-28 09:54:47', 5.50, 31, true);
INSERT INTO compra(id, usuario_id, data, total, quantidade, ativo) VALUES (2, 1, '2016-06-17 09:54:47', 15.50, 3, true);
INSERT INTO compra(id, usuario_id, data, total, quantidade, ativo) VALUES (3, 2, '2015-07-12 09:54:47', 55.50, 33, true);
INSERT INTO compra(id, usuario_id, data, total, quantidade, ativo) VALUES (4, 2, '2014-03-11 09:54:47', 35.50, 23, false);
INSERT INTO compra(id, usuario_id, data, total, quantidade, ativo) VALUES (5, 3, '2013-02-28 09:54:47', 25.50, 34, false);
