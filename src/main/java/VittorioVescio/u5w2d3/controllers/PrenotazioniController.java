package VittorioVescio.u5w2d3.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VittorioVescio.u5w2d3.entities.Prenotazione;
import VittorioVescio.u5w2d3.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {
	@Autowired
	private PrenotazioneService prenotazioneService;

	@GetMapping("")
	public Page<Prenotazione> getPrenotazioni(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return prenotazioneService.find(page, size, sortBy);
	}

	@GetMapping("/{id}")
	public Prenotazione getById(@PathVariable UUID id) {
		return prenotazioneService.findById(id);
	}
}
