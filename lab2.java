import java.util.*;
public class lab2
{
    public static void main(String[] args)
    {
        int min = 10;
        int max = 100;
        int count = 10;

        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        while (numbers.size() < count)
        {
            int num = min + r.nextInt(max - min + 1);
            if (num % 2 == 0 && num % 5 == 0)
            {
                numbers.add(num);
            }
        }

        System.out.println("Generated Numbers: " + numbers);

        Collections.sort(numbers, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer n1, Integer n2)
            {
                int t1 = (n1 / 10) % 10;
                int t2 = (n2 / 10) % 10;
                return Integer.compare(t1, t2);
            }
        });

        System.out.println("Sorted Numbers: " + numbers);
    }
}
