package th.co.cdg.WebService_UI_Homework.DTO;

public class UserLanguagesDTO {

    private int language_id;

    public UserLanguagesDTO(int language_id) {
        this.language_id = language_id;
    }

    public UserLanguagesDTO() {
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
