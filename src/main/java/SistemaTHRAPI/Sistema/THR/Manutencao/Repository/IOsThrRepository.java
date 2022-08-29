package SistemaTHRAPI.Sistema.THR.Manutencao.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SistemaTHRAPI.Sistema.THR.Manutencao.Model.osThrModel;


@Repository
public interface IOsThrRepository extends JpaRepository<osThrModel, Integer>{
	

	public List<osThrModel> findByNumeroOS(Integer numeroOS);

	public osThrModel getByNumeroOS (Integer numeroOS);
	
}
