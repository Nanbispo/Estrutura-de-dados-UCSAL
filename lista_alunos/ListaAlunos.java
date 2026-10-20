package lista_alunos;

class Aluno {
    String nome;
    int idade;
    Aluno anterior, proximo;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

class ListaDuplaAlunos {
    Aluno inicio, fim;

    public void inserirInicio(String nome, int idade) {
        Aluno novo = new Aluno(nome, idade);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirFim(String nome, int idade) {
        Aluno novo = new Aluno(nome, idade);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void listarTodos() {
        Aluno atual = inicio;
        System.out.println("--- Lista de Alunos ---");
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + ", Idade: " + atual.idade);
            atual = atual.proximo;
        }
    }
}

public class ListaAlunos {
    public static void main(String[] args) {
        ListaDuplaAlunos lista = new ListaDuplaAlunos();

        lista.inserirFim("Marcos", 20);
        lista.inserirFim("Julia", 22);
        lista.inserirFim("Fernanda", 19);
        lista.inserirFim("Roberto", 25);
        lista.inserirFim("Amanda", 21);

        lista.inserirInicio("Zeca (Novo Início)", 18);
        lista.inserirFim("Laura (Novo Fim)", 24);

        lista.listarTodos();
    }
}
