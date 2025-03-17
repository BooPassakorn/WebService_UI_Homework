package th.co.cdg.WebService_UI_Homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import th.co.cdg.WebService_UI_Homework.model.Languages;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Transactional(Transactional.TxType.REQUIRED)
    public List<String> updateUserLanguages(UUID uuid, List<Integer> languageIds) {

        if (uuid == null || languageIds == null) {
            throw new IllegalArgumentException("UUID or Language IDs cannot be null.");
        }

        //ลบข้อมูลเก่า
        String sqlDelete = "DELETE FROM User_Languages WHERE uuid = :uuid";

        Query queryDelete = entityManager.createNativeQuery(sqlDelete);

        queryDelete.setParameter("uuid", uuid);
        queryDelete.executeUpdate();

        //เพิ่มข้อมูลใหม่
        for (Integer languageId : languageIds) {

            String sqlInsert = "INSERT INTO User_Languages (language_id, uuid) VALUES (:languageId, :uuid)";

            Query queryInsert = entityManager.createNativeQuery(sqlInsert);

            queryInsert.setParameter("languageId", languageId);
            queryInsert.setParameter("uuid", uuid);
            queryInsert.executeUpdate();
        }

        //ตรวจสอบว่า languageIds มีค่าหรือไม่
        if (languageIds.isEmpty()) {
            return new ArrayList<>();
        }

        //ดึงภาษาที่อัปเดต
        String sql = "SELECT language FROM Languages WHERE language_id IN (:languageIds)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("languageIds", languageIds);

        List<String> updatedLanguages = query.getResultList();

        return updatedLanguages;
    }
}
