package br.com.api.roleplay_project.controller;

import java.util.Optional;

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

import br.com.api.roleplay_project.model.ProfileModel;
import br.com.api.roleplay_project.model.ResponseModel;
import br.com.api.roleplay_project.services.ProfileServices;

@RestController
@CrossOrigin(origins = "*")
public class ProfileController {
    
    @Autowired
    private ProfileServices ps;

    @DeleteMapping("/deleteProfile/{id}")
    public ResponseEntity<ResponseModel> deleteProfile(@PathVariable long id){
        return ps.profRmv(id);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody ProfileModel pm){
        return ps.profUpdtCrt(pm, "update");
    }

    @PostMapping("/createProfile")
    public ResponseEntity<?> createProfile(@RequestBody ProfileModel pm){
        return ps.profUpdtCrt(pm, "create");
    }

    @GetMapping("/listProfile/{id}")
    public Optional<ProfileModel> listProfile(@PathVariable long id){
        return ps.showProfile(id);
    }
    
    @GetMapping("/listProfile")
    public Iterable<ProfileModel> listAllProfile(){
        return ps.showAllProfiles();
    }
}