package Amogh344;
import java.util.ArrayList;
import java.util.Collections;
public class ArrayListDemo 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> numbers= new ArrayList<>();
		numbers.add(5);
		numbers.add(2);
		numbers.add(7);
		numbers.add(3);
		numbers.add(1);
		
		System.out.println("ArrayList before sorting:"+numbers);
		Collections.sort(numbers);
		System.out.println("ArrayList after sorting:"+numbers);
		numbers.remove(2);
		System.out.println("ArrayList after removing element"+numbers);
		
		Integer[] nArray=numbers.toArray(new Integer[0]);
		System.out.print("Array obtained from toArray():");
		for(Integer num:nArray)
		{
			System.out.print(num+" ");
		}

	}

}
//the is new commit 
