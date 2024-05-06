package amogh;
import java.util.*;
class TensPlaceComp implements Comparator<Integer>
{
	@Override
	public int compare(Integer n1,Integer n2)
	{
		int tp1=(n1%100)/10;
		int tp2=(n2%100)/10;
		
		return Integer.compare(tp1,tp2);
	}
}

public class lab2
{
	public static void main(String []args)
	{
		int min=10,max=99,count=10;
		ArrayList<Integer> rNumbers= new ArrayList<>();
		Random r=new Random();
		for(int i=0;i<count;i++)
		{
			int rNum;
			do
			{
				rNum = r.nextInt((max-min)+1)+min;
			}while (rNum%2!=0||rNum%5!=0);
			
			rNumbers.add(rNum);
		}
		System.out.println("Unsorted Numbers:");
		{
			for(int num :rNumbers)
			{
				System.out.print(num+" ");
			}
			System.out.println();
		}
		rNumbers.sort(new TensPlaceComp());
		System.out.println("Sorted Numbers:");
		{
			for(int num :rNumbers)
			{
				System.out.print(num+" ");
			}
		}
		
		}
		
}


