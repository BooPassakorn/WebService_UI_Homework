package th.co.cdg.WebService_UI_Homework.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Languages {

    @Id
    private int language_id;

    private String language;

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
