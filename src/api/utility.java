package api;

import java.lang.reflect.Field;

import TestingAPI.Name;
import TestingAPI.Person;

public class utility {
	
	static String output = "";
	static String seperator = "-------------------------";
	
	public static void Read(Object obj)
	{
		Field[] fields = null;
		Class reflectClass = obj.getClass();
		String className = splitAndGetLastValue(reflectClass.getName());
		output = "Object of Class \"" + className + "\"\n" + seperator + "\n";
		
		fields = reflectClass.getDeclaredFields();
		
		readClass(fields, 1, obj);
		System.out.println(output);
	}
	
	private static void readClass(Field[] fields, int indentation, Object obj)
	{
		for (Field f : fields){
			output += indent(indentation)+f.getName() + " = ";
			if (isPrimitive(f.getGenericType().toString()))
			{
				try {
					output += f.get(obj) + "\n";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else 
			{
				String className = splitAndGetLastValue(f.getGenericType().toString());
				output += "\n" + indent(indentation+1) + "Object of Class \"" + className + "\"\n" +
						indent(indentation+1) + seperator + "\n";
				Class c = null;
				try {
					c = f.get(obj).getClass();
					readClass(c.getDeclaredFields(), indentation+2, f.get(obj));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static String splitAndGetLastValue(String string)
	{
		return string.split("\\.")[string.split("\\.").length-1];
	}
	
	private static String indent(int n)
	{
		String space="";
		for (int i=0; i<n; i++)
			space+="   ";
		return space;
	}
	
	private static Boolean isPrimitive(String type)
	{
		if (type.split(" ")[0].equals("class"))
		{
			String classes = type.split(" ")[1];
			if (classes.split("\\.")[0].equals("java") && classes.split("\\.")[1].equals("lang")) return true;
			return false;
		}
		return true;
	}
}























