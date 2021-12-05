import java.util.HashMap;

public class Q42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }

        for (String s : completion) {
            if (map.get(s) > 1)
                map.put(s, map.get(s) - 1);
            else
                map.remove(s);
        }

        return map.keySet().stream().findFirst().get();
    }
}
