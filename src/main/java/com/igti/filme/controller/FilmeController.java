package com.igti.filme.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igti.filme.entity.Filme;
import com.igti.filme.repository.FilmeRepository;
import com.igti.filme.vo.FilmeRequest;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	// injeta o repositorio de filmes do Mongo
	@Autowired
	private FilmeRepository filmeRepository;

	// o ResponseEntity encapsula um response que eh apresentado como json
	// eh possivel passar no response o status da resposta
	// alem das informacoes
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Filme>> listar() {

		List<Filme> filmes = filmeRepository.findAll();

		// acessa pela URL http://localhost:8080/filmes
		return new ResponseEntity<>(filmes, HttpStatus.OK); // OK corresponde ao status 200
	}

	// path = parametro que vira da url e sera mapeado no parâmetro id do método
	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Filme> obterById(@PathVariable String id) {

		Optional<Filme> filmeOptional = filmeRepository.findById(id);

		// verifica se o filme existe
		if (!filmeOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// acessa pela URL http://localhost:8080/filmes/id
		return new ResponseEntity<>(filmeOptional.get(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	// pega as informacoes do corpo da requisicao com o @RequestBody - o corpo do
	// request sera mapeado no parametro
	// com o @Valid os dados do request serão validados.
	public ResponseEntity<Void> criar(@RequestBody @Valid FilmeRequest request) {
		Filme filme = new Filme();
		filme.setTitulo(request.getTitulo());
		filme.setDiretor(request.getDiretor());
		filme.setGenero(request.getGenero());
		filme.setAno(request.getAno());

		filmeRepository.save(filme);

		// acessa pela URL http://localhost:8080/filmes/ (COM O BODY PREENCHIDO -
		// POSTMAN)
		// status 201
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@PathVariable String id, @RequestBody @Valid FilmeRequest request) {

		Optional<Filme> filmeOptional = filmeRepository.findById(id);

		// verifica se o filme NAO existe
		if (!filmeOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		filmeOptional.get().setTitulo(request.getTitulo());
		filmeOptional.get().setDiretor(request.getDiretor());
		filmeOptional.get().setGenero(request.getGenero());
		filmeOptional.get().setAno(request.getAno());

		filmeRepository.save(filmeOptional.get());

		// acessa pela URL http://localhost:8080/filmes/id (COM O BODY PREENCHIDO -
		// POSTMAN)
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Void> alterarCampo(@PathVariable String id, @RequestBody @Valid FilmeRequest request) {

		Optional<Filme> filmeOptional = filmeRepository.findById(id);

		// verifica se o filme NAO existe
		if (!filmeOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		//verificaremos se os dados dos request existem
		if (request.getTitulo() != null) {
			filmeOptional.get().setTitulo(request.getTitulo());
		}

		if (request.getDiretor() != null) {
			filmeOptional.get().setDiretor(request.getDiretor());
		}

		if (request.getGenero() != null) {
			filmeOptional.get().setGenero(request.getGenero());
		}

		if (request.getAno() > 0) {
			filmeOptional.get().setAno(request.getAno());
		}

		filmeRepository.save(filmeOptional.get());

		// acessa pela URL http://localhost:8080/filmes/id (COM O BODY PREENCHIDO PARCIALMENTE -
		// POSTMAN)
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable String id) {

		Optional<Filme> filmeOptional = filmeRepository.findById(id);

		// verifica se o filme NAO existe
		if (!filmeOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		filmeRepository.delete((filmeOptional.get()));

		// acessa pela URL http://localhost:8080/filmes/id
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
