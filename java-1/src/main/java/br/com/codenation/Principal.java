package br.com.codenation;


import br.com.codenation.DesafioMeuTimeApplication;

import java.math.BigDecimal;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;



public class Principal {

    public static void main(String[] args) {

        String dataFormatada = "20/01/1998 00:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate formatDate= LocalDate.parse(dataFormatada, formatter);


        DesafioMeuTimeApplication app = new DesafioMeuTimeApplication();


        app.incluirTime(1L, "Internacional", LocalDate.now(), "vermelho", "branco");

        app.incluirJogador(3L, 1L, "Dalessandro", formatDate, 99, new BigDecimal(150000));

        app.incluirJogador(2L, 1L, "Guerreiro", LocalDate.parse("25/05/1996 00:00", formatter), 89, new BigDecimal(200000));

        app.incluirJogador(4L, 1L, "Marcelo Lomba", LocalDate.parse("15/10/1999 00:00", formatter), 67, new BigDecimal(200000));

        app.incluirJogador(5L, 1L, "Edenilson", LocalDate.parse("25/05/1996 00:00", formatter), 67, new BigDecimal(200000));


        app.incluirTime(2L, "Gremio", LocalDate.now(), "azul", "preto");

        app.incluirJogador(1L, 2L, "Cebolinha", formatDate= LocalDate.parse("08/12/2000 00:00", formatter), 75, new BigDecimal(500000));

        app.incluirJogador(6L, 2L, "Vitor", formatDate= LocalDate.parse("29/10/1999 00:00", formatter), 77, new BigDecimal(800000));

        app.incluirJogador(7L, 2L, "Geromel", formatDate= LocalDate.parse("11/08/1999 00:00", formatter), 75, new BigDecimal(800000));


        app.definirCapitao(3L);

        app.definirCapitao(7L);


        //System.out.println("Capitão do " + app.buscarNomeTime(1L) + " = " + app.buscarCapitaoDoTime(1L));

        //System.out.println("Jogadores do " + app.buscarNomeTime(1L) + " = " + app.buscarJogadoresDoTime(1L));

        //System.out.println("Melhor jogador do " + app.buscarNomeTime(1L) + " = " + app.buscarMelhorJogadorDoTime(1L));

        //System.out.println("Times Cadastrados: " + app.buscarTimes());

        System.out.println("O maior salário do " + app.buscarNomeTime(1L) + " é " + app.buscarJogadorMaiorSalario(1L));

        System.out.println("O maior salário do " + app.buscarNomeTime(2L) + " é " + app.buscarJogadorMaiorSalario(2L));

        //System.out.println("Salário do jogador: " + app.buscarNomeJogador(3L) + " é R$ " + app.buscarSalarioDoJogador(3L));

        //System.out.println("Lista de melhores jogadores = " + app.buscarTopJogadores(4));

        //System.out.println("Cor camisa time de fora que é o : " + app.buscarNomeTime(2L) + " , "  + app.buscarCorCamisaTimeDeFora(1L,2L));

        System.out.println("Jogador mais velho do time : " + app.buscarNomeTime(1l) + " , " + " é : " + app.buscarJogadorMaisVelho(1l));

        System.out.println("os top 5 jogadores são esses: " + app.buscarTopJogadores(5));


    }

}


