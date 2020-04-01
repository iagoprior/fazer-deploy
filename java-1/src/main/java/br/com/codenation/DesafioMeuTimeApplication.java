package br.com.codenation;


import java.math.BigDecimal;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.Comparator;

import java.util.List;

import java.util.stream.Collectors;


import br.com.codenation.desafio.annotation.Desafio;

import br.com.codenation.desafio.app.MeuTimeInterface;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;

import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;

import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;


public class DesafioMeuTimeApplication implements MeuTimeInterface {


	private List<Time> times = new ArrayList<>();

	private List<Jogador> jogadores = new ArrayList<>();


	@Desafio("incluirTime")

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		if (searchTime(id) != null) {
			throw new IdentificadorUtilizadoException("Esse time já existe.");
		} else {

			times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
		}

	}


	@Desafio("incluirJogador")

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		if (searchJogador(id)!=null) throw new IdentificadorUtilizadoException("Esse  jogador já existe.");

		if (searchTime(idTime)==null) throw new TimeNaoEncontradoException("Time não encontrado.");

		jogadores.add( new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario) );	}


	@Desafio("definirCapitao")

	public void definirCapitao(Long idJogador) {

		if (searchJogador(idJogador) == null) { // Verifica se o jogador  não existe na lista de jogadores

			throw new JogadorNaoEncontradoException();

		} else {

			Jogador jogador1 = searchJogador(idJogador);

			Time time1 = searchTime(jogador1.getIdTime());

			time1.setIdCapitao(idJogador);

		}

	}


	@Desafio("buscarCapitaoDoTime")

	public Long buscarCapitaoDoTime(Long idTime) {

		Time time = searchTime(idTime);

		if (time==null) throw new TimeNaoEncontradoException("Id do time não encontrado");

		if (time.getIdCapitao()==null) throw new CapitaoNaoInformadoException("Id do capitão não encontrado");

		return time.getIdCapitao();	}


	@Desafio("buscarNomeJogador")

	public String buscarNomeJogador(Long idJogador) {

		String nomeJogador = null;

		if (searchJogador(idJogador) == null) { // Verifica se o jogador  não existe na lista de jogadores

			throw new JogadorNaoEncontradoException();

		} else {

			Jogador jogador1 = searchJogador(idJogador);

			nomeJogador = jogador1.getNome();

		}

		return  nomeJogador;

	}


	@Desafio("buscarNomeTime")

	public String buscarNomeTime(Long idTime) {

		String nomeTime = null;

		if (searchTime(idTime) == null) { // Verifica se o time não está cadastrado na lista de times

			throw new TimeNaoEncontradoException();

		} else {

			Time time1 =searchTime(idTime);

			nomeTime = time1.getNome();

		}

		return nomeTime;

	}


	@Desafio("buscarJogadoresDoTime")

	public List<Long> buscarJogadoresDoTime(Long idTime) {

		List<Long> listaJogadores = null;


		if (searchTime(idTime) == null) { // Verifica se o time não está cadastrado na lista de times

			throw new TimeNaoEncontradoException();

		} else {

			listaJogadores = jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime)).map(Jogador::getId).sorted().collect(Collectors.toList());

		}


		return listaJogadores;


	}


	@Desafio("buscarMelhorJogadorDoTime")

	public Long buscarMelhorJogadorDoTime(Long idTime) {

		Long melhorJogador = null;

		if (searchTime(idTime) == null) { // Verifica se o time não está cadastrado na lista de times

			throw new TimeNaoEncontradoException();

		} else {

			melhorJogador = jogadores.stream()

					.filter(t -> t.getIdTime() == idTime)

					.max(Comparator.comparingInt(Jogador::getNivelHabilidade))

					.get()

					.getId();

		}


		return melhorJogador;

	}


	@Desafio("buscarJogadorMaisVelho")

	public Long buscarJogadorMaisVelho(Long idTime) {

		Long jogadorMaisVelho = null;

		if (searchTime(idTime) == null) { // Verifica se o time não está cadastrado na lista de times

			throw new TimeNaoEncontradoException();

		} else {

			jogadorMaisVelho = jogadores.stream()

					.filter(t -> t.getIdTime() == idTime)

					.sorted(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))

					.findFirst()

					.get()

					.getId();

		}


		return jogadorMaisVelho;


	}


	@Desafio("buscarTimes")

	public List<Long> buscarTimes() {

		return  this.times.stream().sorted((t1,t2) -> t1.getId().compareTo(t2.getId())).map(t -> t.getId()).collect(Collectors.toList());

	}


	@Desafio("buscarJogadorMaiorSalario")

	public Long buscarJogadorMaiorSalario(Long idTime) {

		Long jogadorMaiorSalario = null;

		if (searchTime(idTime) == null) { // Verifica se o time não está cadastrado na lista de times

			throw new TimeNaoEncontradoException();

		} else {

			jogadorMaiorSalario = jogadores.stream()

					.filter(t -> t.getIdTime() == idTime)

					.max((Comparator.comparing(Jogador::getSalario))

							.thenComparing(comparaIdJogador))

					.get()

					.getId();

		}


		return jogadorMaiorSalario;

	}


	@Desafio("buscarSalarioDoJogador")

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		BigDecimal salarioJogador = null;

		if (searchJogador(idJogador) == null) { // Verifica se o jogador  não existe na lista de jogadores

			throw new JogadorNaoEncontradoException();

		} else {

			Jogador jogador1 = searchJogador(idJogador);

			salarioJogador = jogador1.getSalario();

		}

		return  salarioJogador;

	}


	@Desafio("buscarTopJogadores")

	public List<Long> buscarTopJogadores(Integer top) {

		return jogadores.stream()

				.sorted(Comparator.comparing(Jogador::getNivelHabilidade)

						.thenComparing(comparaIdJogador).reversed())

				.limit(top)

				.map(l -> l.getId())

				.collect(Collectors.toList());

		//.thenComparing(Jogador::getId))
	}


	@Desafio("buscarCorCamisaTimeDeFora")

	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Time timeCasa = searchTime(timeDaCasa);

		Time timeFora = searchTime(timeDeFora);

		String corCamisaTimeFora = null;


		if (timeCasa == null || timeFora == null) {

			throw new  TimeNaoEncontradoException();

		} else {

			if (timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())) {

				corCamisaTimeFora = timeFora.getCorUniformeSecundario();

			}

			corCamisaTimeFora =  timeFora.getCorUniformePrincipal();

		}


		return corCamisaTimeFora;

	}


	private Time searchTime(Long idTime) {

		return times.stream().filter(x -> x.getId().equals(idTime)).findFirst().orElse(null);

	}


	private Jogador searchJogador(Long idJogador) {

		return jogadores.stream().filter(x -> x.getId().equals(idJogador)).findFirst().orElse(null);

	}


	private Comparator<Jogador> comparaIdJogador = new Comparator<Jogador>() {

		@Override

		public int compare(Jogador o1, Jogador o2) {

			if (o1.getId() < o2.getId()) {

				return 1;

			} else if (o1.getId() > o2.getId()){

				return -1;

			} else {

				return 0;

			}

		}

	};


}

