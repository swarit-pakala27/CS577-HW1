import java.util.*;

public class DFS {
    static void dfs(String node, Map<String, List<String>> adj,
                    Set<String> visited, List<String> result) {
        visited.add(node);
        result.add(node);
        for (String neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            Map<String, List<String>> adj = new LinkedHashMap<>();
            List<String> inputOrder = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    i--;
                    continue;
                }
                String[] tokens = line.split("\\s+");
                String node = tokens[0];
                inputOrder.add(node);
                List<String> neighbors = new ArrayList<>();
                for (int j = 1; j < tokens.length; j++) {
                    neighbors.add(tokens[j]);
                }
                adj.put(node, neighbors);
            }

            Set<String> visited = new HashSet<>();
            List<String> result = new ArrayList<>();

            dfs(inputOrder.get(0), adj, visited, result);

            for (String node : inputOrder) {
                if (!visited.contains(node)) {
                    dfs(node, adj, visited, result);
                }
            }

            System.out.println(String.join(" ", result));
        }

        sc.close();
    }
}