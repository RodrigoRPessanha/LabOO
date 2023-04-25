package br.edu.iff.bancodepalavras.dominio.tema;

import java.util.List;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface TemaRepository extends Repository {

    // Método para obter um tema a partir do seu id
    public Tema getPorId(long id);

    // Método para obter uma lista de temas a partir do seu nome
    public List<Tema> getPorNome(String nome);

    // Método para obter todos os temas
    public List<Tema> getTodos();

    // Método para inserir um novo tema no repositório
    public void inserir(Tema tema) throws RepositoryException;

    // Método para atualizar um tema existente no repositório
    public void atualizar(Tema tema) throws RepositoryException;

    // Método para remover um tema do repositório
    public void remover(Tema tema) throws RepositoryException;

    // Método para obter o próximo id disponível para um novo tema
    @Override
    public long getProximoId();
}
