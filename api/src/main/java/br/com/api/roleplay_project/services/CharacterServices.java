package br.com.api.roleplay_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.roleplay_project.model.CharacterModel;
import br.com.api.roleplay_project.model.ResponseModel;
import br.com.api.roleplay_project.repository.CharacterRepository;

@Service
public class CharacterServices {
    
    @Autowired
    private CharacterRepository cr;

    @Autowired
    private ResponseModel rm;

    // List of characters method
    public Iterable<CharacterModel> charList(){
        return cr.findAll();
    }

    // Register and update character method
    public ResponseEntity<?> charUpdtCrt(CharacterModel cm, String action){
        
        if(cm.getName().equals("")) {
            rm.setMessage("Nome do personagem obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);

        } else if(cm.getSecondName().equals("")) {
            rm.setMessage("Sobrenome do personagem obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);

        } else {
            if(action.equals("create")) {
                return new ResponseEntity<CharacterModel>(cr.save(cm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<CharacterModel>(cr.save(cm), HttpStatus.OK);
            }
            
        }
    }

    public ResponseEntity<ResponseModel> charRmv(long id){
        cr.deleteById(id);

        rm.setMessage("Personagem removido com sucesso!");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
