package th.co.cdg.WebService_UI_Homework.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long language_id;

    private String language;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Long language_id) {
        this.language_id = language_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
