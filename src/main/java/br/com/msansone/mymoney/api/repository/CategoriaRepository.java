package br.com.msansone.mymoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.mymoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
