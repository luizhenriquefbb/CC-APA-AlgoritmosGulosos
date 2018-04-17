package main;

import java.util.List;
import static util.MetodosComuns.construirRepresentacaoMatriz;
import static util.MetodosComuns.construrRepresentacaoAdjacencias;

/**
 *
 * @author lhfba
 */
public class Main {

    public static void main(String[] args) {
        // arquivo de entrada
        String entrada = "intanciasTest/slide_entrada.txt";

        // ler arquivo de entrada e retornar o grafo/arvore numa representacao de matriz
        int[][] matriz = construirRepresentacaoMatriz(entrada);

        // representacao em lista de adjacencia
        List<Vertice> adjacencia = construrRepresentacaoAdjacencias(matriz);
        
        // MSTPrim
        Prim prim = new Prim(adjacencia, matriz);
        
        // MSTKruskal
        
        // Dijkstra
        
        
       
    }
}
