package br.edu.iff.bancodepalavras.dominio.palavra.embdr;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;
import java.util.Collections;

public class BDRPalavraRepository implements PalavraRepository {

    // Define a única instância da classe BDRPalavraRepository, seguindo o padrão Singleton
    private static BDRPalavraRepository soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private BDRPalavraRepository() {
    }

    // Método estático que retorna a única instância da classe BDRPalavraRepository, seguindo o padrão Singleton
    public static BDRPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRPalavraRepository();
        }
        return soleInstance;
    }

    @Override
    public Palavra getPorId(long id) {
        return null;
    }

    @Override
    public List<Palavra> getPorTema(Tema tema) {
        return Collections.emptyList();
    }

    @Override
    public List<Palavra> getTodas() {
        return Collections.emptyList();
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

    @Override
    public long getProximoId() {
        return (Long) null;
    }

}
