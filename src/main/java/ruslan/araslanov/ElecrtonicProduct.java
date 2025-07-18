package ruslan.araslanov;

public class ElecrtonicProduct  extends Product {
    private final double SCREEN_DIAGONAL;

    public ElecrtonicProduct(ProductCategory CATEGORY, int ID, String NAME, double PRICE, double SCREEN_DIAGONAL) {
        super(CATEGORY, ID, NAME, PRICE);
        this.SCREEN_DIAGONAL = SCREEN_DIAGONAL;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Диагональ экрана= " + SCREEN_DIAGONAL;

    }
}
