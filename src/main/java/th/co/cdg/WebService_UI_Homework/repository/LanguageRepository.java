package th.co.cdg.WebService_UI_Homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import th.co.cdg.WebService_UI_Homework.model.Languages;

import java.util.ArrayList;

@Repository
public class LanguageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.SUPPORTS)
    public ArrayList<Languages> queryAllLanguages() {

        String sql = "SELECT * FROM Languages ";

        Query query = entityManager.createNativeQuery(sql);

        ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

        ArrayList<Languages> languages = new ArrayList<>();

        resultList.forEach(result -> {
            Languages language = new Languages();
            language.setLanguage_id((Integer) result[0]);
            language.setLanguage((String) result[1]);
            languages.add(language);
        });

        return languages;
    }
}
