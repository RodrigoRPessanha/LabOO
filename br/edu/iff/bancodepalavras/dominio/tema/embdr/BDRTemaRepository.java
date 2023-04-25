package br.edu.iff.bancodepalavras.dominio.tema.embdr;

import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class BDRTemaRepository implements TemaRepository {
    // Define a única instância da classe BDRTemaRepository, seguindo o padrão Singleton
    private static BDRTemaRepository soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private BDRTemaRepository() {
    }

    // Método estático que retorna a única instância da classe BDRTemaRepository, seguindo o padrão Singleton
    public static BDRTemaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRTemaRepository();
        }
        return soleInstance;
    }

    @Override
    public Tema getPorId(long id) {
        return null;
    }

    @Override
    public List<Tema> getTodos() {
        return Collections.emptyList();
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
    }

    @Override
    public List<Tema> getPorNome(String nome) {
        return Collections.emptyList();
    }

    @Override
    public long getProximoId() {
        return (Long) null;
    }
}
