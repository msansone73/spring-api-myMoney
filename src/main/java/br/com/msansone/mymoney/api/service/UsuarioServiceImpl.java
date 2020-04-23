package br.com.msansone.mymoney.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.mymoney.api.exception.DuplicateUsuarioException;
import br.com.msansone.mymoney.api.model.Usuario;
import br.com.msansone.mymoney.api.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario getByEmailAndSenha(String email, String senha) {
		return usuarioRepository.findByEmailAndSenha(email, senha);
	}

	@Override
	public Usuario salvar(Usuario usuario) throws DuplicateUsuarioException {
		//Verifica se já existe usuário com este email
		Usuario busuario = usuarioRepository.findByEmail(usuario.getEmail());
		if (busuario!=null) {
			throw new DuplicateUsuarioException();
		}
		return usuarioRepository.save(usuario);
	}

}
