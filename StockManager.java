import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(!stock.contains(item)) {
            stock.add(item);
        } else {
            System.out.println("This product already exists!");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        if(product != null) {
            product.increaseQuantity(amount);
        } else {
            System.out.println("Product not found!");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock) {
            if(id == product.getID()){
                return product;
            }
        }
        return null;
    }
    
    /**
     * Try to find a product in stock with the given name.
     * @return The identified product, or null if there is none
     *          with a matching ID.
     */
    public Product findProduct (String name)
    {
        for(Product product : stock) {
            if(name.equalsIgnoreCase(product.getName())){
                return product;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        if(product != null){
         return product.getQuantity();   
        } else {
            return 0;
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        Iterator<Product> it = stock.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    /**
     * Print details of all products with stock levels
     * below a given value.
     * @param limit The upper limit of product quantity 
     *          to check for (exclusive).
     */
    public void printLowStock(int limit)
    {
        for(Product product : stock) {
            if(product.getQuantity() < limit){
                System.out.println(product.toString());
            }
        }
    }
}
