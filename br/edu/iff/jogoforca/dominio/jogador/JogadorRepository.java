package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface JogadorRepository extends Repository {
    // Define o método para obter um jogador pelo ID
    public Jogador getPorId(long id);

    // Define o método para obter uma lista de jogadores pelo nome
    public Jogador getPorNome(String nome);

    // Define o método para inserir um jogador no repositório
    public void inserir(Jogador jogador) throws RepositoryException;

    // Define o método para atualizar um jogador no repositório
    public void atualizar(Jogador jogador) throws RepositoryException;

    // Define o método para remover um jogador do repositório
    public void remover(Jogador jogador) throws RepositoryException;

    // Implementação do método getProximoId da interface Repository
    @Override
    public long getProximoId();
}
