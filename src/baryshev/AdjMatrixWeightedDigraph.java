package baryshev;

public class AdjMatrixWeightedDigraph extends AdjMatrixWeightedGraph implements Digraph{
    public AdjMatrixWeightedDigraph(boolean[][] adjMatrix, double[][] resistors) {
        super(adjMatrix, resistors);
    }

    public AdjMatrixWeightedDigraph() {
        super();
    }
}
