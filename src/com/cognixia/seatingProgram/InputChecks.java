package com.cognixia.seatingProgram;

public class InputChecks {
public boolean Checkinput(String MovieChioce) {
	if(MovieChioce.matches("^(a|b|c|d|e)[1-5]$")) {
		return true;
	}else {
		return false;
	}
}
public int[] SeatCode(String SeatCode) {
	int Yseat=Character.getNumericValue(SeatCode.charAt(1));
	int x =0;
	if(SeatCode.charAt(0)=='a'){
		x=1;
	}
	if(SeatCode.charAt(0)=='b'){
		x=2;
	}
	if(SeatCode.charAt(0)=='c'){
		x=3;
	}
	if(SeatCode.charAt(0)=='d'){
		x=4;
	}
	if(SeatCode.charAt(0)=='e'){
		x=5;
	}
	int[] ConvertedSeat= new int[2];
	ConvertedSeat[0]=x;
	ConvertedSeat[1]=Yseat;
	return ConvertedSeat;
}
public boolean NameCheck(String name) {
	if(name.equals(null)) {
		return false;
	}else {
		return true;
	}
}
}
