package th.co.cdg.WebService_UI_Homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import th.co.cdg.WebService_UI_Homework.DTO.UserPostDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Repository
@RequestMapping ("api/post")
public class PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(Transactional.TxType.SUPPORTS)
    public ArrayList<UserPostDTO> queryAllUserPost() {

        String sql = " SELECT p.post_id, u.uuid, u.user_id, u.user_name, u.user_profile, u.user_verified, " +
                " p.post_caption, p.post_image, p.post_recommend, " +
                " p.post_trending, p.post_created_datetime " +
                "FROM post p INNER JOIN user u " +
                "ON p.uuid = u.uuid ";

        Query query = entityManager.createNativeQuery(sql);

        ArrayList<Object[]> resultList = (ArrayList<Object[]>) query.getResultList();

        ArrayList<UserPostDTO> posts = new ArrayList<>();

        resultList.forEach(result -> {
            UserPostDTO dto = new UserPostDTO();
            dto.setPost_id((Integer) result[0]);
            dto.setUuid(UUID.fromString((String) result[1]));
            dto.setUser_id((String) result[2]);
            dto.setUser_name((String) result[3]);
            dto.setUser_profile((byte[]) result[4]);
            dto.setUser_verified((Boolean) result[5]);
            dto.setPost_caption((String) result[6]);
            dto.setPost_image((byte[]) result[7]);
            dto.setPost_recommend((Boolean) result[8]);
            dto.setPost_trending((Boolean) result[9]);
            dto.setPost_created_datetime((Date) result[10]);
            posts.add(dto);
        });

        return posts;
    }
}
