package ru.netology.service;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import org.springframework.stereotype.Service;
import ru.netology.model.PostDto;
import ru.netology.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;
    private final PostDtoPostMapper postDtoPostMapper;

    public PostService(PostRepository repository, PostDtoPostMapper postDtoPostMapper) {
        this.repository = repository;
        this.postDtoPostMapper = postDtoPostMapper;
    }

    public List<PostDto> all() {

        return postDtoPostMapper.postToPostDto(repository.all());
    }

    public PostDto getById(long id) throws NotFoundException {
        return postDtoPostMapper.PostToPostDto(repository.getById(id).orElseThrow(NotFoundException::new));
    }

    public PostDto save(PostDto postDto) {
        Post post = postDtoPostMapper.PostDtoToPost(postDto);
        return postDtoPostMapper.PostToPostDto(repository.save(post));
    }

    public PostDto removeById(long id) {
        repository.removeById(id);
        return getById(id);
    }
}
