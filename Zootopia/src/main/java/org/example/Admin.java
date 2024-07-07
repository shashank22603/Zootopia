package org.example;

import java.util.* ;

public class Admin {
    Scanner sc = new Scanner(System.in);
    int ID = 0 ;
    private List <Attraction> attractions = new ArrayList <Attraction>() ;
    void manageAttractions () {
        System.out.println("1. Add Attractions\n2. Modify Attractions\n3. Remove Attractions\n4. View Attraction");
        int status = sc.nextInt() ;
        sc.nextLine() ;
        if (status == 1) {
            System.out.println("Enter the name of the Attraction");
            String name = sc.nextLine() ;
            System.out.println("Enter the description of the Attraction");
            String description = sc.nextLine() ;
            System.out.println("Enter the entry ticker price");
            int price = sc.nextInt() ;
            sc.nextLine() ;
            Attraction attraction = new Attraction(ID , name , description , price) ;
            ID++ ;
            attractions.add(attraction) ;
        }
        else if (status == 2) {
            System.out.println("Enter the id of the attraction to modify");
            int id = sc.nextInt() ;
            sc.nextLine() ;
            for (Attraction attraction : attractions) {
                if (attraction.getId() == id) {
                    System.out.println("Enter the new name");
                    String newName = sc.nextLine() ;
                    System.out.println("Enter the new description");
                    String newDescription = sc.nextLine() ;

                    attraction.setStartTime(newName) ;
                    attraction.setEndTime(newDescription);

                    return ;
                }
            }
            System.out.println("No such attractions");
        }

        else if (status == 3) {
            System.out.println("Enter the id of the attraction to remove");
            int id = sc.nextInt() ;
            sc.nextLine() ;
            for (Attraction attraction : attractions) {
                if (attraction.getId() == id) {

                    attractions.remove(attraction) ;

                    return ;
                }
            }
            System.out.println("No such attractions");

        }
        else if (status == 4) {
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getName());
                System.out.println(attraction.getDescription());
                System.out.println("Start time : " + attraction.getStartTime() + " End Time : " + attraction.getEndTime());
            }
        }
        else return ;
    }

    void manageAnimals () {

    }

    void scheduleEvents () {
        System.out.println("Enter the id of the attraction of schedule");
        int id = sc.nextInt() ;
        sc.nextLine() ;
        for (Attraction attraction : attractions) {
            if (attraction.getId() == id) {
                System.out.println("Enter the start time of the attraction");
                String startTime = sc.nextLine() ;

                System.out.println("Enter the end time of the attraction");
                String endTime = sc.nextLine() ;

                attraction.setStartTime(startTime);
                attraction.setEndTime(endTime);

                return ;
            }
        }

        System.out.println("No such attractions");

    }

    void setDiscounts (List <Discount> discounts) {
        System.out.println("1. Add discount\n2. Modify discount\n3. Remove discount");
        int status = sc.nextInt() ;
        sc.nextLine() ;
        if (status == 1) {
            System.out.println("Enter the category of discount");
            String category = sc.nextLine() ;
            System.out.println("Enter the percentage of discount");
            int dis = sc.nextInt() ;
            sc.nextLine() ;
            System.out.println("Enter lower bound on eligibility criteria (-1 if no lower bound)");
            int lower = sc.nextInt() ;
            sc.nextLine() ;
            System.out.println("Enter upper bound on eligibility criteria(-1 if no upper bound)");
            int upper = sc.nextInt() ;
            if (upper == -1) upper = 1000 ;
            sc.nextLine() ;
            Discount discount = new Discount(category, dis ,lower , upper ) ;
            discounts.add(discount) ;
        }
        else if (status == 2) {
            System.out.println("Enter the category of the discount to modify");
            String category = sc.nextLine() ;
            for (Discount discount : discounts) {
                if (Objects.equals(discount.getCategory(), category)) {
                    System.out.println("Enter the new name");
                    String newName = sc.nextLine() ;
                    System.out.println("Enter the new percentage");
                    int percentage = sc.nextInt() ;
                    sc.nextLine() ;

                    discount.setCategory(newName);
                    discount.setPercentage(percentage);

                    return ;
                }
            }
            System.out.println("No such attractions");
        }
        else if (status == 3) {
            System.out.println("Enter the category of the discount to remove");
            String category = sc.nextLine() ;
            for (Discount discount : discounts) {
                if (Objects.equals(discount.getCategory(), category)) {
                    discounts.remove(discount) ;
                    return ;
                }
            }
            System.out.println("No such Discounts");
        }
    }

    void viewVisitorStats(List <Attraction> attractions) {
        System.out.println("1. Total visitors\n2.total revenue\n3. Most popular attractions");
        int option = sc.nextInt() ;
        sc.nextLine() ;
        if (option == 1) {
            int totalVisitors = 0 ;
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getName() + " : " + attraction.getTicketsSold());
                totalVisitors += attraction.getTicketsSold() ;
            }
            System.out.println("Total visitors : " + totalVisitors);
        }
        else if (option == 2) {
            int totalRevenue = 0 ;
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getName() + " : " + attraction.getRevenue());
                totalRevenue += attraction.getRevenue() ;
            }
            System.out.println("Total revenue : " + totalRevenue);
        }
        else if (option == 3) {
            attractions.sort(new AttractionComparator());
            System.out.println("The most popular Attractions are : ");
            int count = 0 ;
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getName());
                count++ ;
                if (count == 3) break ;
            }
        }
    }



}