package ru.job4j.dream.model;

import java.util.Objects;

/**
 * Модель - вакансия
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 13.06.2020
 * @version 1.0
 */
public class Post {
    private int id;
    private String name;

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
