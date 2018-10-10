//			Churong Zhang
//			CS 3345.004. Data structures and algorithm analysis
//			Fall 2018
//			Intensive Track Assignment 2.2
//			Sept 16, 2018


package cxz173430;



import java.util.List;
import java.util.LinkedList;
import java.util.*;

public class SetThery {

	public static<T extends Comparable<? super T>>
    void intersect(List<T> l1, List<T> l2, List<T> outList) {
       // Return elements common to l1 and l2, in sorted order.
       // outList is an empty list created by the calling
       // program and passed as a parameter.
       // Function should be efficient whether the List is
       // implemented using ArrayList or LinkedList.
       // Do not use HashSet/Map or TreeSet/Map or other complex
       // data structures.
		
		Iterator<T> list1 = l1.iterator();
		Iterator<T> list2 = l2.iterator();
		boolean lastElementIsList1 = true;
		boolean lastElementIsList2 = true;
		outList.clear();
		if(list1.hasNext() && list2.hasNext())
			{
				T value1 = list1.next();
				T value2 = list2.next();
			
				while(list1.hasNext() || list2.hasNext())
				{
					if(list1.hasNext() && list2.hasNext())
					{
						if(value1.compareTo(value2) == 0)
						{
							outList.add(value1);
							value1 = list1.next();
							value2 = list2.next();
							
						}
						else if(value1.compareTo(value2) < 0)
						{
							value1 = list1.next();
						}
						else
						{
							value2 = list2.next();
						}
					}
					else if(list1.hasNext())
					{
						if(lastElementIsList2)
						{
							if(value1.compareTo(value2) == 0)
							{
								outList.add(value1);
								lastElementIsList2 = false;
							}
							else if(value1.compareTo(value2) < 0)
							{
								value1 = list1.next();
							}
							else
							{
								lastElementIsList2 = false;
								break;
							}
						}
						else
						{
							break;
						}
					}
					else
					{
						if(lastElementIsList1)
						{
							if(value1.compareTo(value2) == 0)
							{
								outList.add(value1);
								lastElementIsList1 = false;
							}
							else if(value1.compareTo(value2) > 0)
							{
								value2 = list2.next();
							}
							else
							{
								lastElementIsList1 = false;
								break;
							}
						}
						else
						{
							break;
						}
					}
				}
				if(lastElementIsList1 && lastElementIsList2 && value1.compareTo(value2) == 0)
				{
					outList.add(value1);
				}
			}
		
    }

public static<T extends Comparable<? super T>>
    void union(List<T> l1, List<T> l2, List<T> outList) {
       // Return the union of l1 and l2, in sorted order.
       // Output is a set, so it should have no duplicates.
		
		Iterator<T> list1 = l1.iterator();
		Iterator<T> list2 = l2.iterator();
		boolean lastElementIsList1 = true;
		boolean lastElementIsList2 = true;
		outList.clear();
		if(list1.hasNext() && list2.hasNext())
			{
				T value1 = list1.next();
				T value2 = list2.next();
				while(list1.hasNext() || list2.hasNext())
				{
					if(list1.hasNext() && list2.hasNext())
					{
						if(value1.compareTo(value2) == 0)
						{
							
							outList.add(value1);
							value1 = list1.next();
							value2 = list2.next();
							
						}
						else if(value1.compareTo(value2) < 0)
						{
							outList.add(value1);
							
							value1 = list1.next();
						}
						else
						{
							
							outList.add(value2);
							value2 = list2.next();
						}
					}
					else if(list1.hasNext())
					{
						if(lastElementIsList2)
						{
							if(value1.compareTo(value2) < 0)
							{
								outList.add(value1);
								value1 = list1.next();
							}
							else if (value1.compareTo(value2) > 0)
							{
								outList.add(value2);
								lastElementIsList2 = false;
							}
							else
							{
								outList.add(value1);
								value1 = list1.next();
								lastElementIsList2 = false;
							}
						}
						else
						{
							outList.add(value1);
							value1 = list1.next();
						}
						
					}
					else
					{
						if(lastElementIsList1)
						{
							if(value1.compareTo(value2) < 0)
							{
								outList.add(value1);
								lastElementIsList1 = false;
							}
							else if(value1.compareTo(value2) > 0)
							{
								outList.add(value2);
								value2 = list2.next();
							}
							else
							{
								outList.add(value2);
								value2 = list2.next();
								lastElementIsList1 = false;
							}
						
						}
						else
						{
							outList.add(value2);
							value2 = list2.next();
						}
					}	
				}
				if(lastElementIsList1 && lastElementIsList2)
				{
					if(value1.compareTo(value2) == 0)
					{
						outList.add(value1);
					}
					else if(value1.compareTo(value2) < 0)
					{
						outList.add(value1);
						outList.add(value2);
					}
					else
					{
						outList.add(value2);
						outList.add(value1);
					}
				}
				else if(lastElementIsList1)
				{
					outList.add(value1);
				}
				else 
				{
					outList.add(value2);
				}
			}
    }

public static<T extends Comparable<? super T>>
    void difference(List<T> l1, List<T> l2, List<T> outList) {
       // Return l1 - l2 (i.e, items in l1 that are not in l2), in sorted order.
       // Output is a set, so it should have no duplicates.
	Iterator<T> list1 = l1.iterator();
	Iterator<T> list2 = l2.iterator();
	
	boolean lastElementIsList1 = true;
	boolean lastElementIsList2 = true;
	outList.clear();
	if(list1.hasNext() && list2.hasNext())
		{
			T value1 = list1.next();
			T value2 = list2.next();

			while(list1.hasNext() || list2.hasNext())
			{
				if(list1.hasNext() && list2.hasNext())
				{
					if(value1.compareTo(value2) == 0)
					{
						value1 = list1.next();
						value2 = list2.next();
						
					}
					else if(value1.compareTo(value2) < 0)
					{
							outList.add(value1);
							value1 = list1.next();
					}
					else
					{
							//outList.add(value2);
							value2 = list2.next();
					}
				}
				else if(list1.hasNext())
				{
					if(lastElementIsList2)
					{
						if(value1.compareTo(value2) ==0)
						{
							lastElementIsList2 = false;
							
							value1 = list1.next();
						}
						else if(value1.compareTo(value2) < 0)
						{
							outList.add(value1);

							value1 = list1.next();
						}
						else
						{
							lastElementIsList2 = false;
						}
						
					}
					else
					{
						outList.add(value1);
						value1 = list1.next();
					}
				}
				else
				{
					if(lastElementIsList1)
					{
						if(value1.compareTo(value2) ==0)
						{
							lastElementIsList1 = false;
							break;
						}
						else if(value1.compareTo(value2) < 0)
						{
							outList.add(value1);
							lastElementIsList1 = false;
							break;
							
						}
						else
						{
							value2 = list2.next();
						}
						
					}
					
				}

			}
			if(lastElementIsList1)
			{
				if(lastElementIsList2)
				{
					if(value1.compareTo(value2) != 0)
					{
						outList.add(value1);
						
					}
				}
				else
				{
					outList.add(value1);
				}
			}
			
			
		}
    }


	public static void main(String[] args) {
		
			List<Integer> l1 = new LinkedList<>();
			List<Integer> l2 = new LinkedList<>();
			
			// test with random values 
			int size = 30;
			for(int a = 0; a < size; a++)
			{
				int temp2 = (int)(Math.random() * size);
				int temp1 = (int)(Math.random() * size);
				
				if(!l1.contains(temp1))
					l1.add(temp1);
				if(!l2.contains(temp2))
					l2.add(temp2);
				
			}
			l1.sort(null);
			l2.sort(null);
			
			
			/*
			l1.add(0);
			l1.add(2);
			l1.add(3);
			l1.add(4);
			l1.add(5);
			l1.add(6);
			l1.add(7);
			l1.add(9);
			l1.add(11);
			l1.add(14);
			l1.add(16);
			l1.add(17);
			l1.add(20);
			l1.add(23);
			
			l2.add(0);
			l2.add(2);
			l2.add(3);
			l2.add(8);
			l2.add(9);
			l2.add(10);
			l2.add(12);
			l2.add(14);
			l2.add(15);
			l2.add(16);
			l2.add(17);
			l2.add(19);
			l2.add(20);
			l2.add(21);
			l2.add(22);
			l2.add(23);
			l2.add(24);
			
			*/
			
			List<Integer> output = new LinkedList<>();
			System.out.println(l1);
			System.out.println(l2);
			
			System.out.println("The intersect of the twos are: ");
			intersect(l1,l2,output);
			System.out.println(output);
			
			System.out.println("The union of the twos are: ");
			union(l2,l1,output);
			System.out.println(output);
			
			System.out.println("The difference of the list1 - list2 are: ");
			difference(l1,l2,output);
			System.out.println(output);
		
	}

}
