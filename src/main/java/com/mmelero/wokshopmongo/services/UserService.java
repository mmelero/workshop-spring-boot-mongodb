package com.mmelero.wokshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmelero.wokshopmongo.domain.User;
import com.mmelero.wokshopmongo.dto.UserDTO;
import com.mmelero.wokshopmongo.repository.UserRepository;
import com.mmelero.wokshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		if(!(findById(id)==null)) {

			repo.deleteById(id);

		}
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).get();
		  updateData(newObj, obj);

		     return repo.save(newObj);
		
	}
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
	}
	
}
