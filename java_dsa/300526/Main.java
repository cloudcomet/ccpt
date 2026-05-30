import java.util.ArrayList;
import java.util.Arrays;

class Graph<T>{

    int[][] matrix;
    boolean directed;
    ArrayList<ArrayList<Integer>> adjList;


    public Graph(int size, boolean directed){
        this.matrix = new int[size][size];
        this.directed = directed;
        this.adjList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            this.adjList.add(list);
        }
    }

    public void edges(int i, int j){
        this.matrix[i][j] = 1;

        if(!directed){
            this.matrix[j][i] = 1;
        }
    }

    public void displayMatrix(){
        for (int[] x : matrix){
            System.out.println(Arrays.toString(x));
        }
    }

    public ArrayList<ArrayList<Integer>> adjList(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1){
                    this.adjList.get(i).add(j);
                }
            }
        }

        return this.adjList;
    }
}

public class Main {

    public static void main(String[] args){

        Graph<Integer> graph = new Graph<>(5, true);
        graph.edges(0, 1);
        graph.edges(0, 2);
        graph.edges(1, 3);
        graph.edges(2, 3);
        graph.edges(3, 4);
        graph.displayMatrix();
        System.out.println(graph.adjList());

    }

}