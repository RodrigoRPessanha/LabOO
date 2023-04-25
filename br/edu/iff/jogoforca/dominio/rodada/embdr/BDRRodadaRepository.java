package br.edu.iff.jogoforca.dominio.rodada.embdr;

import java.util.Collections;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRRodadaRepository implements RodadaRepository {
    // Define a única instância da classe BDRRodadaRepository, seguindo o padrão Singleton
    private static BDRRodadaRepository soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private BDRRodadaRepository() {
    }

    // Método estático que retorna a única instância da classe BDRRodadaRepository, seguindo o padrão Singleton
    public static BDRRodadaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRRodadaRepository();
        }
        return soleInstance;
    }

    @Override
    public Rodada getPorId(long id) {
        return null;}

    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        return Collections.emptyList();}

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
    }

    @Override
    public long getProximoId() {
        return (Long) null;}

}
