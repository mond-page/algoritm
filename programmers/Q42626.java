package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q42626 {
    public int solution(int[] scoville, int K) {
        int mixedScoville = 0;
        int mixedCount = 0;

        PriorityQueue<Integer> sortedScoville = new PriorityQueue<>();


        for (int i : scoville) {
            sortedScoville.add(i);
        }

        while(true) {
            if (sortedScoville.size() < 2) {
                break;
            }
            int pollScoville = sortedScoville.poll();
            if (pollScoville >= K) {
                break;
            }
            mixedScoville = pollScoville + (sortedScoville.poll() * 2);

            sortedScoville.add(mixedScoville);
            mixedCount++;
        }

        if (mixedScoville <= K) {
            mixedCount = -1;
        }

        return mixedCount;
    }

    // LinkedList로 인해 효율성 제로
    public int failSolution(int[] scoville, int K) {
        int mixedScoville = 0;
        int mixedCount = 0;
        LinkedList<Integer> sortedScoville = new LinkedList<>();

        scoville = Arrays.stream(scoville).sorted().toArray();

        for (int i : scoville) {
            sortedScoville.add(i);
        }

        while(true) {
            if (sortedScoville.size() < 2) {
                break;
            }
            else if (sortedScoville.getFirst() >= K) {
                break;
            }
            mixedScoville = sortedScoville.removeFirst() + (sortedScoville.removeFirst() * 2);

            for (int idx = 0; idx < sortedScoville.size(); idx++) {
                if (mixedScoville <= sortedScoville.get(idx)) {
                    sortedScoville.add(idx, mixedScoville);
                    break;
                } else if (idx == sortedScoville.size()-1) {
                    sortedScoville.add(mixedScoville);
                    break;
                }
            }
            mixedCount++;
        }

        if (mixedScoville <= K) {
            mixedCount = -1;
        }

        return mixedCount;
    }


    public static void main(String[] args) {
        Q42626 q42626 = new Q42626();

        int[] scoville = {1, 2, 3, 4};
        int scovilleNumber = 20;

        System.out.println(q42626.solution(scoville, scovilleNumber));
    }
}
