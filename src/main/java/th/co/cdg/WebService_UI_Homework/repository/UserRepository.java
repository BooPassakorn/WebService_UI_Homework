package th.co.cdg.WebService_UI_Homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import th.co.cdg.WebService_UI_Homework.DTO.UserDTO;
import th.co.cdg.WebService_UI_Homework.DTO.UserLanguagesDTO;
import th.co.cdg.WebService_UI_Homework.DTO.UserResponseDTO;
import th.co.cdg.WebService_UI_Homework.DTO.UserStoryDTO;
import th.co.cdg.WebService_UI_Homework.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.SUPPORTS)
    public byte[] getImageById(String user_id){

        String sql = " SELECT USER_PROFILE FROM USER " +
                " WHERE USER_ID = :user_id ";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("user_id", user_id);

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

    @Transactional(Transactional.TxType.SUPPORTS)
    public ArrayList<UserStoryDTO> queryStoryUserByuuid(String uuid){

        String sql = " SELECT uuid, user_name, user_profile, story FROM USER " +
                " WHERE uuid = :uuid ";

//        String sql = "SELECT uuid, user_name, user_profile, story FROM USER WHERE uuid = :uuid AND story = true";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("uuid", uuid);

        ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

        ArrayList<UserStoryDTO> userStoryDTOS = new ArrayList<>();

        resultList.forEach(result -> {
            UserStoryDTO user = new UserStoryDTO();
            user.setUuid(UUID.fromString((String) result[0]));
            user.setUser_name((String) result[1]);
            user.setUser_profile((byte[]) result[2]);
            user.setStory((Boolean) result[3]);
            userStoryDTOS.add(user);
        });

        return userStoryDTOS;
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public ArrayList<UserStoryDTO> queryStoryUser(){

        String sql = " SELECT uuid, user_name, user_profile, story FROM USER ";

        Query query = entityManager.createNativeQuery(sql);

        ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

        ArrayList<UserStoryDTO> userStoryDTOS = new ArrayList<>();

        resultList.forEach(result -> {
            UserStoryDTO user = new UserStoryDTO();
            user.setUuid(UUID.fromString((String) result[0]));
            user.setUser_name((String) result[1]);
            user.setUser_profile((byte[]) result[2]);
            user.setStory((Boolean) result[3]);
            userStoryDTOS.add(user);
        });

        return userStoryDTOS;
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public UserResponseDTO queryAllUser(String uuid) {

        String sql = "SELECT * FROM USER WHERE uuid = :uuid";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("uuid", uuid);

        List<Object[]> resultList = query.getResultList();

        List<UserDTO> users = new ArrayList<>();

        for (Object[] result : resultList) {
            UserDTO user = new UserDTO();
            user.setUuid(UUID.fromString((String) result[0]));
            user.setUser_id((String) result[1]);
            user.setUser_name((String) result[2]);
            user.setUser_profile((byte[]) result[3]);
            user.setUser_verified((Boolean) result[4]);
            user.setUser_introduce((String) result[5]);
            user.setUser_gender((String) result[6]);
            user.setUser_date_of_birth((Date) result[7]);
            user.setFollowers(Long.valueOf(result[8].toString()));
            user.setFollowing(Long.valueOf(result[9].toString()));
            user.setPost(Long.valueOf(result[10].toString()));
            user.setStory((Boolean) result[11]);

            users.add(user);
        }

        //ดึงข้อมูล languages ตาม uuid
        String sqlLanguages = "SELECT language_id FROM USER_LANGUAGES WHERE uuid = :uuid";

        Query queryLanguages = entityManager.createNativeQuery(sqlLanguages);

        queryLanguages.setParameter("uuid", uuid);

        List<Integer> languageIds = queryLanguages.getResultList();

        List<UserLanguagesDTO> languages = new ArrayList<>();

        for (Integer id : languageIds) {
            UserLanguagesDTO lang = new UserLanguagesDTO();
            lang.setLanguage_id(id);
            languages.add(lang);
        }

        //รวมข้อมูลทั้งหมดลงใน DTO
        UserResponseDTO response = new UserResponseDTO();
        response.setUsers(users);
        response.setLanguages(languages);

        return response;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int updateUserGender(String uuid, String user_gender) {

        String sql = "UPDATE USER SET USER_GENDER = :user_gender WHERE UUID = :uuid";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("uuid", uuid);
        query.setParameter("user_gender", user_gender);

        return query.executeUpdate();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public int updateUserDateOfBirth(String uuid, String user_date_of_birth) {

        String sql = "UPDATE USER SET USER_DATE_OF_BIRTH = :user_date_of_birth WHERE UUID = :uuid";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("uuid", uuid);
        query.setParameter("user_date_of_birth", user_date_of_birth);

        return query.executeUpdate();
    }
}
