package ruslan.araslanov;
//SRP - Абстрактны клас.
//Хранит данные о товаре
//Не знает о заказах , корзине итд
public abstract class Product {
    private final ProductCategory CATEGORY;
    private final int ID;
    private final String NAME;
    private final double PRICE;

    public Product(ProductCategory CATEGORY, int ID, String NAME, double PICE) {
        this.CATEGORY = CATEGORY;
        this.ID = ID;
        this.NAME = NAME;
        this.PRICE = PICE;
    }

    public ProductCategory getCATEGORY() {
        return CATEGORY;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public double getPRICE() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "Категория=" + CATEGORY +
                ", ID=" + ID +
                ", Имя='" + NAME + '\'' +
                ", Цена=" + PRICE
                ;
    }
}
