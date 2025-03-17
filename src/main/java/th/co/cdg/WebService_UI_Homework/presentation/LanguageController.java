package th.co.cdg.WebService_UI_Homework.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.cdg.WebService_UI_Homework.DTO.UpdateLanguageRequestDTO;
import th.co.cdg.WebService_UI_Homework.DTO.UserLanguagesDTO;
import th.co.cdg.WebService_UI_Homework.model.Languages;
import th.co.cdg.WebService_UI_Homework.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping(value = "get-all-languages")
    public ResponseEntity<ArrayList<Languages>> getAllLanguages() {
        return ResponseEntity
                .ok()
                .body(languageRepository.queryAllLanguages());
    }

    @PutMapping(value = "update-languages")
    public ResponseEntity<?> updateLanguages(@RequestBody UpdateLanguageRequestDTO updateLanguageRequestDTO) {
        List<Integer> languageIds = updateLanguageRequestDTO.getLanguages()
                .stream()
                .map(UserLanguagesDTO::getLanguage_id)
                .toList();

        List<String> updatedLanguages = languageRepository.updateUserLanguages(updateLanguageRequestDTO.getUuid(), languageIds);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Languages updated successfully");

        Map<String, List<String>> updateLanguages = new HashMap<>();
        updateLanguages.put("languages", updatedLanguages);
        response.put("updateLanguages", updateLanguages);

        return ResponseEntity.ok(response);
    }
}
