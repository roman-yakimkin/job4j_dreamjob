package ru.job4j.dream.model;

import java.util.Objects;

/**
 * Класс - кандидат на должность
 * @author Roman Yakimkin
 * @since 14.06.2020
 * @version 1.0
 */
public class Candidate {
    private int id;
    private String name;
    private int photoId;
    private int cityId;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
        this.photoId = 0;
        this.cityId = 0;
    }

    public Candidate(int id, String name, int photoId, int cityId) {
        this(id, name);
        this.photoId = photoId;
        this.cityId = cityId;
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

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id
                && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
