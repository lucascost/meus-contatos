package com.lucascost.meuscontatos.repository;

import com.lucascost.meuscontatos.model.Contato;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, String> {
    public Contato findById(long id);
}