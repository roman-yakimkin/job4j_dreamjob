drop table if exists "user";

CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    name text not null,
    email text unique not null,
    password text not null
);