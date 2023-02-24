package br.com.api.roleplay_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.roleplay_project.model.CharacterModel;
import br.com.api.roleplay_project.model.ResponseModel;
import br.com.api.roleplay_project.services.CharacterServices;

@RestController
@CrossOrigin(origins = "*")
public class CharacterController {

    @Autowired
    private CharacterServices cs;

    @DeleteMapping("/deleteCharacter/{id}")
    public ResponseEntity<ResponseModel> deleteCharacter(@PathVariable long id) {
        return cs.charRmv(id);
    }

    @PutMapping("/updateCharacter")
    public ResponseEntity<?> updateCharacter(@RequestBody CharacterModel cm){
        return cs.charUpdtCrt(cm, "update");
    }

    @PostMapping("/createCharacter")
    public ResponseEntity<?> createCharacter(@RequestBody CharacterModel cm){
        return cs.charUpdtCrt(cm, "create");
    }

    @GetMapping("/listCharacter")
    public Iterable<CharacterModel> listCharacter(){
        return cs.charList();
    }

    @GetMapping("/")
    public String route(){
        return "API working normally";
    }

}
