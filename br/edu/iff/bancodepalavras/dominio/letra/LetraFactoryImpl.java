package br.edu.iff.bancodepalavras.dominio.letra;

public abstract class LetraFactoryImpl implements LetraFactory {

    // Atributos da classe
    private Letra[] pool;
    private Letra encoberta;

    // Construtor da classe
    protected LetraFactoryImpl() {
        this.pool = new Letra[26];
        this.encoberta = null;
    }

    // Implementação do método getLetra da interface LetraFactory
    // Recebe o código da letra como parâmetro e retorna uma instância da classe Letra correspondente
    @Override
    public final Letra getLetra(char codigo) {
        int i = codigo - 'a';
        Letra result = this.pool[i];
        if (result == null) {
            result = this.criarLetra(codigo);
            this.pool[i] = result;
        }
        return result;
    }

    // Método abstrato que cria uma instância da classe Letra correspondente ao código da letra
    protected abstract Letra criarLetra(char codigo);

    // Implementação do método getLetraEncoberta da interface LetraFactory
    // Retorna uma instância da classe LetraEncoberta, que representa uma letra não revelada em um jogo de palavras
    @Override
    public final Letra getLetraEncoberta() {
        if (encoberta == null) {
            char codigo = '?';
            this.encoberta = criarLetra(codigo);
        }
        return this.encoberta;
    }

}
