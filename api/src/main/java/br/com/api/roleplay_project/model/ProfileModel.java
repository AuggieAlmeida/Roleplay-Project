package br.com.api.roleplay_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Profiles")
@Getter
@Setter
public class ProfileModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long profId;
    private String name;
    private String nickname;
    private String password;
    private String pic;
    
}
