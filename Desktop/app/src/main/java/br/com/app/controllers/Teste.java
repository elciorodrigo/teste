package br.com.app.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class Teste {
	
 	@ResponseBody
 	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/teste", method = RequestMethod.GET)
    public void  listar(HttpServletResponse response) throws IOException {
 		
 			Conectar conectar = new Conectar();
	 		conectar.efetuarConexao();
	 		
	 		
	        
	    }
	
	

}
