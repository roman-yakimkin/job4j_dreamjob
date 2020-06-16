package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

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
    void savePost(Post post);
    void saveCandidate(Candidate candidate);
    Post findPostById(int id);
    Candidate findCandidateById(int id);
    void removeAllPosts();
    void removeAllCandidates();
}
