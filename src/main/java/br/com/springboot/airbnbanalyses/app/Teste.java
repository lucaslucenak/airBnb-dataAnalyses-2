package br.com.springboot.airbnbanalyses.app;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main (String[] args) {
        List<String> lista = new ArrayList<>();
        int aux = 0;

        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        lista.add("e");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("elemento: " + lista.get(i) + "    posicao: " + i);
        }

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals("c")) {
                aux = i;
            }
        }
        System.out.println("local do c: " + aux);

        lista.remove(2);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("elemento: " + lista.get(i) + "    posicao: " + i);
        }
    }
}
