package com.lcode;

import java.util.HashMap;
import java.util.Map;

public class Occurances {

	public static void main(String[] args) {
		String str="Google";
		count(str);

	}
	
	static void count(String str) {
		Map<Character, Integer> map = new HashMap<>();
		
		char[] chars=  str.toCharArray();
		for(char c: chars) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
		}
		
		for(Map.Entry entry: map.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}

}
