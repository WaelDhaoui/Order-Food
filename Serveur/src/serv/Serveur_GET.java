package serv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import json.Food;
import json.User;

public class Serveur_GET {
	
	static ArrayList<Food> arrFood;
	
	public static ArrayList<Food> getAllFood() throws SQLException, IOException, ParseException {
		
		ArrayList<Food> fod = new ArrayList<Food>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prj_demo","root","");  
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from food"); 
			
			while(rs.next()) {
				Food food = new Food(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				fod.add(food);
			}
			
			con.close();  
			return fod;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
	}
	
	public static void main(String[] args) throws IOException, SQLException, ParseException { 
			ServerSocket serverSocket = new ServerSocket(401);
			System.out.print("le serveur attend la connexion \n");
			
			Socket socket = serverSocket.accept();
			System.out.println("le client est connecte!");
			
			arrFood = getAllFood();
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osr = new  OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osr,true);
			
			System.out.println(arrFood.get(0).name+","+arrFood.get(0).price+" | "+arrFood.get(1).name+","+arrFood.get(1).price+" | "+arrFood.get(2).name+","+arrFood.get(2).price);
			
			pw.println(arrFood.get(0).name+","+arrFood.get(0).price+" | "+arrFood.get(1).name+","+arrFood.get(1).price+" | "+arrFood.get(2).name+","+arrFood.get(2).price+" | ");
			System.out.println("Select Successfull !!");
			
			
			socket.close();
	}
}
