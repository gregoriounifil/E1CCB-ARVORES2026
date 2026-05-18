# Remoção em Árvores Binárias

Na implementação da classe `removerRecursivo`, optei pela estratégia de substituição do **nó alvo** pelo seu **nó sucessor**. Seguindo essa lógica, o menor elemento da subárvore subsequente é utilizado como sucessor em casos de nós com dois filhos. Dessa forma, a lógica de remoção permanece intacta e dinâmica quando aplicada com **recursividade**, abordagem escolhida para esta implementação.

Com isso, garantimos que o sucessor seja **maior que os elementos da subárvore esquerda** e **menor que os demais elementos da subárvore direita**, preservando corretamente a organização da árvore binária.

A utilização de **recursão** foi vantajosa durante a construção do método, pois permitiu deixar o código mais limpo e organizado, facilitando as checagens e o *debug*. Entretanto, é necessário redobrar a atenção na definição de quais elementos deverão entrar na recursividade em cada saída das estruturas condicionais.
