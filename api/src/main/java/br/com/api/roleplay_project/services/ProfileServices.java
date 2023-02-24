package br.com.api.roleplay_project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.roleplay_project.model.ProfileModel;
import br.com.api.roleplay_project.model.ResponseModel;
import br.com.api.roleplay_project.repository.ProfileRepository;

@Service
public class ProfileServices {
    @Autowired 
    private ProfileRepository pr;

    @Autowired
    private ResponseModel rm;

    public Optional<ProfileModel> showProfile(long id){
        return pr.findById(id);
    }

    public Iterable<ProfileModel> showAllProfiles(){
        return pr.findAll();
    }

    public ResponseEntity<?> profUpdtCrt(ProfileModel pm, String action) {

        if(pm.getName().equals("")) {
            rm.setMessage("Nome obrigatório!");
            return new ResponseEntity<ProfileModel>(pm, HttpStatus.BAD_REQUEST);
        } else if(pm.getPassword().equals("")) {
            rm.setMessage("Senha obrigatória!");
            return new ResponseEntity<ProfileModel>(pm, HttpStatus.BAD_REQUEST);
        } else {
            if(action.equals("create")) {
                return new ResponseEntity<ProfileModel>(pr.save(pm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProfileModel>(pr.save(pm), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<ResponseModel> profRmv(long id){
        pr.deleteById(id);

        rm.setMessage("Perfil removido com sucesso!");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
