package br.com.codenation;


//import br.com.codenation.desafio.classes.Jogador;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;


public class Time {


    private Long id;                       //* Identificador do time

    private String nome;                   //* Nome do Time

    private LocalDate dataCriacao;         //* Data de criação do time

    private String corUniformePrincipal;   //* Cor do uniforme principal do time

    private String corUniformeSecundario;  //* Cor do uniforme secundário do time

    private Long idCapitao;

    private List<Jogador> jogadores = new ArrayList<>();


    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws IdentificadorUtilizadoException {

        this.setId(id);

        this.setNome(nome);

        this.setDataCriacao(dataCriacao);

        this.setCorUniformePrincipal(corUniformePrincipal);

        this.setCorUniformeSecundario(corUniformeSecundario);

    }


    public Long getId() {

        return id;

    }


    public void setId(Long id) {

        this.id = id;

    }


    public void mostrarJogadores(){

        this.jogadores.stream().forEach(jogador -> System.out.println(jogador.getNome()));

    }


    public String getNome() {

        return nome;

    }


    public void setNome(String nome) {

        if (nome == null || nome.equals("")) throw new IllegalArgumentException();

        this.nome = nome;

    }


    public LocalDate getDataCriacao() {

        return dataCriacao;

    }


    public void setDataCriacao(LocalDate dataCriacao) {

        if (dataCriacao == null) throw new NullPointerException("A data de criação não pode ser nula");

        this.dataCriacao = dataCriacao;

    }


    public String getCorUniformePrincipal() {

        return corUniformePrincipal;

    }


    public void setCorUniformePrincipal(String corUniformePrincipal) {

        if (corUniformePrincipal == null || corUniformePrincipal.equals("")) throw new IllegalArgumentException("Cor uniforme principal não pode ser nula");

        this.corUniformePrincipal = corUniformePrincipal;

    }


    public String getCorUniformeSecundario() {

        return corUniformeSecundario;

    }


    public void setCorUniformeSecundario(String corUniformeSecundario) {

        if (corUniformeSecundario == null || corUniformeSecundario.equals("")) throw new IllegalArgumentException("Cor do uniforme secundário não pode ser nula");

        this.corUniformeSecundario = corUniformeSecundario;

    }


    public Long getIdCapitao() {

        return idCapitao;

    }


    public void setIdCapitao(Long idCapitao) {

        if (idCapitao < 1) throw new IllegalArgumentException("O id do capitão tem que ser válido");

        this.idCapitao = idCapitao;

    }

}

