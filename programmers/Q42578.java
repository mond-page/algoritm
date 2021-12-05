import java.util.HashMap;

public class Q42578 {
    public int solution(String[][] clothes) {
        int result = 1;
        HashMap<String, Integer> clothesHashMap = new HashMap<>();

        for (String[] clothe : clothes) {
                clothesHashMap.put(
                        clothe[1],
                        clothesHashMap.getOrDefault(clothe[1], 0) + 1
                );
        }

        for (Integer value : clothesHashMap.values()) {
            System.out.println(value);
            result *= (value + 1);
        }

        return result -1;
    }
}


