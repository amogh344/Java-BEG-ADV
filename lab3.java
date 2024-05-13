
import java.util.ArrayList;
import java.util.Iterator;

class Person
{
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return"Person{" + "name=" + name + ",age=" + age +'}';
		}
		
	}
public class CollectionOfCustomClass {
	public static void main(String[] args) {
		ArrayList<Person> peopleList = new ArrayList<>();
		peopleList.add(new Person("PK", 28));
		peopleList.add(new Person("SK", 30));
		peopleList.add(new Person("YK", 35));
		System.out.println("People List:");
		Iterator<Person> iterator=peopleList.iterator();
		while(iterator.hasNext()){
		System.out.println(iterator.next());
		}
	}
}

		
		 
		
	

