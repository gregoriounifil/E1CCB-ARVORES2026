public class No {

    Integer conteudo;
    No esquerda;
    No direita;

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }
}
