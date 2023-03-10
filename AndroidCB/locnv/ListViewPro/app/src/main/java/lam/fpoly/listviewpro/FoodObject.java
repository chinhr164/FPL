package lam.fpoly.listviewpro;

public class FoodObject {
    private String tenFood,price;
    private int images;

    public FoodObject() {
    }

    public FoodObject(String tenFood, String price, int images) {
        this.tenFood = tenFood;
        this.price = price;
        this.images = images;
    }

    public String getTenFood() {
        return tenFood;
    }

    public void setTenFood(String tenFood) {
        this.tenFood = tenFood;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
