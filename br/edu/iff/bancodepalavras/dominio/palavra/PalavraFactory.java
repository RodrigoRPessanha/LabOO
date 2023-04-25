package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;

public interface PalavraFactory {
    
    // Método que recebe uma string e um objeto Tema e retorna um objeto Palavra correspondente
    public Palavra getPalavra(String palavra, Tema tema);
}
