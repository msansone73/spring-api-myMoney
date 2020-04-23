package br.com.msansone.mymoney.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.mymoney.api.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

	List<Despesa> findByUsuarioId(Long usuarioId);

}
