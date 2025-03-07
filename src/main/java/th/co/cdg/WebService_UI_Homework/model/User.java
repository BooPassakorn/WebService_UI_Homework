package th.co.cdg.WebService_UI_Homework.model;

import java.util.Date;
import java.util.UUID;

public class User {

    private UUID user_id;
    private String user_name;
    private String user_nickname;
    private byte[] user_profile;
    private Boolean user_verified;
    private String user_bio;
    private enum user_gender {male, female}
    private Date user_date_of_birth;
    private Long followers;
    private Long following;
    private Long post;
    private Boolean story;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
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

    public String getUser_bio() {
        return user_bio;
    }

    public void setUser_bio(String user_bio) {
        this.user_bio = user_bio;
    }

    public Date getUser_date_of_birth() {
        return user_date_of_birth;
    }

    public void setUser_date_of_birth(Date user_date_of_birth) {
        this.user_date_of_birth = user_date_of_birth;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }

    public Long getPost() {
        return post;
    }

    public void setPost(Long post) {
        this.post = post;
    }

    public Boolean getStory() {
        return story;
    }

    public void setStory(Boolean story) {
        this.story = story;
    }
}
