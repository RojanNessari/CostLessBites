
# CostLessBites Catering PoS System

This Java project simulates a Point of Sale (PoS) system for a catering service named CostLessBites, serving the Concordia University community. The system handles meal sales and prepaid card transactions, offering different meal categories and diet options.

## Project Overview

The project consists of three main classes:
1. **Sales**: Tracks meal sales and calculates total sales in the PoS.
2. **PrePaiCard**: Manages customer prepaid cards, including types and expiry dates.
3. **PoS**: Integrates sales and prepaid card functionalities, allowing for operations such as adding/removing prepaid cards and updating sales.

Additionally, a **PoSDemo** class is used as the driver to interact with the system and display menu options to the user.

## Features

- **Meal Categories**: Junior, Teen, Medium, Big, Family, with set prices.
- **Diet Types**: Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan.
- **Prepaid Cards**: Customers can use prepaid cards tied to specific diet types, with an expiry date.
- **Sales Tracking**: Keeps track of different sales categories and computes total sales.
- **Prepaid Card Management**: Adds, removes, and updates prepaid cards in the PoS system.
- **Menu Options**: Offers various operations, such as viewing PoS content, adding sales, and updating prepaid card details.

## Classes and Methods

### Sales Class
- Attributes:
  - Number of sales for each category (Junior, Teen, Medium, Big, Family).
  - Static constants for prices of each category.
- Methods:
  - Constructors: Default, parameterized, and copy constructors.
  - `addSales()`: Increases sales for specified categories.
  - `SalesTotal()`: Returns the total value of sales.
  - `toString()`: Provides a summary of sales.
  - `equals()`: Compares two Sales objects.

### PrePaiCard Class
- Attributes:
  - Type of diet.
  - Customer ID.
  - Expiry day and month.
- Methods:
  - Constructors: Default, parameterized, and copy constructors.
  - Accessor and mutator methods for attributes.
  - `toString()`: Provides a formatted string of the prepaid card details.
  - `equals()`: Compares two PrePaiCard objects.

### PoS Class
- Attributes:
  - Sales and an array of PrePaiCards.
- Methods:
  - Constructors: Default and parameterized constructors.
  - Methods to compare PoS objects by sales value and prepaid card count.
  - Methods to add/remove prepaid cards and update expiry dates.
  - Methods to add sales and calculate the total sales of the PoS.

### PoSDemo Class
This is the driver class that provides a menu-driven interface to interact with the PoS system. The menu includes the following options:
1. Display the sales and prepaid cards of all PoS.
2. View the details of a specific PoS.
3. Compare PoS objects by total sales value or sales category distribution.
4. Add or remove prepaid cards from a PoS.
5. Update the expiry date of a prepaid card.
6. Add sales to a PoS.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or later
- An IDE like IntelliJ IDEA, Eclipse, or any other text editor



### Running the Program
1. Compile the Java files:
   ```bash
   javac *.java
   ```
2. Run the PoSDemo class:
   ```bash
   java PoSDemo
   ```

## Author

- **Rojan Nessari**  
  *Concordia University, COMP 248, Fall 2023*


