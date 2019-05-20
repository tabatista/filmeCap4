package com.igti.filme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//representa uma API essa anotacao
@RestController
//toda requisicao que tiver / vai cair nessa classe
@RequestMapping("/")
public class Principal {
	
	//define metodo get
	@RequestMapping(method= RequestMethod.GET)
	public String saudacao() {
		return "Hello World";
	};

}
