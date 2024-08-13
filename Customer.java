//Akash Raj Palamalayil
//200562507

import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private List<Product> purchases; // List of Product objects

    // Constructor
    public Customer(int id, String firstName, String lastName, String phone, List<Product> purchases) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.purchases = purchases;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    // Method to add a product to the purchases list
    public void addProduct(Product product) {
        this.purchases.add(product);
    }

    // Method to calculate total purchases
    public double getTotalPurchases() {
        return purchases.stream().mapToDouble(Product::getSalePrice).sum();
    }

    // Method to calculate total savings
    public double getTotalSavings() {
        return purchases.stream()
                .mapToDouble(p -> p.getRegularPrice() - p.getSalePrice())
                .sum();
    }

    // Method to check if saved $5 or more on each purchase
    public boolean savedFiveOrMore() {
        return purchases.stream().allMatch(p -> (p.getRegularPrice() - p.getSalePrice()) >= 5);
    }
}


    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getPounds() {
        return pounds;
    }

    public void setPounds(double pounds) {
        this.pounds = pounds;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(int heightInCM) {
        this.heightInCM = heightInCM;
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Product> purchases) {
        this.purchases = purchases;
    }

    // Method to calculate total purchases
    public double getTotalPurchases() {
        return purchases.stream()
                .mapToDouble(Product::getSalePrice)
                .sum();
    }

    // Method to calculate total savings
    public double getTotalSavings() {
        return purchases.stream()
                .mapToDouble(p -> p.getRegularPrice() - p.getSalePrice())
                .sum();
    }

    // Method to check if saved amount is $5 or more
    public boolean savedMoreThanFive() {
        return purchases.stream()
                .allMatch(p -> p.getRegularPrice() - p.getSalePrice() >= 5);
    }
}
