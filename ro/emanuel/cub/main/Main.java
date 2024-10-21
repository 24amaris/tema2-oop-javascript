package ro.emanuel.cub.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ro.emanuel.cub.DAO.RubiksCubeDAO;
import ro.emanuel.cub.pojo.RubiksCube;


public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		 //afisam 
        List<RubiksCube> rubiks = RubiksCubeDAO.getRubiksCube();
        System.out.println("Lista cuburilor:");
        for (RubiksCube rubiks1 : rubiks) {
            System.out.println(rubiks1);
        }
        System.out.println("=====================");   
        
       // creare
        RubiksCube newRubiks = new RubiksCube("Cubul nou", 622, 6);
        int rowsInserted = RubiksCubeDAO.createRubiksCube(newRubiks);
        System.out.println("Cubul nou a fost creat. Rinduri inserate: " + rowsInserted);
        
        System.out.println();
        System.out.println("====================="); 
        
      //afisam dupa id
        RubiksCube rubiks1 = RubiksCubeDAO.getById(3);
        System.out.println("Rubiks gasita dupa ID: " + rubiks1);
      
        System.out.println();
        System.out.println("=====================");

        
        //update
        RubiksCube rubiksCubeToUpdate = new RubiksCube(3, "BNR", 128 , 3);
        int rowsUpdated = RubiksCubeDAO.updateRubiksCube(rubiksCubeToUpdate);
        System.out.println("Rubiks a fost actualizata. Rinduri updatate: " + rowsUpdated);
        
        rubiks1 = RubiksCubeDAO.getById(3);
        System.out.println("Rubiks actualizata: " + rubiks1);
        
        System.out.println();
        System.out.println("=====================");

       // delete
        int rowsDeleted = RubiksCubeDAO.deleteRubiks(7);
        System.out.println("Banca a fost stearsa. Rinduri sterse: " + rowsDeleted);
        rubiks1 = RubiksCubeDAO.getById(3);
        System.out.println(rubiks1);
		
				
	}
	


}
