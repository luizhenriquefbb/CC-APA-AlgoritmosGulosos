package main;

import java.util.ArrayList;
import java.util.List;
import static util.MetodosComuns.buildMinHeap;

/**
 * font: https://pt.wikipedia.org/wiki/Algoritmo_de_Prim
 *
 * @author lhfba
 */
public class Prim {

    
    List<Vertice> vertices;

    /**
     * Construtor do metodo de prim.
     *
     * @param adjacencia Grafo no formato de lista de adjacencia <br>
     * Lista de inteiro, onde o valor desse inteiro é a distancia entre um no e
     * outro
     * @param representacaoMatriz Grafo no formato de matriz
     */
    public Prim(List<Vertice> adjacencia, int[][] representacaoMatriz) {
        this.vertices = adjacencia;
        
        this.inicializaVertices();
        
        this.buildMSTPrim(this.vertices.toArray(new Vertice[0]), representacaoMatriz, 0);
    }

    /**
     * Seta os valores dos vertices para infinito
     */
    private void inicializaVertices() {
        for (Vertice v : this.vertices) {
            v.valor = Integer.MAX_VALUE;
        }
    }

    /**
     * Metodo principal
     * @param numeroVertices
     * @param listaVertices conjunto de vertices
     * @param formatoMatriz
     * @param inicial posicao de qual vertice comecar
     */
    private void buildMSTPrim(Vertice[] listaVertices, int[][] formatoMatriz, int inicial) {
        int numeroVertices = this.vertices.size();
        
        //Array final com os resultados
        Vertice[] resultado = new Vertice[numeroVertices];
        
        //Variavel vertice auxiliar, usado em cada remocao
        Vertice v = null;
        
        int minHeapTamanho = 0;

        //Atribui zero ao vertice escolhido como inicial
        listaVertices[inicial].valor = 0;

        //Controi a primeira arvore heap
        ArrayList<Vertice> minHeap = buildMinHeap(listaVertices.clone());		

        // enquanto tiver elementos na minHeap
        while ((minHeapTamanho = minHeap.size()) != 0) {
            v = minHeap.remove(0);		//Remove o primeiro vertice da lista

            // para cada vizinho de V
            for (int i = 0; i < v.adj.size(); i++) {
                //Confere se o vertice adjacente estah no conjunto Q (minHeap)
                // e se o peso da aresta eh menor que o valor atual do vertice
                // if ((minHeap.contains(v.adj.get(i))) && (formatoMatriz[v.id][v.adj.get(i).id] < (v.adj.get(i).valor))) {
                if ((formatoMatriz[v.id][v.adj.get(i).id] < (v.adj.get(i).valor))) {
                    v.adj.get(i).pai = v; //Atribui o vertice retirado como o novo pai
                    v.adj.get(i).valor = formatoMatriz[v.id][v.adj.get(i).id]; //Modifica o valor do vertice pelo peso da aresta correspondente
                }
            }

            minHeap = buildMinHeap(minHeap.toArray(new Vertice[minHeap.size()]));

            resultado[numeroVertices - minHeapTamanho] = v; //Guarda os vertices ja acessados
        }

        int total = 0;

        // exibir resultado
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i].pai != null) {
                System.out.println("ID: " + resultado[i].id + " Pai: " + resultado[i].pai.id + " Valor: " + resultado[i].valor);
            } else {
                System.out.println("ID: " + resultado[i].id + " Pai: " + resultado[i].pai + " Valor: " + resultado[i].valor);
            }

            total += resultado[i].valor;
        }

        System.out.println("\nValor total: " + total);

    }

    
}
