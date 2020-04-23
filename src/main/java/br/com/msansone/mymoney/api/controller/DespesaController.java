package br.com.msansone.mymoney.api.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.mymoney.api.model.Despesa;
import br.com.msansone.mymoney.api.service.DespesaService;

@Transactional(value = TxType.REQUIRED)
@RestController
@RequestMapping("/despesa")
@CrossOrigin(origins = "http://localhost:3000")
public class DespesaController {
	
	private static Logger LOG = Logger.getLogger("DespesaController");

	@Autowired
	DespesaService despesaService;

	@GetMapping("/usuario/{idUsuario}")
	public List<Despesa> getDespesaByUsuarioId(@PathVariable Long idUsuario){
		LOG.info(".../despesa/usuario/"+idUsuario);
		List<Despesa> lista = despesaService.getAllByIdusuario(idUsuario);
		return lista;
	}
	
	@PostMapping("/usuario")
	public Despesa addDespesa(@RequestBody Despesa despesa) {
		LOG.info("POST - .../despesa/usuario");
		return despesaService.addDespesa(despesa);
	}
	
	@DeleteMapping("/usuario/{idUsuario}")
	public void deleteDespesa(@PathVariable Long idUsuario){
		LOG.info("DELETE - .../despesa/usuario"+idUsuario);
		despesaService.deleteDespesa(idUsuario);
	}
	
}

;
