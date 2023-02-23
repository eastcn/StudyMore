package com.east.LeetCode.Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Function: 设计一个验证系统
 *
 * @author taihua
 * @date 2023/2/9
 */
public class problem1797 {

    static class AuthenticationManager {
        Map<String, Integer> tokenMap = new HashMap<>();
        int timeToLive;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            tokenMap.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            int value = tokenMap.getOrDefault(tokenId, 0);
            if (value != 0 && value > currentTime) {
                tokenMap.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (Map.Entry<String, Integer> entry : tokenMap.entrySet()) {
                if ((entry.getValue()) > currentTime) {
                    count += 1;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        AuthenticationManager a = new AuthenticationManager(5);
        a.renew("aaa", 1);
        a.generate("aaa", 2);
        a.countUnexpiredTokens(6);
    }
}