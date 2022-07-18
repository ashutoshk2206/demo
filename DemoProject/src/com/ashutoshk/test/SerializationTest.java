package com.ashutoshk.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import com.ashutoshk.bean.Person;

public class SerializationTest {

	public static void main(String[] args) {
		
		//deserialize();
//		Person object = new Person("ashutosh", "kumar"); 
//		object.setAge(21);
//        String filename = "/Users/ashutoshk/Downloads/file.txt"; 
//        
//		try
//        {    
//            //Saving of object in a file 
//            FileOutputStream file = new FileOutputStream(filename); 
//            ObjectOutputStream out = new ObjectOutputStream(file); 
//              
//            // Method for serialization of object 
//            out.writeObject(object); 
//              
//            out.close(); 
//            file.close(); 
//              
//            System.out.println("Object has been serialized"); 
//  
//        } 
//          
//        catch(IOException ex) 
//        { 
//            System.out.println("IOException is caught"); 
//        } 

	}

	private static void deserialize() {
		Person object1 = null; 
		String filename = "/Users/ashutoshk/Downloads/file.txt"; 
		  
        // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            object1 = (Person)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
            System.out.println("a = " + object1.getFirstName()); 
            System.out.println("b = " + object1.getLastName()); 
            //System.out.println("c = " + object1.getAge()); 
            System.out.println("d = " + object1.getGender()); 
        } 
          
        catch(IOException ex) 
        { 
        	ex.printStackTrace();
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
	}
}
