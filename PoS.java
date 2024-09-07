public class PoS {
    private Sales sales;
    private PrePaiCard[] prePaiCards;

    public PoS() {
    }

    public PoS(Sales sales, PrePaiCard[] prePaidCards) {
        this.sales = new Sales(sales);

        if (prePaidCards != null) {
            this.prePaiCards = new PrePaiCard[prePaidCards.length];
            for (int i = 0; i < prePaidCards.length; i++) {
                this.prePaiCards[i] = new PrePaiCard(prePaidCards[i]);
            }
        }
    }

    public boolean isEqualSalesValues(PoS other) {
        return this.sales.SalesTotal() == other.sales.SalesTotal();
    }

    public boolean isEqualSalesCategories(PoS other) {
        return this.sales.equals(other.sales);
    }

    public double getTotalSales() {
        return this.sales.SalesTotal();
    }

    public int getNumPrepaidCards() {
        return (prePaiCards != null) ? prePaiCards.length : 0;
    }

    public int addPrePaiCard(PrePaiCard newPrePaiCard) {
        if (prePaiCards == null) {
            prePaiCards = new PrePaiCard[1];
            prePaiCards[0] = new PrePaiCard(newPrePaiCard);
        } else {
            PrePaiCard[] newPrePaiCards = new PrePaiCard[prePaiCards.length + 1];
            for (int i = 0; i < prePaiCards.length; i++) {
                newPrePaiCards[i] = new PrePaiCard(prePaiCards[i]);
            }
            newPrePaiCards[prePaiCards.length] = new PrePaiCard(newPrePaiCard);
            prePaiCards = newPrePaiCards;
        }

        return prePaiCards.length;
    }

    public boolean removePrePaiCard(int indexOfPrePaiCard) {
        if (prePaiCards == null || indexOfPrePaiCard < 0 || indexOfPrePaiCard >= prePaiCards.length) {
            return false;
        }

        if (prePaiCards.length == 1) {
            prePaiCards = null;
        } else {
            PrePaiCard[] newPrePaiCards = new PrePaiCard[prePaiCards.length - 1];
            int newIndex = 0;

            for (int i = 0; i < prePaiCards.length; i++) {
                if (i != indexOfPrePaiCard) {
                    newPrePaiCards[newIndex++] = new PrePaiCard(prePaiCards[i]);
                }
            }

            prePaiCards = newPrePaiCards;
        }

        return true;
    }

    public void updateCardExpiry(PrePaiCard cardToUpdate, int expiryDay, int expiryMonth) {
        if (prePaiCards != null) {
            for (PrePaiCard card : prePaiCards) {
                if (card.equals(cardToUpdate)) {
                    card.setDay(expiryDay);
                    card.setMonth(expiryMonth);
                    break;
                }
            }
        }
    }

    public double addMealsSales(int junior, int teen, int medium, int big, int family) {
        sales.addSales(junior, teen, medium, big, family);
        return sales.SalesTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PoS other = (PoS) obj;

        return this.getTotalSales() == other.getTotalSales()
                && this.getNumPrepaidCards() == other.getNumPrepaidCards();
    }

    public String salesBreakdown() {
        return sales.toString();
    }

    
public String toString() {
		
		String result = "";
		
		result += sales.getJunior() + " x $" + sales.getJuniorPrice() + " + ";
		result += sales.getTeen() + " x $" + sales.getTeenPrice() + " + ";
		result += sales.getMedium() + " x $" + sales.getMediumPrice() + " + ";
		result += sales.getBig() + " x $" + sales.getBigPrice() + " + ";
		result += sales.getFamily() + " x $" + sales.getFamilyPrice();
		result += "\n";
		
		if (prePaiCards != null && prePaiCards.length > 0) { // Method returns the constructed string if there are cards inside the array
            for (PrePaiCard card : prePaiCards) {
                result += card.toString() + ".\n";  // Add a new line after each pre-paid card
            }
        } else { // If there are no cards inside the array, then this is displayed instead
            result += "No PrePaiCards\n";
        }
        return result;
    }

    public Sales getSales() {
        return sales;
    }

    public PrePaiCard[] getPrepaidCards() {
        return prePaiCards;
    }
    
    
}