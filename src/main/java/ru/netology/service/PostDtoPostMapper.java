package ru.netology.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.netology.model.Post;
import ru.netology.model.PostDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostDtoPostMapper {
    @Mapping(target = "id", source = "post.id")
    @Mapping(target = "content", source = "post.content")
    PostDto PostToPostDto(Post post);

    @Mapping(target = "id", source = "postDto.id")
    @Mapping(target = "content", source = "postDto.content")
    Post PostDtoToPost(PostDto postDto);

    List<PostDto> postToPostDto(List<Post> posts);
}
