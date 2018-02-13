/*
 * Home Assignment made for Portal Drushim
 * Created by Dima Brusilovsky
 * 
 */

package api;

import TestingAPI.Name;
import TestingAPI.Person;

public class MainAPI {

	public static void main(String[] args) {
		
		Name n = new Name("Bill", "Gates");
		
		Person p = new Person(55, n, "11234");
		p.addPet("Night");
		p.addPet("Mookie");
		
		utility.Read(p);
	}

}
