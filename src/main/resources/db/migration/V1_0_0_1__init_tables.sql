CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS library
(
    id               serial PRIMARY KEY,
    name_book         varchar(255) NOT NULL,
    author           varchar(255) NOT NULL,
    year_of_publishing integer,
    status           varchar(20)  NOT NULL DEFAULT 'OPEN'
);

CREATE TABLE IF NOT EXISTS Reader
(
    id              serial PRIMARY KEY,
    name            varchar(255) NOT NULL,
    date_of_birth     varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS ReadingRoom
(
    id         serial PRIMARY KEY,
    library_id   int8,
    reader_id    int8,
    residueReader   integer NOT NULL DEFAULT 0,
    FOREIGN KEY (library_id) REFERENCES Library (id),
    FOREIGN KEY (reader_id) REFERENCES Reader (id)
);