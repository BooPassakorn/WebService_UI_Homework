package th.co.cdg.WebService_UI_Homework.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Bookmark_post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookmark_id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getBookmark_id() {
        return bookmark_id;
    }

    public void setBookmark_id(int bookmark_id) {
        this.bookmark_id = bookmark_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
