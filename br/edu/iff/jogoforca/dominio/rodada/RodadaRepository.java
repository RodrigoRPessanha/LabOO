package br.edu.iff.jogoforca.dominio.rodada;

import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;

import br.edu.iff.repository.RepositoryException;

public interface RodadaRepository extends br.edu.iff.repository.Repository {
    public Rodada getPorId(long id);

    public List<Rodada> getPorJogador(Jogador jogador);

    public void inserir(Rodada rodada) throws RepositoryException;

    public void atualizar(Rodada rodada) throws RepositoryException;

    public void remover(Rodada rodada) throws RepositoryException;

    @Override
    public long getProximoId();
}
