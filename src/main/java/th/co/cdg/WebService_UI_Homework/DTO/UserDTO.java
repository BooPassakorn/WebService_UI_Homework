package th.co.cdg.WebService_UI_Homework.DTO;

import java.util.Date;
import java.util.UUID;

public class UserDTO {
    private UUID uuid;
    private String user_id;
    private String user_name;
    private byte[] user_profile;
    private Boolean user_verified;
    private String user_introduce;
    private String user_gender;
    private Date user_date_of_birth;
    private Long followers;
    private Long following;
    private Long post;
    private Boolean story;

    public UserDTO(UUID uuid, String user_id, String user_name, byte[] user_profile, Boolean user_verified, String user_introduce, String user_gender, Date user_date_of_birth, Long followers, Long following, Long post, Boolean story) {
        this.uuid = uuid;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_profile = user_profile;
        this.user_verified = user_verified;
        this.user_introduce = user_introduce;
        this.user_gender = user_gender;
        this.user_date_of_birth = user_date_of_birth;
        this.followers = followers;
        this.following = following;
        this.post = post;
        this.story = story;
    }

    public UserDTO() {
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

    public String getUser_introduce() {
        return user_introduce;
    }

    public void setUser_introduce(String user_introduce) {
        this.user_introduce = user_introduce;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
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
}


