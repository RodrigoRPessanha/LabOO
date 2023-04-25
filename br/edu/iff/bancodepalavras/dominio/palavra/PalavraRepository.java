package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface PalavraRepository extends Repository {

    // Retorna a Palavra com o ID especificado
    public Palavra getPorId(long id);

    // Retorna uma lista de Palavras associadas a um determinado Tema
    public List<Palavra> getPorTema(Tema tema);

    // Retorna todas as Palavras armazenadas no repositório
    public List<Palavra> getTodas();

    // Retorna a Palavra com a palavra especificada
    public Palavra getPalavra(String palavra);

    // Insere uma nova Palavra no repositório
    public void inserir(Palavra palavra) throws RepositoryException;

    // Atualiza uma Palavra existente no repositório
    public void atualizar(Palavra palavra) throws RepositoryException;

    // Remove uma Palavra do repositório
    public void remover(Palavra palavra) throws RepositoryException;

    // Retorna o próximo ID disponível para uma nova Palavra
    @Override
    public long getProximoId();
}
