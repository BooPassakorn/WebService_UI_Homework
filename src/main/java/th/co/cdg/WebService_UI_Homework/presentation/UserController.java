package th.co.cdg.WebService_UI_Homework.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.co.cdg.WebService_UI_Homework.model.User;
import th.co.cdg.WebService_UI_Homework.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "get-all-users")
    public ResponseEntity<ArrayList<User>> getAllUserController () {
        return ResponseEntity
                .ok()
                .body(userRepository.queryAllUser());
    }

    @PostMapping(value = "add-user", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addUserController (@RequestParam(name = "userData") String userData,
                                                     @RequestParam(name = "image") MultipartFile image) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userData, User.class);
        byte[] imageProfile = image.getBytes();
        user.setUser_profile(imageProfile);
        try {
            int result = userRepository.insertNewUser(user);

            if (result != 0) {
                return ResponseEntity
                        .ok()
                        .body("Add new user successfully");
            } else {
                return ResponseEntity
                        .badRequest()
                        .body("Cannot add new user");
            }
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Cannot add new user cause SQL problem.");
        }
    }

    @GetMapping(value ="image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageController(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(userRepository.getImageById(id));
    }

    @PutMapping(value = "update-user", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateUserByIdController (@RequestBody User user,
                                                            @RequestParam(name = "image") MultipartFile image) throws IOException {

        byte[] imageProfile = image.getBytes();
        user.setUser_profile(imageProfile);
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
}
