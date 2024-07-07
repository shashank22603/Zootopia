package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.* ;
public class Visitor {
    private String username  , password , phoneNO , email , feedback;
    private int age , balance  ;
    private String membership = "basic" ;
    private Map <Attraction , Integer > tickets = new HashMap<Attraction , Integer> () ;
    Scanner sc = new Scanner(System.in) ;
    public Visitor() {

    }
    public Visitor(String username, String password, String phoneNO, String email, int age, int balance) {
        this.username = username;
        this.password = password;
        this.phoneNO = phoneNO;
        this.email = email;
        this.age = age;
        this.balance = balance;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNO() {
        return phoneNO;
    }
    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getMembership() {
        return membership;
    }
    public void setMembership(String membership) {
        this.membership = membership;
    }
    public Scanner getSc() {
        return sc;
    }
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    void viewAnimals (List <Animal> animals , int condition) {
        int count = 1 ;
        for (Animal animal : animals) {
            System.out.println(count + ". " + animal.getName());
            count++ ;
        }
        int status = sc.nextInt() ;
        count = 1;
        for (Animal animal : animals) {
            if (status == count) {
                if (condition == 1) {
                    System.out.println("1. Feed animal\n2. Read about the animal");
                    int status2 = sc.nextInt() ;
                    if (status2 == 1) {
                        animal.getSound() ;
                    }
                    else if (status2 == 2) {
                        System.out.println(animal.getDescription());
                    }
                    else return ;
                }
                System.out.println(animal.getName() + " is a " + animal.getType() + " and " + animal.getType());
                return ;
            }
            count++ ;
        }
        System.out.println("No such  animals");
    }
    void viewAttractions(@NotNull List <Attraction> attractions) {
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getId() + ". " + attraction.getName());
        }
        int status = sc.nextInt() ;
        for (Attraction attraction : attractions) {
            if (status == attraction.getId()) {
                System.out.println(attraction.getDescription());
                return ;
            }
        }
        System.out.println("No such Attractions found");
    }
    void exploreZoo (List <Animal> animals , List <Attraction> attractions) {
        System.out.println("1.View Animals\n2. View Attractions\n3. Exit");
        int status = sc.nextInt() ;
        if (status == 1) viewAnimals(animals , 0);
        else if (status == 2) viewAttractions(attractions);
        else return ;
    }
    void buyMembership (List <Discount> discounts) {
        System.out.println("1. To buy basic membership (Rs. 20)\n2. To buy premium membership (Rs. 50)");
        int status = sc.nextInt() ;
        viewDiscounts(discounts) ;
        int basicPrice = 20 , premPrice = 50 ;
        while (true) {
            System.out.println("Apply discount ? (y/n)");
            String opt = sc.nextLine() ;
            if (Objects.equals(opt, "y")) {
                System.out.println("Choose discount");
                int options = sc.nextInt() ;
                int count = 0 ;
                for (Discount discount : discounts) {
                    if (count == options) {
                        if (discount.getEligibilityLowerBound() <= getAge() && discount.getEligibilityUpperBound() >= getAge()) {
                            basicPrice = basicPrice - (basicPrice * discount.getPercentage()) / 100;
                            premPrice = premPrice - (premPrice * discount.getPercentage()) / 100;
                            break;
                        } else {
                            System.out.println("You are not eligible for this discount");
                            break;
                        }
                    }
                    count++ ;
                }
            }
            else break ;
        }
        if (status == 1) {
            if (getBalance() < basicPrice) System.out.println("Not enough balance") ;
            else setBalance(getBalance() - basicPrice);
        }
        if (status == 2) {
            if (getBalance() < premPrice) System.out.println("Not enough balance");
            else {
                setBalance(getBalance() - premPrice);
                setMembership("premium");
            }
        }
    }
    void viewDiscounts(List <Discount> discounts) {
        int count = 1  ;
        for (Discount discount : discounts) {System.out.println(count + ". Category : " + discount.getCategory() + " discount percentage : " + discount.getPercentage()); count++ ;}
    }

    void buyTickets (List <Attraction> attractions , List <Discount> specialDeals) {
        if (Objects.equals(getMembership(), "premium")) {System.out.println("This is included in the premium membership. Enjoy!!!") ;return ;}
        System.out.println("Enter the id of the attractions you want to buy ticket of :");
        int id = sc.nextInt() ;
        sc.nextLine() ;
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                System.out.println("Enter number of ticket you want to buy : ");
                int number = sc.nextInt() ;
                sc.nextLine() ;
                int price = number * attraction.getPrice() ;
                int maxDiscount = 0 ;
                int size = tickets.size();
                for (Discount discount : specialDeals) {
                    if (size >= discount.getEligibilityLowerBound()) maxDiscount = Math.max (maxDiscount , discount.getPercentage()) ;
                }
                price = price - (price * maxDiscount) / 100 ;
                if (price > getBalance()) System.out.println("Not enough balance");
                else {
                    attraction.setTicketsSold(attraction.getTicketsSold() + number);
                    attraction.setRevenue(attraction.getRevenue() + price);
                    tickets.put (attraction , tickets.get(attraction) + number) ;
                    setBalance(getBalance() - price) ;
                    System.out.println("You have bought " + number + " tickets of " + attraction.getName());
                }
            }
        }
    }
    void visitAttractions (List <Attraction> attractions) {
        if (Objects.equals(getMembership(), "premium")) {
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getName());
                System.out.println(attraction.getDescription());
                System.out.println("Start time : " + attraction.getStartTime() + " End Time : " + attraction.getEndTime());
            }
        }
        else {
            for (Map.Entry<Attraction, Integer> entry : tickets.entrySet()) {
                Attraction attraction = entry.getKey();
                System.out.println();
                int ticket = entry.getValue() - 1;
                entry.setValue(ticket - 1) ;
                System.out.println(attraction.getName());
                System.out.println(attraction.getDescription());
                System.out.println("Start time : " + attraction.getStartTime() + " End Time : " + attraction.getEndTime());
            }
        }
    }
    void visitAnimals (List <Animal> animals) {
        System.out.println("Select the animal name you want to visit");
        viewAnimals(animals , 1);

    }
    void giveFeedback () {
        System.out.println("Enter feedback (Max 200 characters) :");
        this.feedback = sc.nextLine();
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public Map<Attraction, Integer> getTickets() {
        return tickets;
    }
    public void setTickets(Map<Attraction, Integer> tickets) {
        this.tickets = tickets;
    }
}