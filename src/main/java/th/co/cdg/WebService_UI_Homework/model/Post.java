package th.co.cdg.WebService_UI_Homework.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int post_id;

    private Date post_created_datetime;
    private String post_caption;
    private byte[] post_image;
    private Boolean post_recommend;
    private Boolean post_trending;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
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
}
