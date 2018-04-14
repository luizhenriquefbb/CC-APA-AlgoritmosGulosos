# CC-APA-AlgoritmosGulosos

Repositorio referente a segunda parte do curso de APA de ciência da computação 2017.2

Descrição do projeto disponível [no pdf](https://github.com/luizhenriquefbb/CC-APA-AlgoritmosGulosos/blob/master/Dijkstra_Kurskal_e_PRIM.pdf)


## Resumo sobre o problema
[fonte: stackOverflow](https://pt.stackoverflow.com/questions/215980/algoritmo-de-prim-e-kruskal)

    Prim e Kruskal servem para gerar uma Árvore Geradora Mínima de um Grafo.

### Prim

    Gera uma árvore única
    Ao longo do algoritmo, o conjunto X sempre é uma árvore

### Kruskal

    Gera uma floresta, antes de gerar uma Árvore Geradora Mínima
    Existe garantia de ser apenas uma árvore apenas depois da última iteração



### Dijkstra

    Soluciona o problema do caminho mais curto num grafo.
    Algoritmo de Dijkstra e Prim são quase exatamente iguais, porém no Prim você não soma o resultado obtido, mas a execução é igual.
    A utilização desses dois algoritmos são para problemas distintos (não são relacionados ao mesmo problema). Um resolve o caminho mais curto enquanto o outro gera uma AGM.

