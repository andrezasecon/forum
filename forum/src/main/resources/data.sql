INSERT INTO TB_USER(nome, email, senha) VALUES ('Aluno1', 'aluno1@gmail.com', '123456');
INSERT INTO TB_USER(nome, email, senha) VALUES ('Aluno2', 'aluno2@gmail.com', '123456');
INSERT INTO TB_USER(nome, email, senha) VALUES ('Aluno3', 'aluno3@gmail.com', '123456');
INSERT INTO TB_USER(nome, email, senha) VALUES ('Aluno4', 'aluno4@gmail.com', '123456');
INSERT INTO TB_USER(nome, email, senha) VALUES ('Aluno5', 'aluno5@gmail.com', '123456');
INSERT INTO TB_USER(nome, email, senha) VALUES ('Aluno6', 'aluno6@gmail.com', '123456');

INSERT INTO TB_CURSO(nome, categoria) VALUES ('Spring Boot', 'Programação');
INSERT INTO TB_CURSO(nome, categoria) VALUES ('HTML5', 'Front-end');
INSERT INTO TB_CURSO(nome, categoria) VALUES ('Java', 'Programação');
INSERT INTO TB_CURSO(nome, categoria) VALUES ('Postgres', 'Banco de dados');

INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 1', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Test teste', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 4', 'teste 2', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 3);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 5', 'teste 3', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 4);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 6', 'teste 4', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 3, 1);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 7', 'teste 5', '2019-05-05 20:00:00', 'NAO_RESPONDIDO',3, 2);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 8', 'teste 6', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 3, 3);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 9', 'teste 7', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 5, 4);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 10', 'teste 8', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 5, 2);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 11', 'teste 9', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 6, 1);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 12', 'teste 10', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 6, 2);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 13', 'teste 11', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 6, 3);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 14', 'teste 12', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 6, 4);
INSERT INTO TB_TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 15', 'teste 13', '2019-05-05 20:00:00', 'NAO_RESPONDIDO',5, 1);