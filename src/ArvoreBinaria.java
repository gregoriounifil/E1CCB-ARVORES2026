    public class ArvoreBinaria {
        No raiz;

        public ArvoreBinaria() {
            this.raiz = new No(null);
        }

        public void inserir(Integer conteudo) {
            No novoNo = new No(conteudo);
            inserirRecursivo(novoNo, this.raiz);
            //inserirIterativo(novoNo);
        }

        public void remover(Integer conteudo) {
            No novoNo = new No(conteudo);
            removerRecursivo(novoNo, this.raiz);
        }

        private void inserirRecursivo(No no, No atual) {
            if (estaVazia()) {
                this.raiz = no;
                return;
            }
            if (no.getConteudo() > atual.getConteudo()) {
                if (atual.getDireita() == null) {
                    atual.setDireita(no);
                    return;
                } else {
                    inserirRecursivo(no, atual.getDireita());
                }
            } else {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(no);
                    return;
                } else {
                    inserirRecursivo(no, atual.getEsquerda());
                }
            }
        }

        private void inserirIterativo(No no) {
            if (estaVazia()) {
                this.raiz = no;
                return;
            } else {
                No aux = this.raiz;
                while (aux != null) {
                    if (no.getConteudo() > aux.getConteudo()) {
                        if (aux.getDireita() == null) {
                            aux.setDireita(no);
                            return;
                        } else {
                            aux = aux.getDireita();
                        }
                    } else {
                        if (aux.getEsquerda() == null) {
                            aux.setEsquerda(no);
                            return;
                        } else {
                            aux = aux.getEsquerda();
                        }
                    }
                }
            }

        }

        public boolean estaVazia() {
            if (this.raiz.getConteudo() == null) {
                return true;
            } else {
                return false;
            }
        }

        public void exibir(String percurso) {
            switch (percurso) {
                case ("Pre"):
                    preOrdem(this.raiz);
                    break;
                case ("Em"):
                    emOrdem(this.raiz);
                    break;
                case ("Pos"):
                    posOrdem(this.raiz);
                    break;
            }

        }

        private void preOrdem(No no) {
            if (no == null) {
                return;
            }
            System.out.println(no.getConteudo());
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }

        private void emOrdem(No no) {
            if (no == null) {
                return;
            }
            emOrdem(no.getEsquerda());
            System.out.println(no.getConteudo());
            emOrdem(no.getDireita());
        }

        private void posOrdem(No no) {
            if (no == null) {
                return;
            }
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.println(no.getConteudo());
        }

        private void removerRecursivo(No no, No atual) {
            if (atual == null) {
                return;
            }
            if (no.getConteudo() > atual.getConteudo()) {
                if  (atual.getDireita() != null && atual.getDireita().getConteudo() == no.getConteudo())
                {
                    No aux = atual.getDireita();
                    if (aux.getEsquerda() == null && aux.getDireita() == null) {
                        atual.setDireita(null);
                        return;
                    } else if (aux.getDireita() == null && aux.getEsquerda() != null) {
                        atual.setDireita(aux.getEsquerda());
                        return;
                    } else if (aux.getDireita() != null && aux.getEsquerda() == null) {
                        atual.setDireita(aux.getDireita());
                        return;
                    } else {
                        No sucessor = aux.getDireita();
                        while (sucessor.getEsquerda() != null) {
                            sucessor = sucessor.getEsquerda();
                        }
                        removerRecursivo(sucessor, aux);
                        aux.setConteudo(sucessor.getConteudo());
                        return;
                    }
                } else {
                    No aux = atual.getEsquerda();
                    if (aux.getDireita() == null && aux.getEsquerda() == null) {
                        atual.setEsquerda(null);
                        return;
                    } else if (aux.getEsquerda() == null && aux.getDireita() != null) {
                        atual.setEsquerda(aux.getDireita());
                        return;
                    } else if (aux.getEsquerda() != null && aux.getDireita() == null) {
                        atual.setEsquerda(aux.getEsquerda());
                        return;
                    } else {
                        No sucessor = aux.getDireita();
                        while (sucessor.getEsquerda() != null) {
                            sucessor = sucessor.getDireita();
                        }
                        removerRecursivo(sucessor, aux);
                        aux.setConteudo(sucessor.getConteudo());
                        return;
                } }}}
             /*   return;
            } else if (no.getConteudo() < atual.getConteudo()) {
                if  (atual.getEsquerda() != null && atual.getEsquerda().getConteudo() == no.getConteudo())
                {

                } else {
                    removerRecursivo(no, atual.getEsquerda());
                    return;
                }
                return;
            } else if (no.getConteudo() == atual.getConteudo()) {
                    atual.get
            }*/
        }

            /*if (atual.getDireita() != null && atual.getEsquerda() != null) {
                removerRecursivo(no, atual.getEsquerda());
            } else if (atual.getEsquerda() != null) {
                removerRecursivo(no, atual);
            } else if (atual.getDireita() != null) {
                removerRecursivo(no, atual);
            } else {
                if () {

                }
            }

            }
        }*/