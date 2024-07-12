CREATE TABLE category(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE subcategory(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    fk_category INT NOT NULL,
    FOREIGN KEY (fk_category) REFERENCES category(id)
);

CREATE TABLE course(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    fk_subcategory INT NOT NULL,
    FOREIGN KEY (fk_subcategory) REFERENCES subcategory(id)
);

CREATE TABLE user(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE ,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE answer(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    fk_author BIGINT NULL,
    FOREIGN KEY (fk_author) REFERENCES user(id)
);

CREATE TABLE topic(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status ENUM('1','2','3','4'),
    fk_category INT NOT NULL,
    fk_subcategory INT NULL,
    fk_course INT NULL,
    fk_answer_solution BIGINT NULL,
    FOREIGN KEY (fk_category) REFERENCES category(id),
    FOREIGN KEY (fk_subcategory) REFERENCES subcategory(id),
    FOREIGN KEY (fk_course) REFERENCES course(id),
    FOREIGN KEY (fk_answer_solution) REFERENCES answer(id)
);

ALTER TABLE answer
    ADD COLUMN fk_topic BIGINT NOT NULL,
ADD CONSTRAINT fk_answer_topic FOREIGN KEY (fk_topic) REFERENCES topic(id);