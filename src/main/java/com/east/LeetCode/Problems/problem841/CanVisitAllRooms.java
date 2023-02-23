package com.east.LeetCode.Problems.problem841;

import java.util.List;

/**
 * @Classname CanVisitAllRooms
 * @Description 计算是否能走过每个房间
 * @Date 2020/8/31 8:57 下午
 * @Created by East
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int l = rooms.toArray().length;
        if (l <= 1) {
            return true;
        }
        boolean[] visited = new boolean[l];
        visited[0] = true;
        for (int i = 0; i < l; i++) {
            if (visited[i]) {
                for (Integer key : rooms.get(i)) {
                    visited[key] = true;
                    walk(key, visited, rooms);
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public void walk(int x, boolean[] visited, List<List<Integer>> rooms) {
        for (Integer key : rooms.get(x)) {
            if (key != null && !visited[key]) {
                visited[key] = true;
                walk(key, visited, rooms);
            }
        }
    }
}
