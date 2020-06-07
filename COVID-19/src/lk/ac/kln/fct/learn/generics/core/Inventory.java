package lk.ac.kln.fct.learn.generics.core;

import java.util.ArrayList;

public class Inventory<K,T> {
	private ArrayList<Entry<K,T>> entries = new ArrayList<>();
	
	public void addToInventory(Entry<K,T> entry) {
		for(Entry<K,T> e: entries) {
		    if(e.getKey().equals(entry.getKey())) {
		    	throw new IllegalArgumentException("Duplicate key found");
			}
		}
		entries.add(entry);
	}

	public ArrayList<Entry<K,T>> getInventory() {
		return entries;
	}	

	public Entry<K,T> getEntryByIndex(int index) {
		return entries.get(index);
	}	

	public Entry<K,T> getEntryByKey(K key) {
		for(Entry<K,T> e:entries)if(e.getKey().equals(key))return e;
		return null;
	}
	
	public int getEntryIndex(Entry<K,T> entry) {
		return entries.indexOf(entry);
	}
	
	public boolean removeByEntry(Entry<K,T> entry) {
		return entries.remove(entry);
	}

	public Entry<K,T> removeByIndex(int index) {
		return entries.remove(index);
	}
	
	public void removeAll() {
		entries.clear();
	}
}
