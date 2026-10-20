package lista_dupla;

class NodeDuploInt {
    int dado;
    NodeDuploInt anterior, proximo;

    public NodeDuploInt(int dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplaEx01 {
    NodeDuploInt inicio, fim;

    public void inserirEsquerda(int dado) {
        NodeDuploInt novo = new NodeDuploInt(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirDireita(int dado) {
        NodeDuploInt novo = new NodeDuploInt(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void exibirEsquerdaParaDireita() {
        NodeDuploInt atual = inicio;
        System.out.print("Lista (E->D): ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void exibirDireitaParaEsquerda() {
        NodeDuploInt atual = fim;
        System.out.print("Lista (D->E): ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }
}

public class ListaDuplamenteEncade {
    public static void main(String[] args) {
        ListaDuplaEx01 lista = new ListaDuplaEx01();
        lista.inserirDireita(10);
        lista.inserirDireita(20);
        lista.inserirEsquerda(5);
        lista.inserirEsquerda(1);
        
        lista.exibirEsquerdaParaDireita(); 
        lista.exibirDireitaParaEsquerda(); 
    }
}