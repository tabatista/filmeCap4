package com.igti.filme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.igti.filme.entity.Filme;

/**
 * classe para manipular documentos do repositorio (integracao com mongodb)
 * @author tabatista
 *	utiliza os metodos de banco de dados sem precisar implementar as operacoes de crud basicas
 *	configuracao do mongo no application.properties
 */
public interface FilmeRepository extends MongoRepository<Filme, String> {

}
