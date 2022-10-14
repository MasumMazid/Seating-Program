package com.cognixia.seatingProgram;
import java.io.*;
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.*; 
public class SeatingMethods {
	
	
public String[][] CurrentSeats() throws IOException{
	String[][] SeatingGrid= new String[9][9];
	String SeatPath="src\\SeatingChart.csv";
	BufferedReader seatingReader=null;
	String line="";
	try {
		seatingReader=new BufferedReader(new FileReader(SeatPath));
		int y=0;
		while((line=seatingReader.readLine())!=null) {
			String[] row=line.split(",");
			for( int x=0;x<row.length;x++ ) {
				SeatingGrid[x][y]=row[x];
			}
			y++;
		}
		System.out.println("[CURRENT SEATING AVAILABLITY]");
		System.out.println("[O FOR AVAILABLE X FOR BOOKED]");
		System.out.println("");
		System.out.println("______________________________");
		for(int zz=0;zz<y;zz++) {
			
		for(int z=0;z<y;z++) {
			System.out.print("| "+SeatingGrid[z][zz]+" |");
		}
		System.out.println("");
		System.out.println("______________________________");

		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		seatingReader.close();
	}
	
	
	
	return null;
}




public boolean CheckSeating(String a) throws IOException {
	boolean Available = true;
	String[][] SeatingGrid= new String[9][9];
	String SeatPath="src\\SeatingChart.csv";
	BufferedReader seatingReader=null;
	String line="";
	try {
		seatingReader=new BufferedReader(new FileReader(SeatPath));
		int y=0;
		while((line=seatingReader.readLine())!=null) {
			String[] row=line.split(",");
			for( int x=0;x<row.length;x++ ) {
				SeatingGrid[x][y]=row[x];
			}
			y++;
			
		}
		InputChecks seat= new InputChecks();
		int[] convertedSeats= seat.SeatCode(a);
		if(SeatingGrid[convertedSeats[1]][convertedSeats[0]].equals("X")){
			Available=false;	
		}	
}catch (Exception e) {
	e.printStackTrace();
}finally {
	seatingReader.close();
}
	return Available;
}

public void MakeReservation(String reservation) throws IOException {
	String[][] SeatingGrid= new String[9][9];
	String SeatPath="src\\SeatingChart.csv";
	BufferedReader seatingReader=null;
	String line="";
	try {
		seatingReader=new BufferedReader(new FileReader(SeatPath));
		int y=0;
		while((line=seatingReader.readLine())!=null) {
			String[] row=line.split(",");
			for( int x=0;x<row.length;x++ ) {
				SeatingGrid[x][y]=row[x];
			}
			y++;
		}
		
		
		
		InputChecks SetSeat=new InputChecks();
		int[] SeatSetXY=SetSeat.SeatCode(reservation);
		SeatingGrid[SeatSetXY[1]][SeatSetXY[0]]="X";
	
try {
	FileWriter fw= new FileWriter(SeatPath);
	BufferedWriter bw= new BufferedWriter(fw);
	PrintWriter pw= new PrintWriter(bw);
	for(int i = 0; i<6; i++) {
	for(int j = 0; j<6 ; j++){
	pw.print(SeatingGrid[j][i]+",");
}
	pw.println("");
}
	pw.flush();
	pw.close();
	

}catch (Exception e) {
	e.printStackTrace();
}
}finally {
	seatingReader.close();
}
}
public void DeleteReservation(String reservation) throws IOException {
	String[][] SeatingGrid= new String[9][9];
	String SeatPath="src\\SeatingChart.csv";
	BufferedReader seatingReader=null;
	String line="";
	try {
		seatingReader=new BufferedReader(new FileReader(SeatPath));
		int y=0;
		while((line=seatingReader.readLine())!=null) {
			String[] row=line.split(",");
			for( int x=0;x<row.length;x++ ) {
				SeatingGrid[x][y]=row[x];
			}
			y++;
		}
		
		
		
		InputChecks SetSeat=new InputChecks();
		int[] SeatSetXY=SetSeat.SeatCode(reservation);
		SeatingGrid[SeatSetXY[1]][SeatSetXY[0]]="O";
	
try {
	FileWriter fw= new FileWriter(SeatPath);
	BufferedWriter bw= new BufferedWriter(fw);
	PrintWriter pw= new PrintWriter(bw);
	for(int i = 0; i<6; i++) {
	for(int j = 0; j<6 ; j++){
	pw.print(SeatingGrid[j][i]+",");
}
	pw.println("");
}
	pw.flush();
	pw.close();
	

}catch (Exception e) {
	e.printStackTrace();
}
}finally {
	seatingReader.close();
	
}
}
}

