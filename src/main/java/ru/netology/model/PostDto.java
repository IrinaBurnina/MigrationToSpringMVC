package ru.netology.model;

public class PostDto {
    private long id;
    private String content;


    public PostDto(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public PostDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto post = (PostDto) o;
        return id == post.id;
    }
}
