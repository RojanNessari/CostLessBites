// ------------------------------------------------------- 
// Assignment4
//Written by: Rojan Nessari 40255637
// For COMP 248 Section H – Fall 2023
// --------------------------------------------------------
// Class definition for Sales representing a sales record with quantities for different categories and corresponding prices
class Sales {
    // Private fields to store quantities for each category
    private int junior;
    private int teen;
    private int medium;
    private int big;
    private int family;
    
    // Constants representing prices for each category
    private static final int JUNIOR_PRICE = 5;
    private static final int TEEN_PRICE = 10;
    private static final int MEDIUM_PRICE = 12;
    private static final int BIG_PRICE = 15;
    private static final int FAMILY_PRICE = 20;

    // Default constructor for Sales class
    public Sales() {
    }

    // Parameterized constructor for Sales class to initialize quantities for each category
    public Sales(int junior, int teen, int medium, int big, int family) {
        this.junior = junior;
        this.teen = teen;
        this.medium = medium;
        this.big = big;
        this.family = family;
    }

    // Copy constructor for Sales class to create a copy of another Sales object
    public Sales(Sales other) {
        this.junior = other.junior;
        this.teen = other.teen;
        this.medium = other.medium;
        this.big = other.big;
        this.family = other.family;
    }

    // Method to add sales quantities for each category
    public void addSales(int junior, int teen, int medium, int big, int family) {
        this.junior += junior;
        this.teen += teen;
        this.medium += medium;
        this.big += big;
        this.family += family;
    }

    // Method to calculate the total sales amount
    public double SalesTotal() {
        return (this.junior * JUNIOR_PRICE) + (this.teen * TEEN_PRICE) + (this.medium * MEDIUM_PRICE)
                + (this.big * BIG_PRICE) + (this.family * FAMILY_PRICE);
    }

    // Override equals method to compare two Sales objects for equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Sales other = (Sales) obj;

        return this.junior == other.junior &&
                this.teen == other.teen &&
                this.medium == other.medium &&
                this.big == other.big &&
                this.family == other.family;
    }

    // Override toString method to create a string representation of Sales object
    @Override
    public String toString() {
        return String.format("Junior: %d, Teen: %d, Medium: %d, Big: %d, Family: %d",
                junior, teen, medium, big, family);
    }

    // Getter and setter methods for each category
    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }

    public int getTeen() {
        return teen;
    }

    public void setTeen(int teen) {
        this.teen = teen;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    // Getter methods for each category's price
    public int getJuniorPrice() {
        return JUNIOR_PRICE;
    }

    public int getTeenPrice() {
        return TEEN_PRICE;
    }

    public int getMediumPrice() {
        return MEDIUM_PRICE;
    }

    public int getBigPrice() {
        return BIG_PRICE;
    }

    public int getFamilyPrice() {
        return FAMILY_PRICE;
    }
}
