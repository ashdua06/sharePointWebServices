package com.jw.sharepoint.examples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Interview {
	public static void main(String[] args){
		recFunction(5);
	}


public static int recFunction(int n){
	if(n>0){
		recFunction(n-1);
		System.out.println(n);
	}
	
		//System.out.println(0);
		return 0;
}
}