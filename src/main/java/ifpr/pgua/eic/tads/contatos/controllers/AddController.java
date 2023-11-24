package ifpr.pgua.eic.tads.contatos.controllers;

import ifpr.pgua.eic.tads.contatos.model.Agenda;
import ifpr.pgua.eic.tads.contatos.model.repositories.ContatoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddController {
    
    private ContatoRepository repositorio;

    public AddController(ContatoRepository repositorio){
        this.repositorio= repositorio;
    }

    public Handler get = (Context ctx)->{
        ctx.render("templates/add.html");
    };

    public Handler post = (Context ctx)->{
        String nome = ctx.formParam("nome");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");

        String resultado = repositorio.cadastrar(nome, email, telefone);
        System.out.println(repositorio.listar());
        ctx.html(resultado+"<br/><a href=\"/\">Voltar</a>");
    };
}
