package th.co.cdg.WebService_UI_Homework.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long post_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date post_created_datetime;
    private String post_caption;

    @Lob
    private byte[] post_image;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Like_post> like_posts;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bookmark_post> bookmark_posts;

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Date getPost_created_datetime() {
        return post_created_datetime;
    }

    public void setPost_created_datetime(Date post_created_datetime) {
        this.post_created_datetime = post_created_datetime;
    }

    public String getPost_caption() {
        return post_caption;
    }

    public void setPost_caption(String post_caption) {
        this.post_caption = post_caption;
    }

    public byte[] getPost_image() {
        return post_image;
    }

    public void setPost_image(byte[] post_image) {
        this.post_image = post_image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like_post> getLike_posts() {
        return like_posts;
    }

    public void setLike_posts(List<Like_post> like_posts) {
        this.like_posts = like_posts;
    }
}
