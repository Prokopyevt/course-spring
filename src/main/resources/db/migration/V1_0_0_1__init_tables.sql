CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS Library
(
    id               serial PRIMARY KEY,
    nameBook         varchar(255) NOT NULL,
    author           varchar(255) NOT NULL,
    yearOfPublishing integer,
    status           varchar(20)  NOT NULL DEFAULT 'OPEN'
);

CREATE TABLE IF NOT EXISTS Reader
(
    id              serial PRIMARY KEY,
    name            varchar(255) NOT NULL,
    dateOfBirth     varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Readingroom
(
    id         serial PRIMARY KEY,
    library_id   int8,
    reader_id    int8,
    residueReader   integer NOT NULL DEFAULT 0,
    FOREIGN KEY (library_id) REFERENCES Library (id),
    FOREIGN KEY (reader_id) REFERENCES Reader (id)
);