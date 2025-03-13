package th.co.cdg.WebService_UI_Homework.DTO;

import java.util.Date;
import java.util.UUID;

public class UserPostDTO {

    private int post_id;
    private UUID uuid;
    private String user_id;
    private String user_name;
    private byte[] user_profile;
    private Boolean user_verified;
    private Date post_created_datetime;
    private String post_caption;
    private byte[] post_image;
    private Boolean post_recommend;
    private Boolean post_trending;

    public UserPostDTO(int post_id, UUID uuid, String user_id, String user_name, byte[] user_profile, Boolean user_verified, Date post_created_datetime, String post_caption, byte[] post_image, Boolean post_recommend, Boolean post_trending) {
        this.post_id = post_id;
        this.uuid = uuid;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_profile = user_profile;
        this.user_verified = user_verified;
        this.post_created_datetime = post_created_datetime;
        this.post_caption = post_caption;
        this.post_image = post_image;
        this.post_recommend = post_recommend;
        this.post_trending = post_trending;
    }

    public UserPostDTO() {
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public byte[] getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(byte[] user_profile) {
        this.user_profile = user_profile;
    }

    public Boolean getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(Boolean user_verified) {
        this.user_verified = user_verified;
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

    public Boolean getPost_recommend() {
        return post_recommend;
    }

    public void setPost_recommend(Boolean post_recommend) {
        this.post_recommend = post_recommend;
    }

    public Boolean getPost_trending() {
        return post_trending;
    }

    public void setPost_trending(Boolean post_trending) {
        this.post_trending = post_trending;
    }
}
