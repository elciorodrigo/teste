package br.com.app.controllers;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DadosBase {
	
	protected Connection.Response response;
	protected Document loginPage;
	
	public Connection.Response getResponse() {
		return response;
	}

	public void setResponse(Connection.Response response) {
		this.response = response;
	}

	public void DadosBase() throws IOException{
	
	response = Jsoup.connect("http://www.sectrainfo.com.br/web_logatti/Login.aspx")
	     .method(Connection.Method.GET)
	     .execute();
	
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
	}
}
