package com.vishal.interviews.netflix.medium;

public class HashMap<K, V> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static final int BUCKET_SIZE = 16;
	Entry<K, V>[] entries;

	HashMap() {
		entries = new Entry[BUCKET_SIZE];
	}

	V get(K key) {
		int b = key.hashCode() % BUCKET_SIZE;
		Entry<K, V> t = entries[b];
		if (t == null) {
			return null;
		}

		while (t != null) {
			if (t.key.equals(key)) {
				return t.val;
			}
			t = t.next;
		}

		return null;
	}

	void put(K key, V val) {
		int b = key.hashCode() % BUCKET_SIZE;
		Entry<K, V> entry = new Entry<>(key, val);

		if (entries[b] == null) {
			entries[b] = entry;
			return;
		}

		Entry<K, V> t = entries[b];
		Entry<K, V> p = null;
		while (t != null) {
			if (t.key.equals(key)) {
				t.val = val;
				return;
			}
			p = t;
			t = t.next;
		}

		p.next = entry;

	}

}

class Entry<K, V> {
	K key;
	V val;

	Entry(K key, V val) {
		this.key = key;
		this.val = val;
	}

	Entry<K, V> next;
}
