package com.vickllny.leetcode;

import java.util.*;

/**
 * @description:
 * @author: vickllny
 * @date 2022-10-23 20:48
 * @leetcode: https://leetcode.cn/problems/route-between-nodes-lcci/submissions/
 */
public class DirectedGraph {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Graph g = new Graph(n);
        for (int[] ints : graph) {
            g.listGraph.addEdge(ints[0], ints[1]);
        }
        return g.find(start, target);
    }

    static class Graph {
        ListGraph listGraph;
        boolean[] visited;

        public Graph(int length){
            this.listGraph = new ListGraph(length);
            this.visited = new boolean[length];
        }

        public boolean find(int start, int end){
            List<Integer> neighbors = this.listGraph.getNeighbors(start);
            if (null == neighbors || neighbors.isEmpty()){
                return false;
            }
            return findEndRecursive(neighbors, end);
        }

        public boolean findEndRecursive(List<Integer> neighbors, int end){
            for (Integer neighbor : neighbors) {
                if(this.visited[neighbor]){
                    continue;
                }
                if(neighbor == end){
                    return true;
                }
                this.visited[neighbor] = true;
                if(findEndRecursive(this.listGraph.getNeighbors(neighbor), end)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 图
     */
    static class ListGraph {
        private Map<Integer, ArrayList<Integer>> graphs;

        public ListGraph(int n){
            graphs = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                graphs.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int start, int end){
            graphs.get(start).add(end);
        }

        public List<Integer> getNeighbors(int start) {
            return graphs.get(start);
        }
    }

}
