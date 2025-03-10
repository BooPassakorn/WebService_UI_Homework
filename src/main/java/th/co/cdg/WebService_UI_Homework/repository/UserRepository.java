package th.co.cdg.WebService_UI_Homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import th.co.cdg.WebService_UI_Homework.model.User;

import java.util.ArrayList;
import java.util.Date;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.SUPPORTS)
    public ArrayList<User> queryAllUser() {

        String sql = " SELECT * " +
                " FROM USER ";

        Query query = entityManager.createNativeQuery(sql);

        ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

        ArrayList<User> users = new ArrayList<>();

        resultList.forEach(result -> {
            User user = new User();
            user.setUser_id(((Integer) result[0]).longValue());
            user.setUser_name((String) result[1]);
            user.setUser_nickname((String) result[2]);
            user.setUser_profile((byte[]) result[3]);
            user.setUser_verified((Boolean) result[4]);
            user.setUser_bio((String) result[5]);
            user.setUser_gender(User.Gender.valueOf((String) result[6]));
            user.setUser_date_of_birth((Date) result[7]);
            user.setFollowers((Long) result[8]);
            user.setFollowing((Long) result[9]);
            user.setPost((Long) result[10]);
            user.setStory((Boolean) result[11]);
            users.add(user);
        });

        return users;
    }

}
