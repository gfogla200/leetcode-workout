

/*
*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.



Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.


Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
*
* */

import java.util.*;

// not the right solution
public class CriticalConnections {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer, List<Integer>> edges = new HashMap<>();

        for (int i = 0; i < connections.size(); i++) {
            List<Integer> edge = connections.get(i);
            if (edges.containsKey(edge.get(0))) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(edges.get(edge.get(0)));
//                System.out.println(edge.get(0) + "    " + temp);
                temp.add(edge.get(1));
                edges.put(edge.get(0), temp);
            } else
                edges.put(edge.get(0), Arrays.asList(edge.get(1)));

            if (edges.containsKey(edge.get(1))) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(edges.get(edge.get(1)));
                temp.add(edge.get(0));
                edges.put(edge.get(1), temp);
            } else
                edges.put(edge.get(1), Arrays.asList(edge.get(0)));
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            flag = false;
            for (Map.Entry<Integer, List<Integer>> entry : edges.entrySet()) {
                if (entry.getValue() != null && entry.getValue().size() == 1) {
                    res.add(Arrays.asList(entry.getKey(), entry.getValue().get(0)));
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(edges.get(entry.getValue().get(0)));
                    temp.remove(entry.getKey());
                    edges.put(entry.getValue().get(0), temp);
                    edges.put(entry.getKey(), null);
                    flag = true;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(5, 3)
        );
        List<List<Integer>> res = criticalConnections(6, graph);
        for (int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }
}
