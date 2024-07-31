INSERT INTO users (login, password, name)
VALUES ('admin', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'Administrador');

INSERT INTO topic (title, message, created_at, status, fk_category, fk_subcategory, fk_course, fk_answer_solution, fk_user)
VALUES ('title', 'message', NOW(), 1, 2, 1, 1, NULL, 1),
       ('title2', 'message2', NOW(), 1, 2, 1, 1, NULL, 1);

INSERT INTO answer (message, created_at, fk_author, fk_topic)
VALUES ('mensagem', NOW(), NULL, 1),
       ('mensagem2', NOW(), NULL, 1);
