INSERT INTO user (login, password, name)
VALUES ("admin", "$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.", "Administrador");

INSERT INTO topic (title, message, status, fk_category, fk_subcategory, fk_course, fk_answer_solution, fk_user)
VALUES ("title", "message", 1, 2, 1, 1, null, 1),
       ("title2", "message2", 1, 2, 1, 1, null, 1);

INSERT INTO answer (message, fk_author, fk_topic)
values ("mensagem", null, 1),
       ("mensagem2", null, 1);