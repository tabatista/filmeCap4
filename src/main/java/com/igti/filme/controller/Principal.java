//pacote controller onde iremos concentrar todas as classes API
package com.igti.filme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//representa uma API (recebe as chamadas HTTPs)
@RestController
//toda requisicao que tiver / vai cair nessa classe (mapeia as requisições HTTPs em métodos)
@RequestMapping("/")
public class Principal {
	
	//define metodo get
	@RequestMapping(method = RequestMethod.GET)
	public String saudacao() {
		return "Hello World";
	};

}
