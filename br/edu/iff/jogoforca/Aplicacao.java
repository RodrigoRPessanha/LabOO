package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraAppService;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactoryImpl;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.dominio.rodada.sorteio.RodadaSorteioFactory;
import br.edu.iff.jogoforca.embdr.BDRRepositoryFactory;
import br.edu.iff.jogoforca.emmemoria.MemoriaRepositoryFactory;
import br.edu.iff.jogoforca.imagem.ElementoGraficoImagemFactory;
import br.edu.iff.jogoforca.texto.ElementoGraficoTextoFactory;

public class Aplicacao {
    
    private static Aplicacao soleInstance = new Aplicacao();
    
    private static final String[] TIPOS_REPOSITORY_FACTORY = {"memoria", "relacional"};
    private static final String[] TIPOS_ELEMENTO_GRAFICO_FACTORY = {"texto", "imagem"};
    private static final String[] TIPOS_RODADA_FACTORY = {"sorteio"};
    
	private String tipoRodadaFactory = TIPOS_RODADA_FACTORY[0];
    private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO_FACTORY[0];
    private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[0];
    
    private Aplicacao() {}
    
    public static Aplicacao getSoleInstance() {
        return soleInstance;
    }
    
    public JogadorFactory getJogadorFactory() {
        return JogadorFactoryImpl.getSoleInstance();
    }
    
    public PalavraFactory getPalavraFactory() {
        return PalavraFactoryImpl.getSoleInstance();
    }
    
    public TemaFactory getTemaFactory() {
        return TemaFactoryImpl.getSoleInstance();
    }
    
    public RodadaFactory getRodadaFactory() {
        if (tipoRodadaFactory.equals("sorteio")) {
            return RodadaSorteioFactory.getSoleInstance();
        }
        return null;
    }
    
    public void setTipoRodadaFactory(String tipo) {
        this.tipoRodadaFactory = tipo;
    }
    
    public String[] getTiposRodadaFactory() {
        return TIPOS_RODADA_FACTORY;
    }
    
    public LetraFactory getLetraFactory() {
        return this.getElementoGraficoFactory();
    }
    
    public BonecoFactory getBonecoFactory() {
        return this.getElementoGraficoFactory();
    }
    
    private ElementoGraficoFactory getElementoGraficoFactory() {
        if (tipoElementoGraficoFactory.equals("texto")) {
            return ElementoGraficoTextoFactory.getSoleInstance();
        } else if (tipoElementoGraficoFactory.equals("imagem")) {
            return ElementoGraficoImagemFactory.getSoleInstance();
        }
        return null;
    }
    
    public void setTipoElementoGraficoFactory(String tipo) {
        this.tipoElementoGraficoFactory = tipo;
    }
    
    public String[] getTiposElementoGraficoFactory() {
        return TIPOS_ELEMENTO_GRAFICO_FACTORY;
    }
    
    public RepositoryFactory getRepositoryFactory() {
        if (tipoRepositoryFactory.equals("memoria")) {
            return MemoriaRepositoryFactory.getSoleInstance();
        } else if (tipoRepositoryFactory.equals("relacional")) {
            return BDRRepositoryFactory.getSoleInstance();
        }
        return null;
    }
    
    public void setTipoRepositoryFactory(String tipo) {
        this.tipoRepositoryFactory = tipo;
    }
    
    public String[] getTiposRepositoryFactory() {
        return TIPOS_REPOSITORY_FACTORY;
    }
    
    public void configurar() {
		RepositoryFactory repositoryFactory = getRepositoryFactory();

        TemaRepository temaRepository = repositoryFactory.getTemaRepository();
        RodadaRepository rodadaRepository = repositoryFactory.getRodadaRepository();
        PalavraRepository palavraRepository = repositoryFactory.getPalavraRepository();
        JogadorRepository jogadorRepository = repositoryFactory.getJogadorRepository();

        TemaFactoryImpl.createSoleInstance(temaRepository);
        PalavraFactoryImpl.createSoleInstance(palavraRepository);
        JogadorFactoryImpl.createSoleInstance(jogadorRepository);
        RodadaSorteioFactory.createSoleInstance(rodadaRepository, temaRepository, palavraRepository);

        RodadaFactory rodadaFactory = getRodadaFactory();
        PalavraAppService.createSoleInstance(temaRepository, palavraRepository, getPalavraFactory());
        RodadaAppService.createSoleInstance(rodadaFactory, rodadaRepository, jogadorRepository);

        Palavra.setLetraFactory(getLetraFactory());
        Rodada.setBonecoFactory(getBonecoFactory());
	}
}
