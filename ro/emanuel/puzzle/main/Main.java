	package ro.emanuel.puzzle.main;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;

import ro.emanuel.puzzle.DAO.PuzzleDAO;
import ro.emanuel.puzzle.pojo.Puzzle;


	public class Main {
		
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
			 //afisam 
	        List<Puzzle> puzzle = PuzzleDAO.getPuzzle();
	        System.out.println("Lista puzzle-urilor:");
	        for (Puzzle puzzle1 : puzzle) {
	            System.out.println(puzzle1);
	        }
	        System.out.println("=====================");   
	        
	       // creare
	        Puzzle newPuzzle = new Puzzle( "Educa" ,"carton" , 256);
	        int rowsInserted = PuzzleDAO.createLaptop(newPuzzle);
	        System.out.println("Puzzleul nou a fost creat. Rinduri inserate: " + rowsInserted);
	        
	        System.out.println();
	        System.out.println("====================="); 
	        
	      //afisam dupa id
	        Puzzle puzzle1 = PuzzleDAO.getById(3);
	        System.out.println("Puzzle gasit dupa ID: " + puzzle1);
	      
	        System.out.println();
	        System.out.println("=====================");

	        
	        //update
	        Puzzle puzzleToUpdate = new Puzzle(4, "Clementoni", "lemn" , 24);
	        int rowsUpdated = PuzzleDAO.updatePuzzle(puzzleToUpdate);
	        System.out.println("Puzzle-ul a fost actualizat. Rinduri updatate: " + rowsUpdated);
	        
	        puzzle1 = PuzzleDAO.getById(3);
	        System.out.println("Lista Puzzle actualizata: " + puzzle1);
	        
	        System.out.println();
	        System.out.println("=====================");

	       // delete
	        int rowsDeleted = PuzzleDAO.deletePuzzle(3);
	        System.out.println("Puzzle-ul a fost stears. Rinduri sterse: " + rowsDeleted);
	        puzzle1 = PuzzleDAO.getById(3);
	        System.out.println(puzzle1);
			
					
		}
		
	}
