package com.lucascost.meuscontatos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SourceType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
@Entity
@Table
public class Contato implements Serializable {
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    private String nome;
    private String email;
    private String telefone;
    private String local;
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getChar(){
        return this.nome.substring(0,1);
    }

    public String getColor(){
        String[] cores = {"#557bf2","#f85353","#5bcc57","#eb8424","#db3490","#77481c"};
        int index = new Random().nextInt(cores.length);
        return cores[index];
    }
}
