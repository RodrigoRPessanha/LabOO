package br.edu.iff.factory;

import br.edu.iff.repository.Repository;

public abstract class EntityFactory {

    // Declarando o atributo privado repository como Repository
    private Repository repository;

    // Definindo o construtor da classe EntityFactory
    public EntityFactory(Repository repository) {
        this.repository = repository;
    }
    // Definindo o método getRepository() que retorna o atributo repository
    protected Repository getRepository() {
        return repository;
    }

    // Definindo o método getProximoId() que chama o método getProximoId() do repositório
    protected long getProximoId() {
        return repository.getProximoId();
    }
}
