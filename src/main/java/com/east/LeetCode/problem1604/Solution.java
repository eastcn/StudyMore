package com.east.LeetCode.problem1604;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Function:
 *
 * @author taihua
 * @date 2023/2/7
 */
public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> nameMap = new HashMap<>();
        List<String> targetName = new ArrayList<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<String> timeList;
            if (!nameMap.containsKey(keyName[i])) {
                timeList = new ArrayList<>();
            } else {
                timeList = nameMap.get(name);
            }
            timeList.add(time);
            nameMap.put(name, timeList);
        }
        // 遍历map中的每一对entry 并将其对比排序后，使用滑动窗口进行检测符合的丢进targetName
        for (Map.Entry<String, List<String>> entry : nameMap.entrySet()
        ) {
            List<Integer> timeList = entry.getValue().stream().map(ele -> {
                String[] s = ele.split(":");
                return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            }).sorted().collect(Collectors.toList());
            for (int start = 0, end = 2; end < timeList.size(); start++, end++) {
                if (timeList.get(end) - timeList.get(start) <= 60) {
                    targetName.add(entry.getKey());
                    break;
                }
            }
        }
        // 字典序
        Collections.sort(targetName);
//        targetName.sort((o1, o2) -> {
//            char[] chars1 = o1.toCharArray();
//            char[] chars2 = o2.toCharArray();
//            int i = 0;
//            while (i < chars1.length && i < chars2.length) {
//                if (chars1[i] > chars2[i]) {
//                    return 1;
//                } else if (chars1[i] < chars2[i]) {
//                    return -1;
//                } else {
//                    i++;
//                }
//            }
//            if (i == chars1.length) {  //o1到头
//                return -1;
//            }
//            if (i == chars2.length) { //o2到头
//                return 1;
//            }
//            return 0;
//        });
        return targetName;
    }
}
