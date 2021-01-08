/*
 Criar um código que realize as seguintes operações:
	Crie os objetos abaixo com seus campos correspondentes:

		Filho:
			nome = texto

		Pai:
			nome = texto
			filhos = lista de Filho

	O algorítmo deve ler o arquivo 'tarefa_1.txt' e realizar um processamento para cada linha: (exemplo de linha: PAIANTONIO CARLOS SILVA)
		Se a linha começa com PAI, deve ser criado um objeto Pai com o nome correspondente ao conteúdo da linha (exceto o token PAI) e todos os próximos filhos lidos serão filhos deste pai, até que seja criado um novo pai.
		Se a linha começa com FILHO, deve ser criado um objeto Filho com o nome correspondente ao conteúdo da linha (exceto o token FILHO) e o filho deve ser adicionado na lista de filhos do último pai criado.
	Após realizar o processamento do arquivo, deve ser impresso os pais de filhos lidos, de tal maneira que seja possível identificar quem são os filhos de cada pai.
	Os pais e filhos devem ser impressos em ordem alfabética decrescente.

 */
package Exercicio_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author TIAGO
 */
public class Exercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<Pai> listaPais = new ArrayList();

        try {
            /**
             * Abre o arquivo
             * insira abaixo a localização do arquivo
             */
            FileReader fr = new FileReader("G:/tarefa_1.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            /**
             * A cada interação, lê uma linha do arquivo e atribui-a a temp
             */
            while ((temp = br.readLine()) != null) {
                if (temp.startsWith("PAI")) {
                    Pai pai = new Pai();
                    String[] restoDeString = temp.split("PAI", 3);
                    for (String s : restoDeString) {
                        if (s != null && !s.isEmpty()) {
                            pai.setNome(s);
                        }
                    }
                    listaPais.add(pai);
                } else if (temp.startsWith("FILHO")) {
                    Filho filho = new Filho();
                    String[] restoDeString = temp.split("FILHO", 3);
                    for (String s : restoDeString) {
                        if (s != null && !s.isEmpty()) {
                            filho.setNome(s);
                        }
                    }
                    if (listaPais.get(listaPais.size() - 1).getListaDeFilhos() == null) {
                        List listaFilhos = new ArrayList<>();
                        listaPais.get(listaPais.size() - 1).setListaDeFilhos(listaFilhos);
                        listaPais.get(listaPais.size() - 1).getListaDeFilhos().add(filho);
                    } else {
                        listaPais.get(listaPais.size() - 1).getListaDeFilhos().add(filho);
                    }
                }
            }
        } catch (FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException e) {
        }
        Collections.sort(listaPais, (Pai pai1, Pai pai2) -> pai1.getNome().compareTo(pai2.getNome()));
        for (int i = 0; i < listaPais.size(); i++) {
            System.out.println(listaPais.get(i).getNome());
            if (listaPais.get(i).getListaDeFilhos() != null) {
                Collections.sort(listaPais.get(i).getListaDeFilhos(), (Filho filho1, Filho filho2) -> filho1.getNome().compareTo(filho2.getNome()));
                for (int a = 0; a < listaPais.get(i).getListaDeFilhos().size(); a++) {
                    System.out.println(listaPais.get(i).getListaDeFilhos().get(a).getNome() + " filho de: " + listaPais.get(i).getNome());
                }
            } else {
                System.out.println("Sem filhos!");
            }
        }
    }

}
