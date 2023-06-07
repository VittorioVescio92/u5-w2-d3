package VittorioVescio.u5w2d3.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VittorioVescio.u5w2d3.entities.User;
import VittorioVescio.u5w2d3.exceptions.NotFoundException;
import VittorioVescio.u5w2d3.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository usersRepository;

	public User findById(UUID id) throws NotFoundException {
		return usersRepository.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));
	}
}
