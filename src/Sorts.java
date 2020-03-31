// Assignment #: 8
//         Name: Aaron Kampmeier
//    StudentID: 1217750807
//      Lecture: T&Th 10:30
//  Description: Sorts clubs using the specified comparator

import java.util.Arrays;
import java.util.Comparator;

public class Sorts {
	public static void sort(Club[] clubList, int size, Comparator<Club> comparator) {
		//Sorts the clubs in place
		//TODO: - Check this
		Arrays.sort(clubList,0,size,comparator);
	}
}
