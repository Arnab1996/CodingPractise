import java.util.Deque;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LRU {

	private Deque<Integer> dQ;
	private TreeMap<Integer, String> map;

	static int MAX_CAPACITY = 8;

	public LRU() {
		dQ = new LinkedList<>();
		map = new TreeMap<>();
	}

	public void addCache(int page, String value) {
		if (!map.containsKey(page)) {
			if (dQ.size() == MAX_CAPACITY) {
				int last = dQ.removeLast();
				map.remove(last);
			}
		}
		
		dQ.push(page);
		map.put(page, value);
	}

	public String fetchCache(int pageKey) {
		if (map.containsKey(pageKey)) {
			return map.get(pageKey);
		}
		return "";
	}

	public void updateCache(int pageKey, String value) {
		if (map.containsKey(pageKey)) {
			map.put(pageKey, value);
		} else {
			System.out.println("Key unavailable");
		}
	}

	public void deleteCache(int pageKey) {
		if (dQ.contains(pageKey)) {
			dQ.remove(pageKey);
		}
		if (map.containsKey(pageKey)) {
			map.remove(pageKey);
		}
	}

	public static void main(String[] args) {
		LRU lru = new LRU();
		lru.addCache(1, "a");
		lru.addCache(2, "b");
		lru.addCache(3, "c");
		lru.addCache(4, "d");
		lru.addCache(5, "e");
		lru.addCache(6, "f");
		lru.addCache(7, "g");
		lru.addCache(8, "h");
		lru.addCache(9, "i");
		lru.addCache(10, "j");
		lru.addCache(11, "k");
		lru.addCache(12, "l");

		System.out.println(lru.fetchCache(8));
		lru.updateCache(11, "z");

		for (Entry<Integer, String> ele : lru.map.entrySet()) {
			System.out.println(ele);
		}
	}

}
