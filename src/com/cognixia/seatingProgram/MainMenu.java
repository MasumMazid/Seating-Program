package com.cognixia.seatingProgram;


import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
public void TheMainMenu() throws IOException {
	System.out.println("Welcome to Bob's discount Movie theatre, what would you like to do?");
	Scanner sc=new Scanner(System.in);
	while(true) {
	System.out.println("Enter a number for a selection\n[1]See Seating\n[2]Make Reservation \n[3]Cancel reservation\n[4]See all Reservations\n[5]Exit");
	String MenuChioce =sc.nextLine();
	switch(MenuChioce) {
	case "1":
		SeatingMethods newCustomer = new SeatingMethods();
		newCustomer.CurrentSeats();
		
		break;
	
	case "2":
		InputChecks newInpute= new InputChecks();
		boolean InputChecker=true;
		while(InputChecker==true) {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Enter the seating you would in the form of leter/number \nFor example: a2");
		System.out.println("------------------------------------------------------------------------");
		String SeatChioce=sc.nextLine().toLowerCase();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Enter the name you would like it under");
		System.out.println("------------------------------------------------------------------------");
		String name=sc.nextLine().toLowerCase();
		if(newInpute.Checkinput(SeatChioce)) {
			System.out.println("Checking now");
			SeatingMethods newchecker= new SeatingMethods();
			if(newchecker.CheckSeating(SeatChioce)) {
				System.out.println("Booking Now");
				SeatingMethods reserve=new SeatingMethods();
				reserve.MakeReservation(SeatChioce);
				reservation newUser= new reservation();
				newUser.saveReservation(name,SeatChioce);
				System.out.println("Would you like to make another selection? press x for no or any buttton to make another selection");
				String anotherSelection =sc.nextLine().toLowerCase();
				if(anotherSelection.equals("x")) {
				InputChecker=false;
				}
			}else{
				System.out.println("Sorry that seat is taken");
			};
			
		}else if(SeatChioce.equals("x")){
			InputChecker =false;
		}else {
			System.out.println("Invalid input try again or press X to exit to main menu");
		}
		}
		
		break;
	case "3":
		InputChecks newInputes= new InputChecks();
		boolean InputCheckers=true;
		while(InputCheckers==true) {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Enter the seating you would like to cancel");
		System.out.println("------------------------------------------------------------------------");
		String SeatChioce=sc.nextLine().toLowerCase();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Enter the name it is under");
		System.out.println("------------------------------------------------------------------------");
		String name=sc.nextLine().toLowerCase();
		if(newInputes.Checkinput(SeatChioce)) {
			System.out.println("Checking now");
			SeatingMethods newchecker= new SeatingMethods();
			if(!newchecker.CheckSeating(SeatChioce)) {
				System.out.println("Deleting Now");
				SeatingMethods reserve=new SeatingMethods();
				reserve.DeleteReservation(SeatChioce);
				reservation deleteuser= new reservation();
				deleteuser.deleteRegistration(name);
				InputCheckers=false;
			}else{
				System.out.println("You cannot cancel an open seat");
			};
			
		}else if(SeatChioce.equals("x")){
			InputChecker =false;
		}else {
			System.out.println("Invalid input try again or press X to exit to main menu");
		}
		}
		break;
	case"4":
		reservation printlist= new reservation();
		printlist.ViewList();
	break;
	case"5":
		System.out.println("Exiting Program, Goodbye");
		System.out.println("------------------------");
		System.exit(0);
		break;
	default:
		System.out.println("Invalid selection try again");
	}
	System.out.println("Returning to Main Menu");
	System.out.println("------------------------------------------------------------------------");

}
}
}
