// ------------------------------------------------------- 
// Assignment4
//Written by: Rojan Nessari 40255637
// For COMP 248 Section H – Fall 2023
// --------------------------------------------------------
// This PoSDemo class is the driver for the three previous classes, but mainly takes methods from the PoS class, which takes methods from the two other classes, for the user to be able to interact with the three other classes.
// This class creates PoS and PrePaiCard objects, and displays a menu for the user to interact with to edit pre paid cards and sales in PoS's.
import java.util.Scanner;

//Class definition for PoSDemo representing a demo of the Concordia CostLessBites Catering Sales Counter Application
public class PoSDemo {
	// Method to print the menu options
	public static void printMenu() {
		// Display the menu options for the user
		System.out.println("| What would you like to do?");
		System.out.println("| 1  >> See the content of all PoSs");
		System.out.println("| 2  >> See the content of one PoS");
		System.out.println("| 3  >> List PoSs with the same $ amount of sales");
		System.out.println("| 4  >> List PoSs with the same number of Sales categories");
		System.out.println("| 5  >> List PoSs with the same $ of Sales and the same number of prepaid cards");
		System.out.println("| 6  >> Add a PrePaiCard to an existing PoS");
		System.out.println("| 7  >> Remove an existing prepaid card from a PoS");
		System.out.println("| 8  >> Update the expiry date of an existing Prepaid Card");
		System.out.println("| 9  >> Add Sales to a PoS");
		System.out.println("| 0  >> To quit");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	// Method to validate and get a valid PoS number from the user
	public static int whichPoS() {
		Scanner keyIn = new Scanner(System.in);
		int num = keyIn.nextInt();

		 // Validate the entered PoS number
		while (num < 0 || num > 4) {
			System.out.println("Sorry but there is no PoS number " + num);
			System.out.print(" --> Try again: (Enter Number 0 to 4): ");
			num = keyIn.nextInt();
		}

		return num;
	}

	 // Main method representing the entry point of the application
	public static void main(String[] args) {

		 // Display welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("| Welcome to Concordia CostLessBites Catering Sales Counter Application         |");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		int choice;

		 // Initialize variables and objects for PoS, Sales, and PrePaiCard
		Sales sales1 = new Sales(2, 1, 0, 4, 1);
		Sales sales2 = new Sales(sales1);
		Sales sales3 = new Sales(0, 1, 5, 2, 0);
		Sales sales4 = new Sales(3, 2, 4, 1, 2);
		Sales sales5 = new Sales(sales4);

		PrePaiCard prePaidCard1 = new PrePaiCard("Vegetarian", 40825164, 25, 12);
		PrePaiCard prePaidCard2 = new PrePaiCard("Carnivore", 21703195, 3, 12);
		PrePaiCard prePaidCard3 = new PrePaiCard("Vigan", 40825164, 7, 12);
		PrePaiCard prePaidCard4 = new PrePaiCard("Vegetarian", 21596387, 24, 8);
		PrePaiCard prePaidCard5 = new PrePaiCard("Pescatarian", 95432806, 1, 6);
		PrePaiCard prePaidCard6 = new PrePaiCard("Halal", 42087913, 18, 12);
		PrePaiCard prePaidCard7 = new PrePaiCard("Kosher", 40735421, 5, 4);

		PrePaiCard[] cards1 = { prePaidCard1, prePaidCard2 };
		PrePaiCard[] cards2 = { prePaidCard3, prePaidCard4 };
		PrePaiCard[] cards3 = { prePaidCard5, prePaidCard6, prePaidCard7 };
		PrePaiCard[] cards4 = {};

		
		PoS pos1 = new PoS(sales1, cards1);
		PoS pos2 = new PoS(sales2, cards1);
		PoS pos3 = new PoS(sales3, cards2);
		PoS pos4 = new PoS(sales4, cards2);
		PoS pos5 = new PoS(sales5, cards4);
		// Create an array of PoS objects
		PoS[] poSs = { pos1, pos2, pos3, pos4, pos5 };

		int numOfPoS = 5;

		// Initialize a Scanner object for user input
		Scanner keyboard = new Scanner(System.in);

		do {
			// Display the menu options
			printMenu();
			System.out.print("\nPlease enter your choice and press <Enter>:");

			choice = keyboard.nextInt();
			 // Validate user choice
			while (choice < 0 || choice > 9) {
				System.out.println("Sorry that is not a valid choice. Try again.");
				printMenu();
				System.out.print("\nPlease enter your choice and press <Enter>:");
				choice = keyboard.nextInt();
			}

			int num;

			// Switch statement to handle user choices
			switch (choice) {
			// Display the content of each PoS
			case 1:
				System.out.println("Content of each PoS:");
				System.out.println("---------------------");

				for (int i = 0; i < numOfPoS; i++) {
					System.out.println("PoS #" + i + ":\n" + poSs[i].toString());
				}
				break;

			case 2:
				System.out.print("Which PoS do you want to see the content of? (Enter number 0 to 4): ");

				num = whichPoS();

				System.out.println(poSs[num].toString());
				break;

			case 3:
				System.out.println("List of PoSs with the same total $ Sales:\n");

				for (int i = 0; i < numOfPoS; i++) {

					for (int j = i; j < numOfPoS; j++) {

						if (i == j)
							continue;
						else {
							if (poSs[i].getTotalSales() == poSs[j].getTotalSales())
								System.out.println("	PoSs " + i + " and " + j + " both have "
										+ poSs[i].getTotalSales() + " in sales.");
						}
					}
				}
				System.out.println();
				break;

			case 4:
				System.out.println("List of PoSs with the same Sales categories:\n");

				for (int i = 0; i < numOfPoS; i++) {
					for (int j = i; j < numOfPoS; j++) {
						if (i == j)
							continue;
						else {

							if (poSs[i].isEqualSalesCategories(poSs[j]))
								System.out.println(
										"	PoSs " + i + " and " + j + " both have " + poSs[i].salesBreakdown());
						}
					}
				}
				System.out.println();
				break;

			case 5:
				System.out.println("List of PoSs with the same $ amount of sales and same number of PrePaiCards :\n");

				for (int i = 0; i < numOfPoS; i++) {
					for (int j = i; j < numOfPoS; j++) {
						if (i == j)
							continue;
						else

						if (poSs[i].equals(poSs[j]))
							System.out
									.println("	PoSs " + i + " and " + j + " both have " + poSs[i].getNumPrepaidCards()
											+ " prepaid cards and $" + poSs[i].getTotalSales() + " in sales.");
					}
				}
				System.out.println();
				break;

			case 6:
				System.out.print("Which PoS do you want to add a PrePaiCard to? (Enter number 0 to 4): ");

				num = whichPoS();

				System.out.println("Please enter the following information so that we may complete the PrePaiCard-");
				System.out
						.println(" --> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan):");
				String newType = keyboard.next();
				System.out.print(" --> Id of the prepaid card owner: ");
				long newId = keyboard.nextLong();
				System.out.print(" --> Expiry day number and month (separate by a space): ");
				int newDay = keyboard.nextInt();
				int newMonth = keyboard.nextInt();

				PrePaiCard newCard = new PrePaiCard(newType, newId, newDay, newMonth);

				poSs[num].addPrePaiCard(newCard);
				System.out.println("You now have " + poSs[num].getNumPrepaidCards() + " PrePaiCard(s)");
				break;

			case 7:
				System.out.print("Which PoS do you want to remove a PrePaiCard from? (Enter number 0 to 4): ");

				num = whichPoS();

				if (poSs[num].getNumPrepaidCards() == 0)
					System.out.println("Sorry that PoS has no PrePaiCards");

				else {

					System.out.println("Enter a number from 0 to " + (poSs[num].getNumPrepaidCards() - 1));
					int remove = keyboard.nextInt();

					if (poSs[num].removePrePaiCard(remove))
						System.out.println("PrePaiCard was removed successfully\n");
					else
						System.out.println("PrePaiCard was not removed successfully\n");
				}
				break;

			case 8:
				System.out.print("Which PoS do you want to update an PrePaiCard from? (Enter number 0 to 4): ");

				num = whichPoS();

				while (poSs[num].getNumPrepaidCards() == 0)
					System.out.println("Sorry that PoS has no PrePaiCards");

				System.out.println("Which PrePaiCard do you want to update? (Enter number 0 to "
						+ (poSs[num].getNumPrepaidCards() - 1) + "):");
				int card = keyboard.nextInt();
				System.out.print(" --> Enter new expiry date day number and month (separate by a space): ");
				int newDay1 = keyboard.nextInt();
				int newMonth1 = keyboard.nextInt();

				poSs[num].updateCardExpiry(poSs[num].getPrepaidCards()[card], newDay1, newMonth1);
				System.out.println("Expiry date updated");
				break;

			case 9:
				System.out.println("Which PoS do you want to add Sales to? (Enter a number from 0 to 4): ");

				num = whichPoS();

				System.out.println("How many junior, teen, medium, big, and family meals do you want to add?");
				System.out.print("(Enter 5 numbers separated by a space): ");
				int j = keyboard.nextInt();
				int t = keyboard.nextInt();
				int m = keyboard.nextInt();
				int b = keyboard.nextInt();
				int f = keyboard.nextInt();

				poSs[num].addMealsSales(j, t, m, b, f);
				System.out.println("You now have $" + poSs[num].getTotalSales() + "\n");
				break;
			}

		} while (choice != 0);  // Quit the application

		 // Close the Scanner object
		keyboard.close();
		System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
	}
}
