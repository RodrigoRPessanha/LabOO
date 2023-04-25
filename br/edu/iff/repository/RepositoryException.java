package br.edu.iff.repository;

public class RepositoryException extends Exception {
    private static final long serialVersionUID = 1L;

    // Construtor da exceção, que recebe uma mensagem de erro e a repassa para a superclasse Exception
    public RepositoryException(String mensagem) {
        super(mensagem);
    }
}
