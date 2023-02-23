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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable long id) {
        return cs.remove(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CharacterModel cm) {
        return cs.charUpdt(cm, "update");
    }

    @PostMapping("/create")
    public ResponseEntity<?> register(@RequestBody CharacterModel cm){
        return cs.charUpdt(cm, "register");
    }

    @GetMapping("/listCharacter")
    public Iterable<CharacterModel> listCharacter(){
        return cs.listCharacter();
    }

    @GetMapping("/")
    public String route(){
        return "API working normally";
    }

}
