package ro.emanuel.laptop.main;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;

import ro.emanuel.laptop.DAO.LaptopDAO;
import ro.emanuel.laptop.pojo.Laptop;

	public class Main {
		
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
			 //afisam 
	        List<Laptop> laptop = LaptopDAO.getLaptop();
	        System.out.println("Lista laptopurilor:");
	        for (Laptop laptop1 : laptop) {
	            System.out.println(laptop1);
	        }
	        System.out.println("=====================");   
	        
	       // creare
	        Laptop newLaptop = new Laptop( "MacBook" ,"pro" , 256);
	        int rowsInserted = LaptopDAO.createLaptop(newLaptop);
	        System.out.println("Leptopul nou a fost creat. Rinduri inserate: " + rowsInserted);
	        
	        System.out.println();
	        System.out.println("====================="); 
	        
	      //afisam dupa id
	        Laptop laptop1 = LaptopDAO.getById(3);
	        System.out.println("Laptop gasit dupa ID: " + laptop1);
	      
	        System.out.println();
	        System.out.println("=====================");

	        
	        //update
	        Laptop laptopToUpdate = new Laptop(4, "Acer", "hpdell" , 24);
	        int rowsUpdated = LaptopDAO.updateLaptop(laptopToUpdate);
	        System.out.println("Rubiks a fost actualizata. Rinduri updatate: " + rowsUpdated);
	        
	        laptop1 = LaptopDAO.getById(3);
	        System.out.println("Lista Laptop actualizata: " + laptop1);
	        
	        System.out.println();
	        System.out.println("=====================");

	       // delete
	        int rowsDeleted = LaptopDAO.deleteLaptop(3);
	        System.out.println("Laptopul a fost stears. Rinduri sterse: " + rowsDeleted);
	        laptop1 = LaptopDAO.getById(3);
	        System.out.println(laptop1);
			
					
		}
		
	}
