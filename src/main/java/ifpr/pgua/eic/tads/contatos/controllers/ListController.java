package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Agenda;
import ifpr.pgua.eic.tads.contatos.model.Contato;
import ifpr.pgua.eic.tads.contatos.model.repositories.ContatoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ListController {
    
    private Agenda agenda;

    public ListController(ContatoRepository contatoRepository){
        this.agenda = contatoRepository;
    }

    public Handler get = (Context ctx)->{
        String html="<html><head><meta charset=\"UTF-8\"></head><body><h1>Lista de Contatos</h1><ul>";

        Resultado<List<Contato>> resultado = agenda.getLista();

        if(resultado.foiErro()){
            html += "<h1>"+resultado.getMsg()+"</h1>";
        }else{
            List<Contato> lista = resultado.comoSucesso().getObj();
            for(Contato c:lista){
                html+="<li>"+c.toString()+"</li>";
            }
        }

        html+="</ul><a href=\"/\">Voltar</a></body></html>";
        ctx.html(html);
    };

    };



