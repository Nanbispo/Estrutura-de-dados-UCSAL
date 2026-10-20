package lista_simples;

import java.util.Scanner;

class NodeSimplesString {
    String nome;
    NodeSimplesString proximo;

    public NodeSimplesString(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
}

class ListaSimplesEx02 {
    NodeSimplesString inicio;

    public void inserir(String nome) {
        NodeSimplesString novo = new NodeSimplesString(nome);
        if (inicio == null) {
            inicio = novo;
        } else {
            NodeSimplesString atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public boolean contem(String nome) {
        NodeSimplesString atual = inicio;
        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void exibir() {
        NodeSimplesString atual = inicio;
        while (atual != null) {
            System.out.print(atual.nome + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}

public class ListaSimples {
    public static void main(String[] args) {
        ListaSimplesEx02 L1 = new ListaSimplesEx02();
        ListaSimplesEx02 L2 = new ListaSimplesEx02();
        ListaSimplesEx02 L3 = new ListaSimplesEx02(); // Interseção

       
        L1.inserir("Ana"); L1.inserir("Carlos"); L1.inserir("João"); L1.inserir("Maria");
        L2.inserir("Pedro"); L2.inserir("Maria"); L2.inserir("Ana"); L2.inserir("Lucas");

        NodeSimplesString atualL1 = L1.inicio;
        while (atualL1 != null) {
            if (L2.contem(atualL1.nome) && !L3.contem(atualL1.nome)) {
                L3.inserir(atualL1.nome);
            }
            atualL1 = atualL1.proximo;
        }

        System.out.println("Lista 1:"); L1.exibir();
        System.out.println("Lista 2:"); L2.exibir();
        System.out.println("Lista 3 (Nomes em Comum):"); L3.exibir();
    }
}
