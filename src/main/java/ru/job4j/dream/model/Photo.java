package ru.job4j.dream.model;

import java.util.Objects;

/**
 * Класс - фото
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 17.06.2020
 * @version 1.0
 */
public class Photo {
    private int id;
    private String name;

    public Photo(int id, String name) {
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
        Photo photo = (Photo) o;
        return id == photo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
