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
            if (atual == null || no == null) {
                return;
            }

            if (atual.getConteudo().equals(no.getConteudo())) {
                if (atual.getEsquerda() == null && atual.getDireita() == null) {
                    this.raiz = null;
                } else if (atual.getEsquerda() == null && atual.getDireita() != null) {
                    this.raiz = atual.getDireita();
                } else if (atual.getEsquerda() != null && atual.getDireita() == null) {
                    this.raiz = atual.getEsquerda();
                } else {
                    No sucessor = atual.getDireita();

                    while (sucessor.getEsquerda() != null) {
                        sucessor = sucessor.getEsquerda();
                    }

                    atual.setConteudo(sucessor.getConteudo());
                    removerRecursivo(sucessor, atual.getDireita());
                }

                return;
            }

            if (no.getConteudo() > atual.getConteudo()) {
                if (atual.getDireita() != null) {
                    if (atual.getDireita().getConteudo().equals(no.getConteudo())) {
                        No aux = atual.getDireita();

                        if (aux.getEsquerda() == null && aux.getDireita() == null) {
                            atual.setDireita(null);
                        } else if (aux.getDireita() == null && aux.getEsquerda() != null) {
                            atual.setDireita(aux.getEsquerda());
                        } else if (aux.getDireita() != null && aux.getEsquerda() == null) {
                            atual.setDireita(aux.getDireita());
                        } else {
                            No sucessor = aux.getDireita();

                            while (sucessor.getEsquerda() != null) {
                                sucessor = sucessor.getEsquerda();
                            }

                            aux.setConteudo(sucessor.getConteudo());
                            removerRecursivo(sucessor, aux.getDireita());
                        }
                    } else {
                        removerRecursivo(no, atual.getDireita());
                    }
                }

                return;

            } else if (no.getConteudo() < atual.getConteudo()) {
                if (atual.getEsquerda() != null) {
                    if (atual.getEsquerda().getConteudo().equals(no.getConteudo())) {
                        No aux = atual.getEsquerda();

                        if (aux.getDireita() == null && aux.getEsquerda() == null) {
                            atual.setEsquerda(null);
                        } else if (aux.getEsquerda() == null && aux.getDireita() != null) {
                            atual.setEsquerda(aux.getDireita());
                        } else if (aux.getEsquerda() != null && aux.getDireita() == null) {
                            atual.setEsquerda(aux.getEsquerda());
                        } else {
                            No sucessor = aux.getDireita();

                            while (sucessor.getEsquerda() != null) {
                                sucessor = sucessor.getEsquerda();
                            }

                            aux.setConteudo(sucessor.getConteudo());
                            removerRecursivo(sucessor, aux.getDireita());
                        }
                    } else {
                        removerRecursivo(no, atual.getEsquerda());
                    }
                }
            }

            return;
        }
    }