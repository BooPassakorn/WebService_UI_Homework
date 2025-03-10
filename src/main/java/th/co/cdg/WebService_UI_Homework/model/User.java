package th.co.cdg.WebService_UI_Homework.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID user_id;

    private String user_name;
    private String user_nickname;

    @Lob
    private byte[] user_profile;

    private Boolean user_verified;
    private String user_bio;

    @Enumerated(EnumType.STRING)
    private Gender user_gender;

    @Temporal(TemporalType.DATE)
    private Date user_date_of_birth;

    private Long followers;
    private Long following;
    private Long post;
    private Boolean story;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;

    public enum Gender {
        male, female
    }

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

    public Gender getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Gender user_gender) {
        this.user_gender = user_gender;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
