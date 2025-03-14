package th.co.cdg.WebService_UI_Homework.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.cdg.WebService_UI_Homework.DTO.UserResponseDTO;
import th.co.cdg.WebService_UI_Homework.DTO.UserStoryDTO;
import th.co.cdg.WebService_UI_Homework.model.User;
import th.co.cdg.WebService_UI_Homework.repository.UserRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value ="image/{user_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageController(@PathVariable String user_id) {
        return ResponseEntity
                .ok()
                .body(userRepository.getImageById(user_id));
    }

    @PutMapping(value = "update-user")
    public ResponseEntity<String> updateUserByIdController (@RequestBody User user) {

        int result = userRepository.updateUserById(user);

        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("Update user successfully");
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Cannot update user");
        }
    }

    @DeleteMapping(value = "delete-user/{id}")
    public ResponseEntity<String> deleteUserByIdController (@PathVariable(name = "id") Long id) {
        int result = userRepository.deleteUserById(id);

        if (result != 0) {
            return ResponseEntity
                    .ok()
                    .body("Delete user successfully");
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Cannot delete user");
        }
    }

    @GetMapping(value = "story-users/{uuid}")
    public ResponseEntity<ArrayList<UserStoryDTO>> getAllStory (@PathVariable(name = "uuid") String uuid) {

        int result = userRepository.queryStoryUser(uuid).size();

        if (result != 0) {
        return ResponseEntity
                .ok()
                .body(userRepository.queryStoryUser(uuid));
        } else {
            return ResponseEntity
                    .noContent()
                    .build();
        }
    }

    @GetMapping("all-user/{uuid}")
    public ResponseEntity<UserResponseDTO> getUsers(@PathVariable(name = "uuid") String uuid) {

        UserResponseDTO response = userRepository.queryAllUser(uuid);

        if (response.getUsers().isEmpty()) {
        return ResponseEntity
                .noContent()
                .build();
        } else {
            return ResponseEntity
                    .ok()
                    .body(response);
        }
    }

}
