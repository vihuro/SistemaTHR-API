package SistemaTHRAPI.Sistema.THR.Manutencao.Service;

import org.springframework.stereotype.Service;

import SistemaTHRAPI.Sistema.THR.Manutencao.Dto.osThrDto;
import SistemaTHRAPI.Sistema.THR.Manutencao.Model.osThrModel;
import SistemaTHRAPI.Sistema.THR.Manutencao.Repository.IOsThrRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class osThrService {
	

	@Autowired
	private IOsThrRepository repository;


	public void  save(osThrDto dto) {
		osThrModel model = new osThrModel();
		model.setDescricaoServico(dto.getDescricaoServico());
		model.setTipoServico(dto.getTipoServico());
		model.setDataHoraGeracao(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
		model.setUsuarioGeracao("Vitor");
		model.setDataIdeal("Amanhã");
		model.setStatusOS("ABERTO");
		repository.save(model);
			
	}


	public void delete(osThrDto dto) {
		osThrModel model = new osThrModel();
		model.setNumeroOS(dto.getNumeroOS());
		repository.delete(model);
	}


	public void deleteAll() {
		repository.deleteAll();
		
	}


	public void savePrioridade(Integer numeroOs,osThrDto dto ) {
			
			Optional<osThrModel> os = repository.findById(numeroOs);
			osThrModel model =  os.get();
			model.setNumeroOS(numeroOs);
			model.setDataHoraPrioridade(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
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
