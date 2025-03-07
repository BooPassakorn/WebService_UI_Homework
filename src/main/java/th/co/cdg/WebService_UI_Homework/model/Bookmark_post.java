package th.co.cdg.WebService_UI_Homework.model;

import java.util.UUID;

public class Bookmark_post {

    private int bookmark_id;
    private UUID post_id;
    private UUID user_id;

    public int getBookmark_id() {
        return bookmark_id;
    }

    public void setBookmark_id(int bookmark_id) {
        this.bookmark_id = bookmark_id;
    }

    public UUID getPost_id() {
        return post_id;
    }

    public void setPost_id(UUID post_id) {
        this.post_id = post_id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
}
