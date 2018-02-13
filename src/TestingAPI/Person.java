package TestingAPI;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	public int age;
	public String id;
	public Name name;
	
	public List<String> pets;
	
	public Person(int a, Name n, String ID)
	{
		age = a;
		name = n;
		id = ID;
		pets = new ArrayList<String>();
	}
	
	public void addPet(String name)
	{
		pets.add(name);
	}
}
