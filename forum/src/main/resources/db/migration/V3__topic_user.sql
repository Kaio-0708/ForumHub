ALTER TABLE topic
    ADD COLUMN fk_user BIGINT NULL,
    ADD CONSTRAINT fk_user_topic FOREIGN KEY (fk_user) REFERENCES users(id);
