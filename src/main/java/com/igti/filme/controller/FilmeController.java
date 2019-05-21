package com.igti.filme.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igti.filme.entity.Filme;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	//o ResponseEntity encapsula um response que eh apresentado como json
	//eh possivel  passar no response o status da resposta
	//alem das informacoes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Filme>> listar(){
		Filme filme = new Filme();
		filme.setGenero("oi");
		
		//acessa pela URL http://localhost:8080/filmes
		return new ResponseEntity<>(Arrays.asList(filme), HttpStatus.OK);
	}
	
}
