import java.util.*;
//Mohammad Mousa
public class GraphConnectivity {

 static boolean isStronglyConnectedGabow(int[][] graph) {
 int n = graph.length;
 Gabow gabow = new Gabow(graph, n);
 return gabow.isStronglyConnected();
 } // Mohammad Ahmad & Alhasan Makhlouf & Leen Salamn

 static boolean isStronglyConnectedJens(int[][] graph) {
 int n = graph.length;
 boolean[] visited = new boolean[n];

 // Perform DFS from each node
 for (int i = 0; i < n; i++) {
 Arrays.fill(visited, false);
 dfs(graph, i, visited);
 for (boolean v : visited) {
if (!v) {
 return false;
 }
 }
 }

 return true;
 } //Joel Radwan

 static void dfs(int[][] graph, int node, boolean[] visited) {
 visited[node] = true;
 for (int neighbor : graph[node]) {
if (!visited[neighbor]) {
 dfs(graph, neighbor, visited);
 }
 }
}// Mohsen sultan

 public static void main(String[] args) {
int[][] graph = {
{1},
 {2},
 {0}
 };

 // Test connectivity using Gabow's algorithm
 boolean isConnectedGabow = isStronglyConnectedGabow(graph);
 System.out.println("Is strongly connected (Gabow): " + isConnectedGabow);

 // Reverse the edges
 int[][] reversedGraph = reverseEdges(graph);

 // Test connectivity after reversing edges using Jens' algorithm
 boolean isConnectedJens = isStronglyConnectedJens(reversedGraph);
 System.out.println("Is strongly connected after reversing edges (Jens): " + isConnectedJens);
} //Majd Housin & Batoul shahla

 static int[][] reverseEdges(int[][] graph) {
 int n = graph.length;
 int[][] reversedGraph = new int[n][];
 for (int i = 0; i < n; i++) {
 reversedGraph[i] = new int[0];
 }
for (int i = 0; i < n; i++) {
 for (int j : graph[i]) {
 reversedGraph[j] = addElement(reversedGraph[j], i);
 }
 }
 return reversedGraph;
 }

 static int[] addElement(int[] arr, int element) {
 int[] newArr = Arrays.copyOf(arr, arr.length + 1);
 newArr[arr.length] = element;
 return newArr;
}
}