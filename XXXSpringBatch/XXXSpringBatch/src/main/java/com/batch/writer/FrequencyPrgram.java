package com.batch.writer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FrequencyPrgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> elist = Arrays.asList(22,44,22,5,6,12,18) ;
		
		List<String> slist = Arrays.asList("abc","abc","xyz","aqssdcfv","tyrew","abc") ;
		
		System.out.println(Collections.frequency(elist, 22) ) ;
		
		int i =0 ;
		while(i < elist.size()) {
			
			System.out.println("Frequency of " + elist.get(i) + "--is--" + 
			Collections.frequency(elist, elist.get(i)));
			
			i++ ;
			
		}
		int j =0 ;
		
		
		HashMap<String,Integer> map = new HashMap<>() ;
		while(j < slist.size()) {
			
			map.put(slist.get(j), Collections.frequency(slist, slist.get(j))) ;
			
			Collections.frequency(slist, slist.get(j)) ;
			
//			System.out.println("Frequency of " + slist.get(j) + "--is--" + 
//					Collections.frequency(slist, slist.get(j)));
					
			
			
			
			j++ ;
		}
		System.out.println(map);
		
		

	}

}
