package br.edu.iff.jogoforca.dominio.rodada;

import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;

import br.edu.iff.repository.RepositoryException;

public interface RodadaRepository extends br.edu.iff.repository.Repository {
    // Retorna uma rodada com o id informado
    public Rodada getPorId(long id);

    // Retorna uma lista de rodadas do jogador informado    
    public List<Rodada> getPorJogador(Jogador jogador);

    // Insere uma nova rodada no repositório
    public void inserir(Rodada rodada) throws RepositoryException;

    // Atualiza uma rodada existente no repositório
    public void atualizar(Rodada rodada) throws RepositoryException;

    // Remove uma rodada do repositório
    public void remover(Rodada rodada) throws RepositoryException;

    // Retorna o próximo id disponível para uma nova rodada
    @Override
    public long getProximoId();
}
