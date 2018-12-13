package com.mycompany.shelter.util;

public class ResolveStringToArray {
	public static String[][] StringToDyadicArray (String str, int num) {
		str = str.replace("[[", "");
		str = str.replace("]]", "");
		String[] str1 = str.split("\\],\\[");
		String[][] str2 = new String[str1.length][num];
		for (int i=0; i<str1.length; i++) {
			str2[i] = str1[i].split(",");
		}
		for (int i=0; i< str2.length; i++) {
			for (int j=0; j<str2[i].length; j++) {
				str2[i][j] = str2[i][j].replace("\"", "");
			}
		}
		return str2;
	}
	
	public static String[] StringToArray (String str) {
		str = str.replace("[", "").replace("]", "").replace("\"", "");
		return str.split(",");
	}
}
