package th.co.cdg.WebService_UI_Homework.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.cdg.WebService_UI_Homework.DTO.SearchPostDTO;
import th.co.cdg.WebService_UI_Homework.DTO.UserPostDTO;
import th.co.cdg.WebService_UI_Homework.repository.PostRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping(value = "get-all-user-post")
    public ResponseEntity<ArrayList<UserPostDTO>> getAllPostUser() {
        return ResponseEntity
                .ok()
                .body(postRepository.queryAllUserPost());
    }

    @PostMapping(value = "search-post")
    public ResponseEntity<ArrayList<UserPostDTO>> searchPost(@RequestBody SearchPostDTO searchPostDTO) {
        return ResponseEntity
                .ok()
                .body(postRepository.searchPostByCaption(searchPostDTO.getPost_caption()));
    }
}
