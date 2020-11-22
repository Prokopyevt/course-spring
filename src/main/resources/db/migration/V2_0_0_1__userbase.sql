CREATE TABLE IF NOT EXISTS userdata
(
    id        serial PRIMARY KEY,
    username  varchar(255) NOT NULL,
    password  varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS authority
(
    name  varchar(255) NOT NULL,
    id        serial PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS user_authority
(
    authority_id  int8,
    users_id      int8,
    FOREIGN KEY (authority_id) REFERENCES authority (id),
    FOREIGN KEY (users_id) REFERENCES userdata (id)
);

INSERT INTO authority (name, id) Values ('ROLE_ADMIN', 1);
INSERT INTO authority (name, id) Values ('ROLE_USER', 2);

INSERT INTO userdata (id, username, password) VALUES (1, 'Ivan', '$2y$12$GEiD1FfhRc22AqgF8kmJwe51nknKX4B9nTfIytCjJC4Ps9CViLGAy');
INSERT INTO userdata (id, username, password) VALUES (2, 'Dima', '$2y$12$fsuEbjqH1mnRsIqJNajaMeW866kZh9a3ovNjvI9D8bm5.IeBoC.lq');

INSERT INTO user_authority (authority_id, users_id) VALUES (1,1);
INSERT INTO user_authority (authority_id, users_id) VALUES (2,2);