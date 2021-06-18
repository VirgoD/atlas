package it.uniroma3.siw.atlas.controller;

import javax.transaction.Transactional;

import it.uniroma3.siw.atlas.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.atlas.model.ERole;
import it.uniroma3.siw.atlas.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public Role findByName(ERole roleCustomer) {
		
		return this.roleRepository.findByName(roleCustomer);
	}

}
