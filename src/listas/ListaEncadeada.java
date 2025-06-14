package listas;

public class ListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionarFim(6);
        lista.adicionarInicio(3);
        lista.adicionarFim(9);
        lista.adicionarInicio(0);
        lista.adicionarMeio(10, 9);

        lista.imprimir();
    }
    No cabeca;

    public void adicionarInicio(int valor) {
        No novoElemento = new No(valor);

        if(cabeca != null) {
            novoElemento.proximo = cabeca;
        }
        cabeca = novoElemento;
    }

    public void adicionarMeio(int valor, int valorReferencia) {
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

    public void adicionarFim(int valor) {
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

    private static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
}
