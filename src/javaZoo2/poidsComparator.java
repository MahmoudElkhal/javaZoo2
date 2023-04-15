package javaZoo2;

import java.util.Comparator;

public class poidsComparator implements Comparator {
	@Override
	public int compare(Object o1 , Object o2) {
		return (int)(((Animal)o1).getPoids()-((Animal)o2).getPoids());
	}
	
	
}
