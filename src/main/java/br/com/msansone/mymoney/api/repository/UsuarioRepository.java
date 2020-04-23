package br.com.msansone.mymoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.mymoney.api.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	Usuario findByEmailAndSenha(String email, String senha);

	Usuario findByEmail(String email);

}
