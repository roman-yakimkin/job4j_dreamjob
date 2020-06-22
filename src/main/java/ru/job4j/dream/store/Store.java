package ru.job4j.dream.store;

import ru.job4j.dream.model.*;

import java.util.Collection;

/**
 * Интерфейс для хранения данных
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 16.06.2020
 * @version 1.0
 */
public interface Store {
    Collection<Post> findAllPosts();
    Collection<Candidate> findAllCandidates();
    Collection<Photo> findAllPhotos();
    Collection<City> findAllCities();
    void savePost(Post post);
    void saveCandidate(Candidate candidate);
    void removeCandidate(int id);
    Post findPostById(int id);
    Candidate findCandidateById(int id);
    void removeAllPosts();
    void removeAllCandidates();
    int addPhotoRecord(String name);
    void removePhoto(int id);
    String getPhotoFolder();
    Photo findPhotoById(int id);
    User findUser(String email);
    User findUser(String email, String password);
    User findUser(int id);
    void saveUser(User user);
    void removeUser(User user);

}
