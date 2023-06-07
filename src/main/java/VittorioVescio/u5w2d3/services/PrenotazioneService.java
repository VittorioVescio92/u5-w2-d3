package VittorioVescio.u5w2d3.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import VittorioVescio.u5w2d3.entities.Prenotazione;
import VittorioVescio.u5w2d3.exceptions.NotFoundException;
import VittorioVescio.u5w2d3.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public Page<Prenotazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return prenotazioneRepository.findAll(pageable);
	}

	public Prenotazione findById(UUID id) throws NotFoundException {
		return prenotazioneRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nessun risultato con questo id"));
	}

}
