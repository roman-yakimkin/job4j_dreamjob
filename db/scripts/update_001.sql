drop table if exists post;

drop table if exists candidate;

CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    name TEXT
);

insert into post (name) values
    ('Junior Java Job'),
    ('Middle Java Job'),
    ('Senior Java Job');

CREATE TABLE candidate (
    id SERIAL PRIMARY KEY,
    name TEXT
);

insert into candidate (name) values
('Trainee Java Job developer'),
('Junior Java Job developer'),
('Middle Java Job developer'),
('Senior Java Job developer');
