package br.com.msansone.mymoney.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.mymoney.api.model.Despesa;
import br.com.msansone.mymoney.api.repository.DespesaRepository;

@Service
public class DespesaServiceImpl implements DespesaService {
	
	@Autowired
	DespesaRepository despesaRepository;

	@Override
	public Despesa addDespesa(Despesa despesa) {
		return despesaRepository.save(despesa);
	}

	@Override
	public List<Despesa> getAllByIdusuario(Long usuarioId) {
		List<Despesa> lista = despesaRepository.findByUsuarioId(usuarioId);
		return lista;
	}

	@Override
	public void deleteDespesa(Long idUsuario) {
		despesaRepository.deleteById(idUsuario);
	}
	
	
	

}

