public class MenuItem {

    private int id;
    private String name;
    private int price;
    private int resId;

    public MenuItem(int id, String name, int price, int resId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.resId = resId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getResId() {
        return resId;
    }
}