package util;

import java.util.ArrayList;
import java.util.List;
import main.Vertice;

/**
 *
 * @author lhfba
 */
public class MetodosComuns {

    public static List<Vertice> construrRepresentacaoAdjacencias(int[][] representacaoMatriz) {
        //TODO:
        // nos exemplos dados, todos os nos estao ligados com todos os outros, logo a matriz e 
        // a lista de adjacencias vao ser iguais, mas caso apareca algum exemplo onde isso nao acontece,
        //esse metodo ja estara pronto

        // construir lista de vertices
        List<Vertice> vertices = new ArrayList<>();
        for (int i = 0; i < representacaoMatriz.length; i++) { // linha
            vertices.add(new Vertice());
        }

        // para cada vertice, ver na matriz quem eh seu vizinho
        for (int i = 0; i < vertices.size(); i++) { // linha
            for (int j = 0; j < representacaoMatriz[i].length; j++) { // coluna
                if (representacaoMatriz[i][j] != 0 && representacaoMatriz[i][j] != Integer.MAX_VALUE) {
                    vertices.get(i).add(vertices.get(j));
                }
            }
        }

        return vertices;

//        //a lista de ajacecias eh uma lista de vertices. Cada vertice tem uma representacao ára outro vertice
//        ArrayList<Vertice> adjacencias = new ArrayList<>();
//
//        for (int i = 0; i < representacaoMatriz.length; i++) { // linha
//            adjacencias.add(new Vertice()); // crio um vertice
//            for (int j = 0; j < representacaoMatriz[i].length; j++) { // coluna
//                if (representacaoMatriz[i][j] != 0 && representacaoMatriz[i][j] != Integer.MAX_VALUE) {
//                    adjacencias.get(i).add(new Vertice(representacaoMatriz[i][j])); // adiociono em adjacencias
//                }
//            }
//        }
//
//        return adjacencias;
    }

    /**
     * Le de um arquivo txt a entrada do problema no formato descrito no pdf
     *
     * @param entrada caminho do arquivo
     * @return grafo numa representação de matriz
     */
    public static int[][] construirRepresentacaoMatriz(String entrada) {
        // ler arquivo
        String arquivoBruto = fileManager.FileManager.readFromFile(entrada);

        String[] linhas = arquivoBruto.split("\n");

        int n = Integer.parseInt(linhas[0]);
        int matriz[][] = new int[n][n];

        // construir matriz
        // i eh linha no arquivo 
        // j eh a coluna.
        for (int i = 1; i < linhas.length; i++) {
            String[] pesos_ij = linhas[i].split(" ");
            for (int j = pesos_ij.length - 1; j >= 0; j--) {
                /*i-1 na matriz ja que a primeira linha == 'n'
                Como so precisa do teiangulo superior, a matriz comeca do elemento (i)(j+i)*/
                int peso;
                try {
                    peso = Integer.parseInt(pesos_ij[j]);
                } catch (NumberFormatException e) {
                    peso = Integer.MAX_VALUE;
                }
                matriz[i - 1][j + i] = peso;
            }
        }

        return matriz;
    }

}
