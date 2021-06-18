package it.uniroma3.siw.atlas.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.atlas.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Object findByUsername(String username);

	Object findByEmail(String email);

}