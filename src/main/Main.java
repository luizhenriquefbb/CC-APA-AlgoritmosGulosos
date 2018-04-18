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
        String entrada = "intanciasTest/dij10.txt";

        // ler arquivo de entrada e retornar o grafo/arvore numa representacao de matriz
        int[][] matriz = construirRepresentacaoMatriz(entrada);

        // representacao em lista de adjacencia
        List<Vertice> adjacencia = construrRepresentacaoAdjacencias(matriz);
        
        // MSTPrim
        System.out.println("MST prim\n");
        Prim prim = new Prim(adjacencia, matriz);
        
        System.out.println("\n=============");
        // MSTKruskal
        // TODO
        System.out.println("MST Kruskal\n");
        
        System.out.println("\n=============");
        // Dijkstra
        System.out.println("Dijkstra\n");
        Dijkstra dijkstra = new Dijkstra(adjacencia, matriz);
        
        
       
    }
}
