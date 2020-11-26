CREATE TABLE IF NOT EXISTS permission
(
    name  varchar(255) NOT NULL,
    id        serial PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS authority_permission
(
    authority_id       int8,
    permission_id      int8,
    FOREIGN KEY (authority_id) REFERENCES authority (id),
    FOREIGN KEY (permission_id) REFERENCES permission (id)


);

INSERT INTO permission (name, id) Values ('LIBRARY_READ',     1);
INSERT INTO permission (name, id) Values ('LIBRARY_WRITE',    2);
INSERT INTO permission (name, id) Values ('READER_READ',      3);
INSERT INTO permission (name, id) Values ('READER_WRITE',     4);
INSERT INTO permission (name, id) Values ('READINGROOM_READ', 5);
INSERT INTO permission (name, id) Values ('READINGROOM_WRITE',6);

INSERT INTO authority_permission (authority_id, permission_id) VALUES(1,1);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(1,2);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(1,3);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(1,4);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(1,5);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(1,6);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(2,1);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(2,3);
INSERT INTO authority_permission (authority_id, permission_id) VALUES(2,5);
