package edu.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task3 {
    static class DFS extends RecursiveTask<List<Integer>> {
        private final int vertex;
        private final int desiredVertex;
        private final List<List<Integer>> graph;
        private final AtomicBoolean[] used;

        DFS(int vertex, int desiredVertex, List<List<Integer>> graph, AtomicBoolean[] used) {
            this.vertex = vertex;
            this.desiredVertex = desiredVertex;
            this.graph = graph;
            this.used = used;
        }

        @Override
        protected List<Integer> compute() {
            List<Integer> path = new ArrayList<>();

            boolean isCurrentVertexUsed = true;

            synchronized (used[vertex]) {
                if (!used[vertex].get()) {
                    used[vertex].set(true);
                    isCurrentVertexUsed = false;
                }
            }

            if (!isCurrentVertexUsed) {
                if (vertex == desiredVertex) {
                    path.add(vertex);
                } else {
                    List<DFS> list = new ArrayList<>();
                    for (var neighbour : graph.get(vertex)) {
                        list.add(new DFS(neighbour, desiredVertex, graph, used));

                        list.get(list.size() - 1).fork();
                    }

                    for (var each : list) {
                        path = each.join();

                        if (!path.isEmpty()) {
                            path.add(vertex);
                            break;
                        }
                    }
                }
            }

            return path;
        }
    }
}
