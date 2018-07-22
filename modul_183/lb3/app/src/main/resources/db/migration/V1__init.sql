CREATE TABLE users (
    id bigserial NOT NULL,
    username character varying(64) NOT NULL,
    password character(60) NOT NULL
);

ALTER TABLE ONLY users
  ADD CONSTRAINT users_pkey PRIMARY KEY (id),
  ADD CONSTRAINT unique_username UNIQUE (username);

INSERT INTO users (username, password)
  VALUES ('lb3', crypt('gibbiX12345', gen_salt('bf')));