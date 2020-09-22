DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id BIGINT,
  name VARCHAR(32),
  birth DATETIME,
  PRIMARY KEY (id)
);

INSERT INTO person (id, name, birth) VALUES (0, 'Stef', '2020-09-01 00:00:00');
INSERT INTO person (id, name, birth) VALUES (1, 'Nick', '2020-09-02 00:00:00');


