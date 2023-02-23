package br.com.api.roleplay_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.api.roleplay_project.model.CharacterModel;;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel, Long>{
    
}
