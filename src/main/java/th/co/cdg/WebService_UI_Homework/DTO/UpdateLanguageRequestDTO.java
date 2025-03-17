package th.co.cdg.WebService_UI_Homework.DTO;

import java.util.List;
import java.util.UUID;

public class UpdateLanguageRequestDTO {

    private List<UserLanguagesDTO> languages;
    private UUID uuid;

    public UpdateLanguageRequestDTO(UUID uuid, List<UserLanguagesDTO> languages) {
        this.uuid = uuid;
        this.languages = languages;
    }

    public UpdateLanguageRequestDTO() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<UserLanguagesDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<UserLanguagesDTO> languages) {
        this.languages = languages;
    }
}
