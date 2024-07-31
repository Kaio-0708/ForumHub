CREATE TABLE category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE subcategory(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    fk_category INT NOT NULL,
    FOREIGN KEY (fk_category) REFERENCES category(id)
);

CREATE TABLE course(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    fk_subcategory INT NOT NULL,
    FOREIGN KEY (fk_subcategory) REFERENCES subcategory(id)
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE answer(
    id SERIAL PRIMARY KEY,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    fk_author INT NULL,
    FOREIGN KEY (fk_author) REFERENCES users(id)
);

CREATE TABLE topic(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    fk_category INT NOT NULL,
    fk_subcategory INT NULL,
    fk_course INT NULL,
    fk_answer_solution INT NULL,
    FOREIGN KEY (fk_category) REFERENCES category(id),
    FOREIGN KEY (fk_subcategory) REFERENCES subcategory(id),
    FOREIGN KEY (fk_course) REFERENCES course(id),
    FOREIGN KEY (fk_answer_solution) REFERENCES answer(id)
);

ALTER TABLE answer
    ADD COLUMN fk_topic INT NOT NULL,
    ADD CONSTRAINT fk_answer_topic FOREIGN KEY (fk_topic) REFERENCES topic(id);
