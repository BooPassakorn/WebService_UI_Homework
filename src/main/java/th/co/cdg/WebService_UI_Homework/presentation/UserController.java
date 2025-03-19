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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<ArrayList<UserStoryDTO>> getAllStoryByuuid (@PathVariable(name = "uuid") String uuid) {

        int result = userRepository.queryStoryUserByuuid(uuid).size();

        if (result != 0) {
        return ResponseEntity
                .ok()
                .body(userRepository.queryStoryUserByuuid(uuid));
        } else {
            return ResponseEntity
                    .noContent()
                    .build();
        }
    }

    @GetMapping(value = "get-all-story-users")
    public ResponseEntity<ArrayList<UserStoryDTO>> getAllStory(){
            return ResponseEntity
                    .ok()
                    .body(userRepository.queryStoryUser());
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

    @PutMapping(value = "update-gender")
    public ResponseEntity<Object> updateUserGender(@RequestBody Map<String, String> requestBody) {

        String uuid = requestBody.get("uuid");
        String user_gender = requestBody.get("user_gender");

        if (uuid == null || user_gender == null) {
            return ResponseEntity
                    .badRequest()
                    .body("UUID and gender are required");
        }

        int result = userRepository.updateUserGender(uuid, user_gender);

        if (result != 0) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Gender updated successfully");

            Map<String, String> updatedUserGender = new HashMap<>();
            updatedUserGender.put("user_gender", user_gender);
            response.put("updatedGender", updatedUserGender);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("Cannot update gender");
        }
    }

    @PutMapping(value = "update-date-of-birth")
    public ResponseEntity<Object> updateUserDateOfBirth(@RequestBody Map<String, String> requestBody) {

        String uuid = requestBody.get("uuid");
        String user_date_of_birth = requestBody.get("user_date_of_birth");

        if (uuid == null || user_date_of_birth == null) {
            return ResponseEntity
                    .badRequest()
                    .body("UUID and Date are required");
        }

        int result = userRepository.updateUserDateOfBirth(uuid, user_date_of_birth);

        if (result != 0) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Birth date updated successfully");

            Map<String, String> updateUserDateOfBirth = new HashMap<>();
            updateUserDateOfBirth.put("user_date_of_birth", user_date_of_birth);
            response.put("updatedBirthOfDate", updateUserDateOfBirth);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("Cannot update gender");
        }
    }

}
