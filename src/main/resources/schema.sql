drop table if exists userdb;

CREATE TABLE userdb(
    id LONG NOT NULL,
    username VARCHAR(255),
    email VARCHAR(255),
    dob DATE,
    PRIMARY KEY(id)
);