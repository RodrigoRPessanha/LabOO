package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.List;

public class PalavraAppService {

  private static PalavraAppService soleInstance;
  private final TemaRepository temaRepository;
  private final PalavraRepository palavraRepository;
  private final PalavraFactory palavraFactory;

  private PalavraAppService(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
    this.temaRepository = temaRepository;
    this.palavraRepository = palavraRepository;
    this.palavraFactory = palavraFactory;
  }

  public static PalavraAppService getSoleInstance() {
    if (soleInstance == null) {
      throw new IllegalStateException("PalavraAppService not initialized");
    }
    return soleInstance;
  }

  public static void createSoleInstance(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
    if (soleInstance != null) {
      throw new IllegalStateException("PalavraAppService already initialized");
    }
    soleInstance = new PalavraAppService(temaRepository, palavraRepository, palavraFactory);
  }

  public boolean novaPalavra(String palavra, long idTema) {
    Tema tema = temaRepository.getTemaById(idTema);
    if (tema == null) {
      return false;
    }
    Palavra novaPalavra = palavraFactory.criarPalavra(palavra, tema);
    palavraRepository.salvarPalavra(novaPalavra);
    return true;
  }
  
  public List<Palavra> buscarPalavrasPorTema(Tema tema) {
	  return palavraRepository.buscarPalavrasPorTema(tema);
	}

	public Palavra buscarPalavraPorId(long idPalavra) {
	  return palavraRepository.buscarPalavraPorId(idPalavra);
	}

	public boolean atualizarPalavra(long idPalavra, String novaPalavra) {
	  Palavra palavra = palavraRepository.buscarPalavraPorId(idPalavra);
	  if (palavra == null) {
	    return false;
	  }
	  palavra.setNome(novaPalavra);
	  palavraRepository.atualizarPalavra(palavra);
	  return true;
	}

	public boolean removerPalavra(long idPalavra) {
	  Palavra palavra = palavraRepository.buscarPalavraPorId(idPalavra);
	  if (palavra == null) {
	    return false;
	  }
	  palavraRepository.removerPalavra(palavra);
	  return true;
	}