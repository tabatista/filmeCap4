package com.igti.filme.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igti.filme.entity.Filme;
import com.igti.filme.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	//injeta o repositorio de filmes do Mongo
	@Autowired
	private FilmeRepository filmeRepository;

	//o ResponseEntity encapsula um response que eh apresentado como json
	//eh possivel  passar no response o status da resposta
	//alem das informacoes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Filme>> listar(){
		
		List<Filme> filmes = filmeRepository.findAll();		
		
		//acessa pela URL http://localhost:8080/filmes
		return new ResponseEntity<>(filmes, HttpStatus.OK); //OK corresponde ao status 200
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Filme> obterById(@PathVariable String id){
		
		Optional<Filme> filmeOptional = filmeRepository.findById(id);
		
		//verifica se o filme existe
		if(!filmeOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 		
		////acessa pela URL http://localhost:8080/filmes/id
		return new ResponseEntity<>(filmeOptional.get(), HttpStatus.OK);		
	}
}
