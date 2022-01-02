package com.company;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int progress : progresses) {
            queue.add(progress);
        }

        int day = 1;
        int pos = 0;
        int endProcesses = 0;
        while(!queue.isEmpty()) {
            int front = queue.peek();

            if(front + speeds[pos] * day >= 100) {
                queue.poll();
                pos++;
                endProcesses++;
            } else {
                day++;
                if(endProcesses != 0) {
                    result.add(endProcesses);
                }
                endProcesses = 0;
            }
        }
        if(endProcesses != 0) {
            result.add(endProcesses);
        }

        answer = new int[result.size()];
        int index = 0;
        for(int i : result) {
            answer[index] = i;
            index++;
        }

        return answer;
    }
}
