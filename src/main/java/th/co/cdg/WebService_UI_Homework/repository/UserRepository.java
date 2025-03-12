package th.co.cdg.WebService_UI_Homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
            user.setUser_id(((String) result[0]));
            user.setUser_name((String) result[1]);
            user.setUser_profile((byte[]) result[3]);
            user.setUser_verified((Boolean) result[4]);
            user.setUser_introduce((String) result[5]);
            user.setUser_gender(((String) result[6]));
            user.setUser_date_of_birth((Date) result[7]);
            user.setFollowers(Long.valueOf((String) result[8]));
            user.setFollowing(Long.valueOf((String) result[9]));
            user.setPost(Long.valueOf((String) result[10]));
            user.setStory((Boolean) result[11]);
            users.add(user);
        });

        return users;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int insertNewUser(User user) {

        String sql = " INSERT INTO USER " +
                " VALUES(:user_id, :user_name, :user_profile, " +
                ":user_verified, :user_bio, :user_gender, :user_date_of_birth," +
                " :followers, :following, :post, :story)";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("user_id", user.getUser_id());
        query.setParameter("user_name", user.getUser_name());
        query.setParameter("user_profile", user.getUser_profile());
        query.setParameter("user_verified", user.getUser_verified());
        query.setParameter("user_bio", user.getUser_introduce());
        query.setParameter("user_gender", user.getUser_gender());
        query.setParameter("user_date_of_birth", user.getUser_date_of_birth());
        query.setParameter("followers", user.getFollowers());
        query.setParameter("following", user.getFollowing());
        query.setParameter("post", user.getPost());
        query.setParameter("story", user.getStory());

        return query.executeUpdate();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public byte[] getImageById(Long id){

        String sql = " SELECT USER_PROFILE FROM USER " +
                " WHERE USER_ID = :id ";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("id", id);

        try {
            return (byte[]) query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int updateUserById(User user) {

        String sql = " UPDATE USER SET " ;

        if (null != user.getUser_name()) {
            sql += " USER_NAME = :user_name " ;
            if (null != user.getUser_profile() || null != user.getUser_verified() || null != user.getUser_introduce()
            || null != user.getUser_gender() || null != user.getUser_date_of_birth() || null != user.getFollowers() || null != user.getFollowing()
            || null != user.getPost() || null != user.getStory()){
                sql += " , ";
            }
        }

        if (null != user.getUser_profile()) {
            sql += " USER_PROFILE = :user_profile ";
            if (null != user.getUser_verified() || null != user.getUser_introduce() || null != user.getUser_gender() || null != user.getUser_date_of_birth()
            || null != user.getFollowers() || null != user.getFollowing() || null != user.getPost() || null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getUser_id()) {
            sql += " USER_BIO = :user_bio ";
            if (null != user.getUser_gender() || null != user.getUser_date_of_birth() || null != user.getFollowers() || null != user.getFollowing()
            || null != user.getPost() || null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getUser_gender()) {
            sql += " USER_GENDER = :user_gender ";
            if (null != user.getUser_date_of_birth() || null != user.getFollowers() || null != user.getFollowing() || null != user.getPost() || null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getUser_date_of_birth()) {
            sql += " USER_DATE_OF_BIRTH = :user_date_of_birth ";
            if (null != user.getFollowers() || null != user.getFollowing() || null != user.getPost() || null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getFollowers()) {
            sql += " FOLLOWERS = :followers ";
            if (null != user.getFollowing() || null != user.getPost() || null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getFollowing()) {
            sql += " FOLLOWING = :following ";
            if (null != user.getPost() || null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getPost()) {
            sql += " POST = :post ";
            if (null != user.getStory()) {
                sql += " , ";
            }
        }

        if (null != user.getStory()) {
            sql += " STOY = :story ";
        }

        sql += " WHERE USER_ID = :id ";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("id", user.getUser_id());

        if (null != user.getUser_name()) {
            query.setParameter("user_name", user.getUser_name());
        }

        if (null != user.getUser_profile()) {
            query.setParameter("user_profile", user.getUser_profile());
        }

        if (null != user.getUser_introduce()) {
            query.setParameter("user_introduce", user.getUser_introduce());
        }

        if (null != user.getUser_gender()) {
            query.setParameter("user_gender", user.getUser_gender());
        }

        if (null != user.getUser_date_of_birth()) {
            query.setParameter("user_date_of_birth", user.getUser_date_of_birth());
        }

        if (null != user.getFollowers()) {
            query.setParameter("followers", user.getFollowers());
        }

        if (null != user.getFollowing()) {
            query.setParameter("following", user.getFollowing());
        }

        if (null != user.getPost()) {
            query.setParameter("post", user.getPost());
        }

        if (null != user.getStory()) {
            query.setParameter("story", user.getStory());
        }

        return query.executeUpdate();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int deleteUserById(Long id){

        String sql = " DELETE FROM USER " +
                " WHERE USER_ID = :id ";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("id", id);

        return query.executeUpdate();
    }
}
