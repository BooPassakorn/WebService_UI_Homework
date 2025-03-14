package th.co.cdg.WebService_UI_Homework.DTO;

import java.util.List;

public class UserResponseDTO {

    private List<UserDTO> users;
    private List<UserLanguagesDTO> languages;

    public UserResponseDTO(List<UserDTO> users, List<UserLanguagesDTO> languages) {
        this.users = users;
        this.languages = languages;
    }

    public UserResponseDTO() {
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserLanguagesDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<UserLanguagesDTO> languages) {
        this.languages = languages;
    }
}
