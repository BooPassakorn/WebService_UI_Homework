package th.co.cdg.WebService_UI_Homework.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.cdg.WebService_UI_Homework.model.Languages;
import th.co.cdg.WebService_UI_Homework.repository.LanguageRepository;

import java.util.ArrayList;

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
}
