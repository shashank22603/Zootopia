package org.example;

import java.util.* ;

public class Main {
    public static void main(String[] args) {
        List <Attraction> attractions = new ArrayList<Attraction>() ;
        List <Animal> animals = new ArrayList<Animal>() ;
        List <Discount> discounts = new ArrayList<Discount>() ;
        List <Visitor> visitors = new ArrayList<Visitor>() ;
        List <Discount> specialDiscount = new ArrayList<Discount>() ;
        Discount dis = new Discount("More than two tickets" , 15 , 2 , -1) ;
        specialDiscount.add(dis) ;
        dis.setCategory("More than Three tickets") ;
        dis.setPercentage(20);
        dis.setEligibilityLowerBound(3);
        specialDiscount.add(dis) ;
        Animal animal = new Mammal("Elephant" , "trumpet" , "Elephants are the world's largest land mammals known for their immense size, long trunks, and remarkable intelligence.") ;
        animals.add(animal) ;
        animal = new Mammal("Gray Wolf" , "Howl" , "Gray wolves are highly social predators known for their eerie howling and cooperative hunting in packs.") ;
        animals.add(animal) ;
        animal = new Reptile("Green Anole" , "Green Anoles are small, arboreal lizards with the ability to change color and communicate through subtle chirping or clicking sounds." , "Chirping") ;
        animals.add(animal) ;
        animal = new Reptile("Rattle Snake" , " Rattlesnakes are venomous serpents known for their rattling tail, which serves as a warning signal to potential threats." , "Rattling") ;
        animals.add(animal) ;
        animal = new Amphibian("American Bullfrog" , "Croaking" , "American bullfrogs are large amphibians recognized by their loud, deep croaking calls, often heard in wetlands and ponds.") ;
        animals.add(animal) ;
        animal = new Amphibian("Red-eyed tree frog" , "Chirping" , "Red-eyed tree frogs are vibrant, nocturnal amphibians known for their striking appearance and soft, high-pitched chirping calls in tropical rainforests.") ;
        animals.add(animal) ;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Welcome to ZooTopia !!!");
        Admin admin = new Admin() ;
        while (true) {
            System.out.println("1. Enter as Admin\n2. Enter as Visitor\n3.View special deals\n4. Exit");
            int status = sc.nextInt() ;
            sc.nextLine() ;
            if (status == 1) {
                String Username = "admin" , Password = "password" ;
                System.out.println("Enter Admin Username");
                String username = sc.nextLine() ;
                System.out.println("Enter Admin Password");
                String password = sc.nextLine() ;
                if (username.equals(Username) && Password.equals(password)) {
                    while (true) {
                        System.out.println("Admin menu");
                        System.out.println("1. Manage Attractions\n2. Manage Animals\n3. Schedule Events\n4. Set Discounts\n5. Set Special Deal\n6. View Visitor Stats\n7. View Feedback\n8. Exit\n");
                        int choice = sc.nextInt() ;
                        boolean run = true ;
                        switch (choice) {
                            case 1:
                                admin.manageAttractions() ;
                                break ;
                            case 2:
                                admin.manageAnimals() ;
                                break ;
                            case 3 :
                                admin.scheduleEvents() ;
                                break ;
                            case 4 :
                                admin.setDiscounts(discounts) ;
                                break ;
                            case 5 :
                                admin.setDiscounts(specialDiscount);
                                break ;
                            case 6 :
                                admin.viewVisitorStats(attractions);
                                break ;
                            case 7 :
                                for (Visitor visitor : visitors) {
                                    System.out.println(visitor.getUsername() + " : " +  visitor.getFeedback());
                                }
                                break ;
                            case 8 :
                                run = false ;
                                break ;
                        }
                        if (!run) break ;
                    }
                }
                else {
                    System.out.println("Invalid Username or Password");
                }
            }

            else if (status == 2) {
                while (true) {
                    System.out.println("1. New User ? Register here\n2.Login\n3. Exit");
                    int option = sc.nextInt() ;
                    if (option == 1) {
                        System.out.println("Enter username : ");
                        String username = sc.nextLine() ;
                        System.out.println("Enter password : ");
                        String password = sc.nextLine() ;
                        boolean login = false ;
                        for (Visitor visitor : visitors) {
                            if (username.equals(visitor.getUsername()) && password.equals(visitor.getPassword())) {
                                System.out.println("You are already registered");
                                login = true ;
                                break ;
                            }
                        }
                        if (!login){
                            System.out.println("Enter Phone Number : ");
                            String phone = sc.nextLine() ;
                            System.out.println("Enter Email Address : ");
                            String email = sc.nextLine() ;
                            System.out.println("Enter your age : ");
                            int age = sc.nextInt() ;
                            System.out.println("Enter your balance : ");
                            int balance = sc.nextInt() ;
                            Visitor visitor = new Visitor(username, password, phone, email, age, balance) ;
                            visitors.add(visitor) ;
                        }

                    }
                    else if (option == 2) {
                        System.out.println("Enter your username : ");
                        String username = sc.nextLine() ;
                        System.out.println("Enter your password : ");
                        String password = sc.nextLine() ;
                        boolean registered = false ;
                        Visitor visitor = new Visitor();
                        for (Visitor vis : visitors) {
                            if (username.equals(vis.getUsername()) && password.equals(vis.getPassword())) {
                                visitor = vis ;
                                registered = true ;
                                break ;
                            }
                        }
                        if (!registered) {
                            System.out.println("Invalid username or password");
                        }
                        else {
                            System.out.println("Visitor menu");
                            System.out.println("1. Explore the Zoo\n2. Buy Membership\n3. Buy Tickets\n4. View Discounts\n5. View Special Deals\n6. Visit Attractions\n7. Visit Animals\n8. Give Feedback\n9. Exit");
                            int choice = sc.nextInt() ;
                            switch (choice) {
                                case 1 :
                                    visitor.exploreZoo (animals , attractions) ;
                                    break ;
                                case 2 :
                                    visitor.buyMembership(discounts) ;
                                    break ;
                                case 3 :
                                    visitor.buyTickets(attractions , specialDiscount) ;
                                    break ;
                                case 4 :
                                    visitor.viewDiscounts(discounts) ;
                                    break ;
                                case 5 :
                                    for (Discount discount : specialDiscount) {
                                        System.out.println("Category : " + discount.getCategory() + " : " + discount.getPercentage() + "%");
                                    }
                                    break ;
                                case 6 :
                                    visitor.visitAttractions(attractions) ;
                                    break ;
                                case 7 :
                                    visitor.visitAnimals(animals) ;
                                    break ;
                                case 8 :
                                    visitor.giveFeedback() ;
                                default :
                                    break ;
                            }

                        }
                    }

                    else if (option == 3) {
                        break ;
                    }
                }
            }

            else if (status == 3) {
                for (Discount discount : specialDiscount) {
                    System.out.println("Category : " + discount.getCategory() + " : " + discount.getPercentage() + "%");
                }
            }
            else {
                System.out.println("Please Visit again !!!");
                break ;
            }
        }

        sc.close();
    }
}
