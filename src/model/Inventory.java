package model;

/*
@param name, price, condition, and stock
 */
public class Inventory extends User {
     String name;
     double price;
      boolean isNew;

      int howManyInStock;

      public Inventory(){

      }

    public Inventory(String name, double price, boolean isNew, int howManyInStock){
        this.name=name;
        this.price=price;
        this.isNew=isNew;
        this.howManyInStock=howManyInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isNew() {
        return isNew;
    }

    //Decreases The number of items that is in stock


    public int getHowManyInStock() {
        return howManyInStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setHowManyInStock(int howManyInStock) {
        this.howManyInStock = howManyInStock;
    }

    @Override
    public String toString() {
        return
                "" + name +
                "," + price+
                "," + isNew +
                ","+howManyInStock;
    }
}
