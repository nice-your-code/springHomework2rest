CREATE TABLE account (
  id        NUMERIC       NOT NULL,
  owner_id  NUMERIC       NOT NULL,
  name      VARCHAR(255)  NOT NULL,
  rate      FLOAT         NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE owner (
  id          NUMERIC       NOT NULL,
  company_id  NUMERIC       NOT NULL,
  first_name  VARCHAR(255)  NOT NULL,
  second_name VARCHAR(255)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE company (
  id          NUMERIC       NOT NULL,
  title       VARCHAR(255)  NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO account (id, owner_id, name, rate) VALUES (1,1,'Ac Green',120.0);
INSERT INTO account (id, owner_id, name, rate) VALUES (2,1,'Ac Green 2',130.0);
INSERT INTO account (id, owner_id, name, rate) VALUES (3,2,'Microsoft',2000.0);
INSERT INTO account (id, owner_id, name, rate) VALUES (4,3,'Secret world team', 10000.0);
INSERT INTO account (id, owner_id, name, rate) VALUES (5,3,'Politics', 12000.0);
INSERT INTO account (id, owner_id, name, rate) VALUES (6,4,'Hacker Ivanov Ivan', 50000.0);

INSERT INTO owner (id, company_id, first_name, second_name) VALUES (1,1,'Mark','Green');
INSERT INTO owner (id, company_id, first_name, second_name) VALUES (2,2,'Bill','Gates');
INSERT INTO owner (id, company_id, first_name, second_name) VALUES (3,3,'Vladimir','Putin');
INSERT INTO owner (id, company_id, first_name, second_name) VALUES (4,3,'Ivanov','Ivan');

INSERT INTO company (id, title) VALUES (1,'Mr Green Company');
INSERT INTO company (id, title) VALUES (2,'Microsoft Corporation');
INSERT INTO company (id, title) VALUES (3,'Ivan Company');