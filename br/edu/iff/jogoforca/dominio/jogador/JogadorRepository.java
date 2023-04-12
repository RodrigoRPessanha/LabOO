package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.repository.RepositoryException;

public interface JogadorRepository {
    public Jogador getPorId(long id);

    public Jogador[] getPorJogador(String nome);

    public void inserir(Jogador jogador) throws RepositoryException;

    public void atualizar(Jogador jogador) throws RepositoryException;

    public void remover(Jogador jogador) throws RepositoryException;
}
