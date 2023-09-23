package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryStubImpl implements PostRepository {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();
    private final AtomicLong count = new AtomicLong(1);

    @Override
    public List<Post> all() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Optional<Post> getById(long id) {
        if (posts.containsKey(id)) {
            return Optional.ofNullable(posts.get(id));
        }
        System.out.println("Такого поста не существует");
        return Optional.empty();
    }

    @Override
    public Post save(Post post) {
        if (post.getId() == 0) {
            Post post1 = new Post(count.get(), post.getContent());
            posts.put(count.getAndIncrement(), post1);
            return post1;
        } else if (post.getId() != 0 && posts.containsKey(post.getId())) {
            posts.replace(post.getId(), post);
            return post;
        }
        System.out.println("Невозможно выполнить обновление поста. Пост с id = " + post.getId() + " был удален или не существует.");
        return null;
    }

    @Override
    public void removeById(long id) {
        if (posts.containsKey(id)) {
            posts.remove(id);
        } else {
            throw new NotFoundException();
        }
    }
}
