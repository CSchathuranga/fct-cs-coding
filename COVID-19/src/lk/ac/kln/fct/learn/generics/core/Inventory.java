package lk.ac.kln.fct.learn.generics.core;

import java.util.ArrayList;

public class Inventory<K,V> {
	private ArrayList<Entry<K,V>> entries = new ArrayList<>();
	
	public void addToInventory(Entry<K,V> entry) {
		for(Entry<K,V> e: entries) {
		    if(e.getKey().equals(entry.getKey())) {
		    	throw new IllegalArgumentException("Duplicate key found");
			}
		}
		entries.add(entry);
	}

	public ArrayList<Entry<K,V>> getInventory() {
		return entries;
	}	

	public Entry<K,V> getEntryByIndex(int index) {
		return entries.get(index);
	}	

	public Entry<K,V> getEntryByKey(K key) {
		for(Entry<K,V> e:entries)if(e.getKey().equals(key))return e;
		return null;
	}
	
	public int getEntryIndex(Entry<K,V> entry) {
		return entries.indexOf(entry);
	}
	
	public boolean removeByEntry(Entry<K,V> entry) {
		return entries.remove(entry);
	}

	public Entry<K,V> removeByIndex(int index) {
		return entries.remove(index);
	}
	
	public void removeAll() {
		entries.clear();
	}
}
