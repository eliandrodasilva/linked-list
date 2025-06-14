package listas;

public class ListaEncadeadaGenerica<T> {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lúdica");
        pessoa.setIdade(15);
        ListaEncadeadaGenerica lista = new ListaEncadeadaGenerica();
        lista.adicionarInicio(3);

        lista.adicionarFim(6);
        lista.adicionarInicio(pessoa);
        lista.adicionarFim(9);
        lista.adicionarFim("linda");
        lista.adicionarInicio("coração");
        lista.adicionarMeio(10, 9);

        lista.imprimir();
    }
    No<T> cabeca;

    public void adicionarInicio(T valor) {
        No<T> novoElemento = new No(valor);

        if(cabeca != null) {
            novoElemento.proximo = cabeca;
        }
        cabeca = novoElemento;
    }

    public void adicionarMeio(T valor, T valorReferencia) {
        if (cabeca != null) {
            No temp = cabeca;
            while (temp.proximo != null && temp.proximo.valor != valorReferencia) {
                temp = temp.proximo;
            }
            if (temp.proximo != null) {
                No novoElemento = new No(valor);
                novoElemento.proximo = temp.proximo;
                temp.proximo = novoElemento;
            } else {
                System.out.println("Valor de referência não encontrado na lista.");
            }
        } else {
            adicionarInicio(valor);
        }
    }

    public void adicionarFim(T valor) {
        if (cabeca != null) {
            No temp = cabeca;
            while(temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = new No(valor);
        } else {
            adicionarInicio(valor);
        }
    }

    public void imprimir() {
        No temp = cabeca;
        while(temp != null) {
            System.out.print(temp.valor+" -> ");
            temp = temp.proximo;
        }
        System.out.println("Null");
    }

    private static class No<T> {
        T valor;
        No<T> proximo;

        public No(T valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
}
