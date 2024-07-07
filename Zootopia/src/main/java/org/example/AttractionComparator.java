package org.example;

import java.util.Comparator;

public class AttractionComparator implements Comparator<Attraction> {
    @Override
    public int compare(Attraction attraction1, Attraction attraction2) {
        // Calculate the product of ticketSold and price for each attraction
        int product1 = attraction1.getTicketsSold() * attraction1.getPrice();
        int product2 = attraction2.getTicketsSold() * attraction2.getPrice();

        // Compare the products in descending order (higher product comes first)
        return Integer.compare(product2, product1);
    }
}
