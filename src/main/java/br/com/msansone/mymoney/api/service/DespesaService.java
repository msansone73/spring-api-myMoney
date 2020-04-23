package br.com.msansone.mymoney.api.service;

import java.util.List;

import br.com.msansone.mymoney.api.model.Despesa;

public interface DespesaService {

	Despesa addDespesa(Despesa despesa);
	
	List<Despesa> getAllByIdusuario(Long usuarioId);

	void deleteDespesa(Long idUsuario);
}
