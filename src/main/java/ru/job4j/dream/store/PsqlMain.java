package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для демонстрации записи вакансии в БД
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 16.06.2020
 * @version 1.0
 */
public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.removeAllPosts();
        store.removeAllCandidates();

        store.savePost(new Post(0, "Java Job 1"));
        store.savePost(new Post(0, "Java Job 2"));
        store.savePost(new Post(0, "Java Job 3"));
        System.out.println("Testing of all posts =====");
        List<Integer> ids = new ArrayList<Integer>();
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
            ids.add(post.getId());
        }
        System.out.println("Testing of getting post =====");
        for (int id : ids) {
            Post post = store.findPostById(id);
            System.out.println(post.getId() + " " + post.getName());
        }

        store.saveCandidate(new Candidate(0, "Java Trainee developer"));
        store.saveCandidate(new Candidate(0, "Java Junior developer"));
        store.saveCandidate(new Candidate(0, "Java Middle developer"));
        store.saveCandidate(new Candidate(0, "Java Senior developer"));
        System.out.println("Testing of all candidates =====");
        ids.clear();
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
            ids.add(candidate.getId());
        }
        System.out.println("Testing of getting candidate  =====");
        for (int id : ids) {
            Candidate candidate = store.findCandidateById(id);
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
    }
}
