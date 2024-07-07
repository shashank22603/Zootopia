package org.example;

public class Discount {
    private String category ;
    private int percentage ;
    private int eligibilityLowerBound , eligibilityUpperBound ;
    public Discount(String category, int percentage , int eligibilityLowerBound , int eligibilityUpperBound) {
        this.category = category;
        this.percentage = percentage;
        this.eligibilityLowerBound = eligibilityLowerBound ;
        this.eligibilityUpperBound = eligibilityUpperBound ;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPercentage() {
        return percentage;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getEligibilityLowerBound() {
        return eligibilityLowerBound;
    }

    public void setEligibilityLowerBound(int eligibilityLowerBound) {
        this.eligibilityLowerBound = eligibilityLowerBound;
    }

    public int getEligibilityUpperBound() {
        return eligibilityUpperBound;
    }

    public void setEligibilityUpperBound(int eligibilityUpperBound) {
        this.eligibilityUpperBound = eligibilityUpperBound;
    }
}
