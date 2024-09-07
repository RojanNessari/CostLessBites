// ------------------------------------------------------- 
// Assignment4
//Written by: Rojan Nessari 40255637
// For COMP 248 Section H – Fall 2023
// --------------------------------------------------------

// Class definition for PrePaiCard representing a prepaid card with type, ID, and expiry date
class PrePaiCard {
    // Private fields to store card information
    private String type;
    private long id;
    private int day;
    private int month;

    // Default constructor for PrePaiCard class
    public PrePaiCard() {
    }

    // Parameterized constructor for PrePaiCard class to initialize card information
    public PrePaiCard(String type, long id, int day, int month) {
        this.type = type;
        this.id = id;
        this.day = day;
        this.month = month;
    }

    // Copy constructor for PrePaiCard class to create a copy of another PrePaiCard object
    public PrePaiCard(PrePaiCard other) {
        this.type = other.type;
        this.id = other.id;
        this.day = other.day;
        this.month = other.month;
    }

    // Setter methods for day and month fields
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    // Override equals method to compare two PrePaiCard objects for equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PrePaiCard other = (PrePaiCard) obj;

        return this.id == other.id &&
                this.day == other.day &&
                this.month == other.month &&
                this.type.equals(other.type);
    }

    // Override toString method to create a string representation of PrePaiCard object
    @Override
    public String toString() {
        return String.format("Type: %s, ID: %d, Expiry Date: %d/%d", type, id, day, month);
    }
}
