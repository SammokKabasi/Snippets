package com.leetcode.lru;

import java.util.HashMap;

public class LRUCache {

	HashMap<Integer, CacheObject> map = new HashMap<>();

	Integer front;
	Integer back;

	class CacheObject {
		Integer previous;
		Integer next;
		Integer value;

		public CacheObject(Integer previous, Integer next, Integer value) {
			super();
			this.previous = previous;
			this.next = next;
			this.value = value;
		}

		public Integer getPrevious() {
			return previous;
		}

		public Integer getNext() {
			return next;
		}

		public Integer getValue() {
			return value;
		}

		public void setPrevious(Integer previous) {
			this.previous = previous;
		}

		public void setNext(Integer next) {
			this.next = next;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		@Override
		public String toString() {

			return value + "," + previous + "," + next;
		}

	}

	int capacity;

	public LRUCache(int capacity) {
		System.out.println("CAPACITY -> " + capacity);
		this.capacity = capacity;
		map = new HashMap<>(capacity);
	}

	public int get(int key) {
		System.out.print("GET " + key);
		if (map.get(key) == null) {
			System.out.println("Value -1");
			return -1;
		} else {

			// swap key with front value
			if (key != front) {
				int tempFrontPrevious = map.get(front).getPrevious();
				map.get(front).setPrevious(map.get(key).getPrevious());
				map.get(front).setNext(map.get(key).getNext());
				map.get(key).setPrevious(tempFrontPrevious);
				map.get(key).setNext(null);
				if (key == back) {
					int temp = front;
					front = back;
					back = temp;
				} else {
					front = key;
				}
			}

			System.out.println("->" + map.get(key).value);
			System.out.println(display());
			return (int) map.get(key).getValue();
		}
	}

	public void set(int key, int value) {
		if (!map.containsKey(key) && map.size() + 1 > capacity) { // have to
																	// delete
																	// something
			// throw new RuntimeException("hashmap capacity exceeded!");
			// delete back node
			if (map.size() == 1) {
				map.remove(back);
				front = null;
				back = null;
			} else {
				int tempForDelete = back;
				map.get(map.get(back).getNext()).setPrevious(null);
				back = map.get(back).getNext();
				map.remove(tempForDelete);
			}
		}
		if (back == null) { // map is empty
			back = key;
			front = key;
			map.put(key, new CacheObject(null, null, value));
		} else if (map.containsKey(key)) {
			// move the gotten key to the front

			// key's new previous -> front's previous
			// key's new next -> null
			// front = key
			// previous key's next->key's next
			// next key's previous ->key's previous

			if (key == back) {

				if (map.size() == 1) {
					map.put(key, new CacheObject(null, null, value));
					front = key;
					back = key;
				} else {
					map.get(map.get(key).getNext()).setPrevious(null);
					back = map.get(key).getNext();
					map.remove(key);
					map.put(key, new CacheObject(front, null, value));
					map.get(map.get(key).getPrevious()).setNext(key);
					front = key;
				}
			} else if (key == front) {
				map.put(key, new CacheObject(map.get(key).getPrevious(), null, value));
			} else {// key is in the middle

				Integer oldKeyPrevious = map.get(key).getPrevious();
				Integer oldKeyNext = map.get(key).getNext();

				map.get(oldKeyPrevious).setNext(map.get(key).getNext());
				map.get(oldKeyNext).setPrevious(map.get(key).getPrevious());
				map.remove(key);
				map.put(key, new CacheObject(front, null, value));
				map.get(front).setNext(key);
				front = key;
			}

		} else { // map does not contain key
			map.put(key, new CacheObject(front, null, value));
			map.get(front).setNext(key);
			front = key;
		}

		System.out.println("SET " + key + "->" + value + "/ \n" + display());
	}

	private String display() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(("Front : " + front + ", Back : " + back + "\n"));
		for (Integer key : map.keySet()) {
			buffer.append(key + "-> " + map.get(key).getValue() + "," + map.get(key).getPrevious() + "," + map.get(key).getNext() + "\n");
		}
		buffer.append("=======");
		return buffer.toString();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2, 1);
		cache.get(2);
		cache.set(4, 1);
	}

}
