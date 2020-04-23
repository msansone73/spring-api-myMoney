package br.com.msansone.mymoney.api.service;

import br.com.msansone.mymoney.api.exception.DuplicateUsuarioException;
import br.com.msansone.mymoney.api.model.Usuario;

public interface UsuarioService {

	Usuario getByEmailAndSenha(String email, String senha);

	Usuario salvar(Usuario usuario) throws DuplicateUsuarioException;

}
