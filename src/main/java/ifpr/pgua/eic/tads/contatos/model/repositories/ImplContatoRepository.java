package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Contato;
import ifpr.pgua.eic.tads.contatos.model.daos.ContatoDAO;

public class ImplContatoRepository implements ContatoRepository {
    private ContatoDAO dao;
    public ImplContatoRepository(ContatoDAO dao){
        this.dao = dao;
    }

    @Override
    public Resultado<Contato> cadastrar(String nome, String email, String telefone) {
        if (nome.isBlank() || nome.isEmpty()) {
            return Resultado.erro("Nome inválido!");
        }

        if (telefone.isBlank() || telefone.isEmpty()) {
            return "Telefone inválido!";
        }

        if (email.isBlank() || email.isEmpty()) {
            return "E-mail inválido!";
        }

        if (buscar(nome) == null) {

            Contato contato = new Contato(nome, telefone, email);

            Resultado<Contato> resultado = contatoDao.criar(contato);   

            return resultado.getMsg();

        } else {
            return "Erro! Dados já cadastrados!";
        }
    }

    @Override
    public Resultado<List<Contato>> listarTodos() {
        return dao.listar(); 
    }
    
}
