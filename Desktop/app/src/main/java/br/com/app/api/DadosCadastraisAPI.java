package br.com.app.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.controllers.DadosCadastraisController;
import br.com.app.models.DadosCadastrais;


@RestController
@Transactional
public class DadosCadastraisAPI {
	
	@Autowired
	private DadosCadastraisController dadosCadastrais;
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/dadosCadastrais", method = RequestMethod.GET)
	public DadosCadastrais listar(HttpServletResponse response) throws IOException {
		
		return dadosCadastrais.carregarDados();
    }

}
