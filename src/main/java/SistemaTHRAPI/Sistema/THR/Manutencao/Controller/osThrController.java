package SistemaTHRAPI.Sistema.THR.Manutencao.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SistemaTHRAPI.Sistema.THR.Manutencao.Dto.osThrDto;
import SistemaTHRAPI.Sistema.THR.Manutencao.Model.osThrModel;
import SistemaTHRAPI.Sistema.THR.Manutencao.Repository.IOsThrRepository;
import SistemaTHRAPI.Sistema.THR.Manutencao.Service.osThrService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/Ordem-Servico")

public class osThrController {

	public IOsThrRepository repository;

	@Autowired
	public osThrService service;

	@GetMapping
	private List<osThrDto> findAll() {
		return service.findAll();
	}

	@GetMapping("/{numeroOS}")
	private List<osThrModel> findByNumeroOS(@PathVariable("numeroOS") Integer numero) {

		return repository.findByNumeroOS(numero);
	}

	@PostMapping
	private osThrDto save(@RequestBody osThrDto dto) {

		return service.save(dto);

	}

	@PutMapping("/{numeroOS}")
	private ResponseEntity<String> updateOS(@PathVariable(value = "numeroOS") Integer numeroOs,
			@RequestBody osThrDto dto) {

		Optional<osThrModel> option = repository.findById(numeroOs);
		if (!option.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ordem de serviço não encontrada");
		}

		service.savePrioridade(numeroOs, dto);
		int a = 30;
		return ResponseEntity.status(HttpStatus.OK).body("Prioridade lançada com sucesso!");
	}

	@DeleteMapping("/{numeroOs}")
	private void deleteOS(@PathVariable("numeroOs") osThrDto dto) {
		service.delete(dto);
	}

	@DeleteMapping
	private void deleteAll() {
		service.deleteAll();
	}

}
