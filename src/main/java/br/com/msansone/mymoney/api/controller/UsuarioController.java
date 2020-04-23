package br.com.msansone.mymoney.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.mymoney.api.exception.DuplicateUsuarioException;
import br.com.msansone.mymoney.api.model.Usuario;
import br.com.msansone.mymoney.api.service.UsuarioService;

@Transactional(value = TxType.REQUIRED)
@RestController
@RequestMapping("/seguranca")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {
	
	private static Logger LOG = Logger.getLogger("DespesaController");
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/login")
	public List<Usuario>  Login(@RequestBody Usuario usuario   ) {
		LOG.info("POST - .../seguranca/login/");
		Usuario response = usuarioService.getByEmailAndSenha(usuario.getEmail(), usuario.getSenha() );
		return formatResponse(response);
	}
	
	@PostMapping("/usuario")
	public List<Usuario>   Salvar(@RequestBody Usuario usuario ) {
		LOG.info("POST - .../seguranca/usuario/");
		Usuario response=null;
		try {
			response = usuarioService.salvar(usuario);
		} catch (DuplicateUsuarioException e) {
			e.printStackTrace();
		}
		return formatResponse(response);
	}
	
	private List<Usuario> formatResponse(Usuario response){		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if (response!=null) {usuarios.add(response);}
		return usuarios;
	}
	
}

