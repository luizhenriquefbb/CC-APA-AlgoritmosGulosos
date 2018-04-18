package main;

import java.util.ArrayList;
import java.util.List;
import static util.MetodosComuns.buildMinHeap;

public class Dijkstra {

    List<Vertice> vertices;

    /**
     * Construtor do metodo de Dijkstra.
     *
     * @param adjacencia Grafo no formato de lista de adjacencia <br>
     * Lista de inteiro, onde o valor desse inteiro é a distancia entre um no e
     * outro
     * @param representacaoMatriz Grafo no formato de matriz
     */
    public Dijkstra(List<Vertice> adjacencia, int[][] representacaoMatriz) {
        this.vertices = adjacencia;

        this.iniciaVertices();

        this.melhoresCaminhos(this.vertices.toArray(new Vertice[0]), representacaoMatriz, 0, (this.vertices.size() - 1));

    }

    /**
     * Todos os vertices iniciam com infinito
     */
    public void iniciaVertices() {
        for (Vertice v : this.vertices) {
            v.valor = Integer.MAX_VALUE;
        }
    }

    /**
     * Metodo principal de Dijkstra
     *
     * @param vertices lista de vertices
     * @param representacaoMatriz
     * @param inicio de onde sai a busca. No momento so funciona com iniio == 0 
     * @param fim vartice-objetivo.
     */
    private void melhoresCaminhos(Vertice[] vertices, int[][] representacaoMatriz, int inicio, int fim) {
        //Atribui zero ao vertice inicial
        vertices[inicio].valor = 0;

        //Controi a primeira arvore heap
        ArrayList<Vertice> minHeap = buildMinHeap(vertices.clone());

        Vertice verticeAuxiliar = null;

        /**
         * saida final
         */
        Vertice[] res = new Vertice[vertices.length];

        while (minHeap.size() != 0) { //executa até não ter mais elementos
            verticeAuxiliar = minHeap.remove(0); //tira o menor elemento e armazena em verticeAuxiliar

            //percorre os demais 
            for (Vertice v : verticeAuxiliar.adj) {
                /*relaxamento*/

                if (minHeap.contains(v)
                        && v.valor > verticeAuxiliar.valor + representacaoMatriz[verticeAuxiliar.getId()][v.getId()]) {

                    v.valor = (verticeAuxiliar.valor + representacaoMatriz[verticeAuxiliar.getId()][v.getId()]);
                    v.pai = verticeAuxiliar;
                }
            }

            minHeap = buildMinHeap(minHeap.toArray(new Vertice[minHeap.size()]));

            res[representacaoMatriz.length - (minHeap.size() + 1)] = verticeAuxiliar;
        }

        System.out.println("Menor caminho do " + inicio + " para " + fim + " é: ");
        String resposta = "";
        int caminhoTotal = 0;

//        // TODO: colocar vertice de inicio na posicao inicial
//        verticeAuxiliar = res[0];
//        res[0] = res[inicio];
//        res[inicio] = verticeAuxiliar;

        for (Vertice v : res) {
            if (v.getId() == fim) {
                verticeAuxiliar = v;
                break;
            }
        }

        resposta = verticeAuxiliar.getId() + "";
        while (verticeAuxiliar.pai != null) {
            resposta = verticeAuxiliar.pai.getId() + " - " + resposta;
            // somar o caminho percorrido
            // TODO: testar essa instrucao
            caminhoTotal+=representacaoMatriz[verticeAuxiliar.pai.id][verticeAuxiliar.id];
            verticeAuxiliar = verticeAuxiliar.pai;
        }
        System.out.println(resposta+
                "\n soma dos caminhos = "+caminhoTotal);
        
    }

}
