package lk.ac.kln.fct.learn.generics.main;

import java.util.ArrayList;

import lk.ac.kln.fct.learn.generics.core.Entry;
import lk.ac.kln.fct.learn.generics.core.Inventory;

public class Main {
	public static void main(String[] args) {
		inventoryTest_01();
		invnetoryTest_02();
		inventoryTest_03();
	}
	
	public static void inventoryTest_01() {

		Inventory<String,String> inventory = new Inventory<>();
		Entry<String,String> entry1 = new Entry<>("Entry1", "100");
		Entry<String,String> entry2 = new Entry<>("Entry2", "101");
		Entry<String,String> entry3 = new Entry<>("Entry3", "102");
		Entry<String,String> entry4 = new Entry<>("Entry4", "103");
		Entry<String,String> entry5 = new Entry<>("Entry5", "104");
		
		inventory.addToInventory(entry1);
		inventory.addToInventory(entry2);
		inventory.addToInventory(entry3);
		inventory.addToInventory(entry4);
		inventory.addToInventory(entry5);
		
		ArrayList<Entry<String,String>> items = inventory.getInventory();
		
		for(Entry<String,String> entry: items) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+" : "+value);
		}
	}
	
	public static void invnetoryTest_02() {
		Inventory<Integer,String> inventory = new Inventory<>();
		Entry<Integer,String> entry1 = new Entry<>(100,"Entry1");
		Entry<Integer,String> entry2 = new Entry<>(101,"Entry2");
		Entry<Integer,String> entry3 = new Entry<>(102,"Entry3");
		
		inventory.addToInventory(entry1);
		inventory.addToInventory(entry2);
		inventory.addToInventory(entry3);
		
		String value1 = inventory.getEntryByKey(101).getValue();
		String value2 = inventory.getEntryByIndex(1).getValue();
		
		System.out.println();
		if(value1.equals(value2)) {
			System.out.println("The entry vlause taken by key and the index are equal.");
		} else {
			System.out.println("The entry vlause taken by key and the index are not equal.");
		}

	}
	
	public static void inventoryTest_03() {
		Inventory<String,Double> inventory = new Inventory<>();
		Entry<String,Double> entry1 = new Entry<>("Entry1", 10.1);
		Entry<String,Double> entry2 = new Entry<>("Entry2", 10.2);
		Entry<String,Double> entry3 = new Entry<>("Entry3", 10.3);
		Entry<String,Double> entry4 = new Entry<>("Entry4", 10.4);
		Entry<String,Double> entry5 = new Entry<>("Entry5", 10.5);
		
		inventory.addToInventory(entry1);
		inventory.addToInventory(entry2);
		inventory.addToInventory(entry3);
		inventory.addToInventory(entry4);
		inventory.addToInventory(entry5);
		
		inventory.removeByEntry(entry2);
		inventory.removeByIndex(3);
		
		System.out.println();
		if(inventory.getInventory().size() == 3) {
			System.out.println("Remove methods are working properly.");
		} else {
			System.out.println("Remove methods are not working properly.");
		}
		
		inventory.removeAll();
		if(inventory.getInventory().size() == 0) {
			System.out.println("Remove all method is working properly.");
		} else {
			System.out.println("Remove all method is not working properly.");
		}
	}

}
