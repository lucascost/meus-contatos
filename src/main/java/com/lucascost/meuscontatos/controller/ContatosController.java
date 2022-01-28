package com.lucascost.meuscontatos.controller;

import java.util.ArrayList;
import java.util.List;

import com.lucascost.meuscontatos.model.Contato;
import com.lucascost.meuscontatos.repository.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ContatosController {
    
    @Autowired
    private ContatoRepository repository;

    @PostMapping("/")
    public String form(Contato contato){
        repository.save(contato);
        return "redirect:/";
    }

    @RequestMapping
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Contato> contatos = repository.findAll();
        mv.addObject("contatos", contatos);
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView detalhes(@PathVariable() long id ){
        ModelAndView mv = new ModelAndView("detalheContato");
        Contato contato = repository.findById(id);
        mv.addObject("contato", contato);
        return mv;
    }

    @RequestMapping("/deletar")
    public String delete(long id){
        Contato contato = repository.findById(id);
        repository.delete(contato);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable long id, Contato dados){
        dados.setId(id);
        repository.save(dados);
        return "redirect:/";
    }

    

}
