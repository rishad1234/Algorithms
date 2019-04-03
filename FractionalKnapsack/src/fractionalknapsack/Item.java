
package fractionalknapsack;

public class Item {
    private double weight;
    private double profit;
    private double profitPerWeight;
    private double fraction = 0.0;
    private double weightTaken = 0.0;

    public Item(double weight, double profit) {
        this.weight = weight;
        this.profit = profit;
        this.profitPerWeight = profit / weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfitPerWeight() {
        return profitPerWeight;
    }

    public void setProfitPerWeight(double profitPerWeight) {
        this.profitPerWeight = profitPerWeight;
    }
    
    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public double getWeightTaken() {
        return weightTaken;
    }

    public void setWeightTaken(double weightTaken) {
        this.weightTaken = weightTaken;
    }

    @Override
    public String toString() {
        return "Item{" + "weight=" + weight + ", profit=" + profit + ", profitPerWeight=" + profitPerWeight + ", fraction=" + fraction + ", weightTaken=" + weightTaken + '}';
    }  
}
