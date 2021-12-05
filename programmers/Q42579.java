import java.util.*;

public class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> genresCountMap = new HashMap<>();
        HashMap<String, int[]> idxGenresMap = new HashMap<>();

        for (int idx = 0; idx < genres.length; idx ++) {
            String genre = genres[idx];
            int genrePlay = plays[idx];

            genresCountMap.put(
                    genre,
                    genresCountMap.getOrDefault(genre, 0) + genrePlay
            );


            if (!idxGenresMap.containsKey(genre)) {
                idxGenresMap.put(genre, new int[10000]);
            }

            idxGenresMap.get(genre)[idx] = genrePlay;

        }

        ArrayList<String> arr = new ArrayList<>(genresCountMap.keySet());
        Collections.sort(arr, (o1, o2) -> (genresCountMap.get(o2).compareTo(genresCountMap.get(o1))));

        answer = new int[4];
        int answerCount = 0;

        for (String genre : arr) {
            int[] genreArray = idxGenresMap.get(genre);

            Integer[] orderByMax = Arrays.stream(genreArray).boxed().toArray(Integer[]::new);
            Arrays.sort(orderByMax, Comparator.reverseOrder());

            for (int idx = 0; idx < 2; idx ++) {
                int genreMax = orderByMax[idx];

                if (genreMax == 0 || answerCount == 4) break;
                for (int findIdx = 0; findIdx < genreArray.length; findIdx++) {
                    if (genreArray[findIdx] == genreMax) {
                        answer[answerCount++] = findIdx;
                        break;
                    }
                }
            }

        }
        return answer;
    }
}
