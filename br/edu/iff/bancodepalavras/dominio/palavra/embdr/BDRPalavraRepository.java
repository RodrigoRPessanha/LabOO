package br.edu.iff.bancodepalavras.dominio.palavra.embdr;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class BDRPalavraRepository implements PalavraRepository {

    private static BDRPalavraRepository soleInstance = null;
    private List<Palavra> pool;

    private BDRPalavraRepository() {
        this.pool = new ArrayList<Palavra>();
    }

    public BDRPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
            this.soleInstance = soleInstance;
        }
        return this.soleInstance;
    }

    @Override
    public Palavra getPorId(long id) {
        return null;
    }

    @Override
    public Palavra[] getPorTema(Tema tema) {
        return null;
    }

    @Override
    public Palavra[] getTodas() {
        return null;
    }

    @Override
    public Palavra getPalavra(String palavra) {
        return null;
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException {
    }

    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {
    }

    @Override
    public void remover(Palavra palavra) throws RepositoryException {
    }

}
