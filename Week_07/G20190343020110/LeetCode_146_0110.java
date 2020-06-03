import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author huangxiong
 * @Date 2020/2/8
 * @Description
 **/
public class LeetCode_146_0110  extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LeetCode_146_0110(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
