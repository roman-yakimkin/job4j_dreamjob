drop table if exists "city";

CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name text not null
);

ALTER TABLE candidate
    ADD column city_id int references city(id);

insert into city (name)  values
    ('Москва'), ('Санкт-Петербург'), ('Нижний Новгород'), ('Ростов-на-Дону'), ('Смоленск'), ('Казань'), ('Тула');
