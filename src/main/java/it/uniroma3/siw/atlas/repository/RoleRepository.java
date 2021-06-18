package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.model.Role;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.atlas.model.ERole;

public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByName(ERole roleCustomer);

}
