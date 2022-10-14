package com.cognixia.seatingProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class reservation {
	public void deleteRegistration(String name) throws IOException {
		try {
			String[][] reservationlist=new String[2][10];
			String ReservePath="src\\reservation.csv";
			BufferedReader seatingReader=null;
			String line="";
			try {
				seatingReader=new BufferedReader(new FileReader(ReservePath));
				int x=0;
				while((line=seatingReader.readLine())!=null) {
					String[] row=line.split(",");
					reservationlist[0][x]=row[0];
					reservationlist[1][x]=row[1];
					x++;
				}
				
				FileWriter fw1= new FileWriter(ReservePath);
				BufferedWriter bw= new BufferedWriter(fw1);
				PrintWriter pw= new PrintWriter(bw);
				for(int yyy=0;yyy<x+1;yyy++){
					if(reservationlist[1][yyy].equals(name)) {
						yyy++;
					}
					pw.println(reservationlist[0][yyy]+","+reservationlist[1][yyy]);
				}
				pw.flush();
				pw.close();
			}catch(Exception e){
			}finally {
			}
				seatingReader.close();
				
	
	
		
	}catch (Exception e) {
	}finally {
	}
		
	}
	
	
	
	
	public void saveReservation(String name, String seat) throws IOException {
		try {
			String[][] reservationlist=new String[2][10];
			String ReservePath="src\\reservation.csv";
			BufferedReader seatingReader=null;
			String line="";
			try {
				seatingReader=new BufferedReader(new FileReader(ReservePath));
				int x=0;
				while((line=seatingReader.readLine())!=null) {
					String[] row=line.split(",");
					reservationlist[0][x]=row[0];
					reservationlist[1][x]=row[1];
					x++;
				
				}
				reservationlist[0][x]=seat;
				reservationlist[1][x]=name;
				FileWriter fw1= new FileWriter(ReservePath);
				BufferedWriter bw= new BufferedWriter(fw1);
				PrintWriter pw= new PrintWriter(bw);
				for(int yyy=0;yyy<x+1;yyy++){
					pw.println(reservationlist[0][yyy]+","+reservationlist[1][yyy]);
				}
				pw.flush();
				pw.close();
			}catch(Exception e){
			}finally {
			}
				seatingReader.close();
	
	
		
	}catch (Exception e) {
	}finally {
	}
		
	}
		
	
	
	
	
	
	public void ViewList() throws IOException {
		String[][] newlist=new String[2][10];
		String ReservePath="src\\reservation.csv";
		BufferedReader seatingReader=null;
		String line="";
		try {
			seatingReader=new BufferedReader(new FileReader(ReservePath));
			int x=0;
			while((line=seatingReader.readLine())!=null) {
				String[] row=line.split(",");
				newlist[0][x]=row[0];
				newlist[1][x]=row[1];
				x++;
			
			}
			for(int xxx=0;xxx<x;xxx++) {
				System.out.print("Seat: "+newlist[0][xxx]+" Name: "+newlist[1][xxx]);
				System.out.println("");
			}
		
		
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				seatingReader.close();
	}
}
}
