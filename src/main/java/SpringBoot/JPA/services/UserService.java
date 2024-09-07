package SpringBoot.JPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import SpringBoot.JPA.entities.User;
import SpringBoot.JPA.repositories.UserRepository;
import SpringBoot.JPA.services.exceptions.DatabaseException;
import SpringBoot.JPA.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;

//Regista a classe como Service para poder ser injetado com a anotação autowired
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 * Operação na camada de serviço que passa a chamada para o repository.findAll()
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return repository.findAll();
	}

	/**
	 * Método para procurar um user pelo Id, camada de serviço aplica as regras de
	 * negócio e chama o método findById() do repositório, que vai buscar à base de
	 * dados
	 * 
	 * @param id Identificador único do user
	 * @return user
	 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()->new ResourceNotFoundException(id));
	}

	/**
	 * Método para inserir na base de dados um novo obejeto do tipo User
	 * @param obj User a ser inserido
	 * @return User que foi inserido
	 */
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			} catch(EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);
			} catch(DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
	}
	
	@Transactional
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); //Prepara o objeto para trabalharmos e só depois mexe com a base de dados 
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
