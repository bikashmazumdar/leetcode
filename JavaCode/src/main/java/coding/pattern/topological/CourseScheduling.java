package coding.pattern.topological;

import java.util.*;

public class CourseScheduling {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 )
            return true;

        int [] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int e = prerequisite[0];
            int key = prerequisite[1];
            inDegree[e]++;
            List<Integer> dependencies = map.getOrDefault(key, new ArrayList<>());
            dependencies.add(e);
            map.put(key, dependencies);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int degree : inDegree) {
            if (degree == 0) {
                queue.offer(degree);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> dependencies = map.get(current);
            if (dependencies != null) {
                for (int dependency : dependencies) {
                    inDegree[dependency]--;
                    if(inDegree[dependency] == 0) {
                        queue.offer(dependency);
                    }
                }
            }
        }

        for (int degree : inDegree) {
            if (degree != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseScheduling courseScheduling = new CourseScheduling();
        System.out.println(courseScheduling.canFinish(2, new int[][]{{1,0}}));
        System.out.println(courseScheduling.canFinish(2, new int[][]{{1,0},{0,1}}));
    }
}
