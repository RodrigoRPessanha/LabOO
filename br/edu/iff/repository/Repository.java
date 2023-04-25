package br.edu.iff.repository;

public interface Repository {
    // Este método retorna o próximo ID disponível no repositório
    public long getProximoId();
}
