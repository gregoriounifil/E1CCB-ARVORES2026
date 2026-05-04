public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    public void inserir(Integer conteudo) {

        No novoNo = new No(conteudo);
        if(this.raiz == null) {
            this.raiz = novoNo;
        } else if (this.raiz.getConteudo() > conteudo){ // esquerda
            if(existe(this.raiz.getEsquerda())) {

            }
        }


    }
}
