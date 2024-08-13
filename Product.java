//Akash Raj Palamalayil
//200562507
public class Product {
    private int id; // Matches the JSON structure
    private String sku;
    private String name;
    private double salePrice;
    private double regularPrice;
    private String image; // Matches the JSON field name

    // Constructor
    public Product(int id, String sku, String name, double salePrice, double regularPrice, String image) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.salePrice = salePrice;
        this.regularPrice = regularPrice;
        this.image = image;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // toString method
    @Override
    public String toString() {
        return name + "-$" + String.format("%.2f", salePrice);
    }
}
