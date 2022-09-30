package SistemaTHRAPI.Sistema.THR.Manutencao.Service;

import org.springframework.stereotype.Service;

import SistemaTHRAPI.Sistema.THR.Manutencao.Dto.osThrDto;
import SistemaTHRAPI.Sistema.THR.Manutencao.Model.osThrModel;
import SistemaTHRAPI.Sistema.THR.Manutencao.Repository.IOsThrRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class osThrService {

	private final IOsThrRepository repository;

	public osThrService(IOsThrRepository repository) {
		this.repository = repository;
	}

	public osThrDto save(osThrDto dto) {

		osThrModel model = new osThrModel();
		model.setDescricaoServico(dto.getDescricaoServico());
		model.setTipoServico(dto.getTipoServico());
		model.setDataHoraGeracao(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
		model.setUsuarioGeracao("Vitor");
		model.setDataIdeal("Amanhã");
		model.setStatusOS("ABERTO");
		model = repository.save(model);

		return new osThrDto(model);

	}

	public List<osThrDto> findAll() {

		List<osThrModel> model = repository.findAll();

		return model.stream().map(x -> new osThrDto(x)).collect(Collectors.toList());

	}

	public void delete(osThrDto dto) {
		osThrModel model = new osThrModel();
		model.setNumeroOS(dto.getNumeroOS());
		repository.delete(model);
	}

	public void deleteAll() {
		repository.deleteAll();

	}

	public void savePrioridade(Integer numeroOs, osThrDto dto) {

		Optional<osThrModel> os = repository.findById(numeroOs);
		osThrModel model = os.get();
		model.setNumeroOS(numeroOs);
		model.setDataHoraPrioridade(
				new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
		model.setUsuarioPrioridade("Vitor");
		model.setPrioridade(dto.getPrioridade());
		repository.save(model);

	}

	public void findByOS(Integer numerOS) {
		osThrModel model = new osThrModel();
		model.setNumeroOS(numerOS);

		repository.findById(model.getNumeroOS());
	}
}
