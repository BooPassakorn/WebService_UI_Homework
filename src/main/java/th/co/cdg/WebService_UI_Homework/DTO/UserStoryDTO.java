package th.co.cdg.WebService_UI_Homework.DTO;

import java.util.UUID;

public class UserStoryDTO {
    private UUID uuid;
    private String user_name;
    private byte[] user_profile;
    private Boolean story;

    public UserStoryDTO(UUID uuid, String user_name, byte[] user_profile, Boolean story) {
        this.uuid = uuid;
        this.user_name = user_name;
        this.user_profile = user_profile;
        this.story = story;
    }

    public UserStoryDTO() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public Boolean getStory() {
        return story;
    }

    public void setStory(Boolean story) {
        this.story = story;
    }
}

