package com.leetcode.lfu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache {

	HashMap<Integer, Integer> map;
	PriorityQueue<Frequency> frequencies = new PriorityQueue<>();

	Comparator<Frequency> comparator = new Comparator<LFUCache.Frequency>() {

		@Override
		public int compare(Frequency o1, Frequency o2) {
			return o1.frequency - o2.frequency;
		}

	};

	class Frequency {
		int key;
		int frequency;
	}

	int capacity;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
	}

	public int get(int key) {
		return (int) map.get(key);
	}

	public void set(int key, int value) {
		if (map.size() > capacity) {
			removeLFU();
		}
		map.put(key, value);
	}

	private void removeLFU() {
		map.remove(frequencies.poll());
	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.set(key,value);
 */