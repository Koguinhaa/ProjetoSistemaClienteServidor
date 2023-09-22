package com.unicsul.ProjetoClienteServidor.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean (name = "chamada")
    public String chamada(){
        String chamada = "O IMC é 20.5";
        return "Esse é o seu IMC";
    }

    @Bean (name = "appChamada")
    public String appChamada(){
        String app = "Seja bem vindo";
        return "Seja muito bem-vindo";
    }

}
