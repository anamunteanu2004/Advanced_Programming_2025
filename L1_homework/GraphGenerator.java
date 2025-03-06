import java.util.*;

public class GraphGenerator {
    private boolean[][] adjacencyMatrix;
    private final int n;
    private final int k; 
    private int m; 
    private int maxDegree;
    private int minDegree;

    public GraphGenerator(int n, int k) {
        this.n = n;
        this.k = k;
        
        if (n < k) {
            throw new IllegalArgumentException("n must be at least k");
        }
        
        generateGraph();
        countEdges();
        calculateDegrees();
    }
    
    private void generateGraph() {
        adjacencyMatrix = new boolean[n][n];
        Random random = new Random();
        
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                adjacencyMatrix[i][j] = true;
                adjacencyMatrix[j][i] = true;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((i < k && j < k) || (i >= n - k && j >= n - k)) {
                    continue;
                }
                
                if (random.nextBoolean()) {
                    adjacencyMatrix[i][j] = true;
                    adjacencyMatrix[j][i] = true;
                }
            }
        }
    }
    
    private void countEdges() {
        m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    m++;
                }
            }
        }
    }
    
    private void calculateDegrees() {
        int[] degrees = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    degrees[i]++;
                }
            }
        }
        
        maxDegree = Arrays.stream(degrees).max().getAsInt();
        minDegree = Arrays.stream(degrees).min().getAsInt();
    }
    
    public String getMatrixRepresentation() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(adjacencyMatrix[i][j] ? "■ " : "□ ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    public int getNumberOfEdges() {
        return m;
    }
    
    public int getMaxDegree() {
        return maxDegree;
    }
    
    public int getMinDegree() {
        return minDegree;
    }
    
    public boolean verifyDegreesSum() {
        int sumOfDegrees = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j]) {
                    sumOfDegrees++;
                }
            }
        }
        
        return sumOfDegrees == 2 * m;
    }
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid usage!!");
            System.exit(1);
        }
        
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        
        long startTime = System.currentTimeMillis();
        
        try {
            GraphGenerator generator = new GraphGenerator(n, k);
            
            if (n <= 30) {
                System.out.println("Generated adjacency matrix:");
                System.out.println(generator.getMatrixRepresentation());
            }
            
            System.out.println("Number of edges (m): " + generator.getNumberOfEdges());
            System.out.println("Maximum degree (Δ): " + generator.getMaxDegree());
            System.out.println("Minimum degree (δ): " + generator.getMinDegree());
            
            boolean verification = generator.verifyDegreesSum();
            System.out.println("Sum of degrees equals 2m: " + verification);
            
            if (n > 30000) {
                long endTime = System.currentTimeMillis();
                System.out.println("Execution time: " + (endTime - startTime) + " ms");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
