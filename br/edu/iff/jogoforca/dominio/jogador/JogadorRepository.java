package br.edu.iff.jogoforca.dominio.jogador;

import java.util.List;

import br.edu.iff.repository.RepositoryException;

public interface JogadorRepository extends br.edu.iff.repository.Repository {
    public Jogador getPorId(long id);

    public List<Jogador> getPorNome(String nome);

    public void inserir(Jogador jogador) throws RepositoryException;

    public void atualizar(Jogador jogador) throws RepositoryException;

    public void remover(Jogador jogador) throws RepositoryException;

    @Override
    public long getProximoId();
}
