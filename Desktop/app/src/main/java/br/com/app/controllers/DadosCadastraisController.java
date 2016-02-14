package br.com.app.controllers;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;

import br.com.app.models.DadosCadastrais;

@Controller
public class DadosCadastraisController extends DadosBase {
	
	private final String LINKPRINCIPAL = "http://www.sectrainfo.com.br/web_logatti/Login.aspx";
	private final String LINK = "http://www.sectrainfo.com.br/web_logatti/DadosCadastrais.aspx"; 
	private Connection.Response response;
	private Document loginPage;		
	private Document homePage;
	private DadosCadastrais dadosCadastrais;
	
	public DadosCadastrais carregarDados() throws IOException{

	response = Jsoup.connect(LINKPRINCIPAL).method(Connection.Method.GET).execute();
			
	loginPage = response.parse();

	response = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Login.aspx")
	 		.data("ctl00$MainContent$txtAluno","3313-381")
			.data("ctl00$MainContent$txtSenha","418088")
	        .data("ctl00$MainContent$btnLogar","Entrar")
	        .data("__VIEWSTATE", loginPage.getElementById("__VIEWSTATE").val())
	        .data("__EVENTVALIDATION", loginPage.getElementById("__EVENTVALIDATION").val())
	        .cookies(response.cookies())
	        .method(Connection.Method.POST)
	        .execute();
	
	
	homePage = Jsoup.connect(LINK).cookies(response.cookies()).get();
	
	dadosCadastrais = new DadosCadastrais();
	dadosCadastrais.setNome(homePage.getElementById("MainContent_lblNome").text());
	dadosCadastrais.setrA(homePage.getElementById("MainContent_lblCodigo").text());
	dadosCadastrais.setTurma(homePage.getElementById("MainContent_lblTermo").text());
	dadosCadastrais.setSituacao(homePage.getElementById("MainContent_lblStatus").text());
	
	return dadosCadastrais;
	
			
	}
	
	

}
