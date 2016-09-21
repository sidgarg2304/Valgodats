package com.vishal.datastructures.map;

public class HashMap<T, P> {

	Entry<T, P>[] buckets;

	@SuppressWarnings("unchecked")
	public HashMap() {
		buckets = new Entry[10];
	}

	public void put(T key, P value) {
		int hashCode = key.hashCode();
		hashCode = hashCode % 10;
		Entry<T, P> newEntry = new Entry<T, P>(key, value);

		if (buckets[hashCode] == null) {
			buckets[hashCode] = newEntry;
			return;
		} else {
			Entry<T, P> curBucketStartElement = buckets[hashCode];
			Entry<T, P> t = curBucketStartElement;
			while (t.next != null) {
				t = t.next;
			}
			t.next = newEntry;
		}
	}

	public P get(T key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % 10;

		Entry<T, P> curBucketStartElement = buckets[hashCode];
		Entry<T, P> t = curBucketStartElement;
		while (t != null) {
			if (t.getKey().equals(key)) {
				return t.getValue();
			}
			t = t.next;
		}

		return null;
	}

}

class Entry<T, P> {
	T key;
	P value;
	Entry<T, P> next;

	Entry(T key, P value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public P getValue() {
		return value;
	}

	public void setValue(P value) {
		this.value = value;
	}

	public Entry<T, P> getNext() {
		return next;
	}

	public void setNext(Entry<T, P> next) {
		this.next = next;
	}
}
