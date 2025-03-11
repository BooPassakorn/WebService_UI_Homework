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
            user.setUser_gender(((String) result[6]));
            user.setUser_date_of_birth((Date) result[7]);
            user.setFollowers((Long) result[8]);
            user.setFollowing((Long) result[9]);
            user.setPost((Long) result[10]);
            user.setStory((Boolean) result[11]);
            users.add(user);
        });

        return users;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int insertNewUser(User user) {

        String sql = " INSERT INTO USER " +
                " VALUES(:user_id, :user_name, :user_nickname, :user_profile, " +
                ":user_verified, :user_bio, :user_gender, :user_date_of_birth," +
                " :followers, :following, :post, :story)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("user_id", user.getUser_id());
        query.setParameter("user_name", user.getUser_name());
        query.setParameter("user_nickname", user.getUser_nickname());
        query.setParameter("user_profile", user.getUser_profile());
        query.setParameter("user_verified", user.getUser_verified());
        query.setParameter("user_bio", user.getUser_bio());
        query.setParameter("user_gender", user.getUser_gender());
        query.setParameter("user_date_of_birth", user.getUser_date_of_birth());
        query.setParameter("followers", user.getFollowers());
        query.setParameter("following", user.getFollowing());
        query.setParameter("post", user.getPost());
        query.setParameter("story", user.getStory());

        return query.executeUpdate();
    }

}
