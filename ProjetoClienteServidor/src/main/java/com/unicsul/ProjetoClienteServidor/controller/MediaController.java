package com.unicsul.ProjetoClienteServidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.DecimalFormat;

@Controller
@RequestMapping("/")
public class MediaController {

    @Autowired
    @Qualifier("chamada")
    private String chamada;

    @Autowired
    @Qualifier("appChamada")
    private String appChamada;

    @GetMapping("/")
    public String home(ModelMap model){
        model.addAttribute("appChamada", appChamada);
        return "home";
    }

    @GetMapping("/bemvindo/{nome}")
    public String bemvindo(@PathVariable String nome, ModelMap model){
        model.addAttribute("nome", nome);
        return "bemvindo";
    }

    @GetMapping("/imc/{notaA1}/{notaA2}")
    public String calcularImc(@PathVariable double notaA1, @PathVariable double notaA2, ModelMap model){
        double imcFinal = (notaA1 / (notaA2*notaA2));
        model.addAttribute("imcFinal", imcFinal);
        model.addAttribute("chamada", chamada);
        return "imc";
        /*
        acessar um localhost:8080 como /media/{nota-da-a1}/{nota-da-a2}
        */
    }

    @GetMapping("/raiz/{numero}")
    public String calcularRaiz(@PathVariable double numero, ModelMap model) {
        double raiz = Math.sqrt(numero);
        DecimalFormat df = new DecimalFormat("#.##"); // Formata para 2 casas decimais
        String raizFormatada = df.format(raiz);
        model.addAttribute("raiz", raizFormatada);
        return "raiz";
        /*
        acesse localhost:8080 como /raiz/{numero} para calcular a raiz de um
        número.
        */
    }
}