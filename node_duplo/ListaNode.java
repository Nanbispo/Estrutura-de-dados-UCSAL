package node_duplo;

class NodeDuploImpar {
    int dado;
    NodeDuploImpar anterior, proximo;

    public NodeDuploImpar(int dado) {
        this.dado = dado;
    }
}

class ListaDuplaImpares {
    NodeDuploImpar inicio, fim;

    public void inserirInicio(int dado) {
        NodeDuploImpar novo = new NodeDuploImpar(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirFim(int dado) {
        NodeDuploImpar novo = new NodeDuploImpar(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void removerInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
    }

    public void removerFim() {
        if (fim == null) {
            System.out.println("Lista vazia!");
            return;
        }
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
    }

    public void listarTodos() {
        NodeDuploImpar atual = inicio;
        System.out.print("Ímpares na Lista: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class ListaNode {
    public static void main(String[] args) {
        ListaDuplaImpares lista = new ListaDuplaImpares();

        int impar = 1;
        for (int i = 0; i < 15; i++) {
            lista.inserirFim(impar);
            impar += 2;
        }
        lista.listarTodos();

        System.out.println("\nRemovendo do início e do fim...");
        lista.removerInicio(); 
        lista.removerFim();    
        lista.listarTodos();

        System.out.println("\nInserindo novo início (-1) e novo fim (31)...");
        lista.inserirInicio(-1);
        lista.inserirFim(31);
        lista.listarTodos();
    }
}
