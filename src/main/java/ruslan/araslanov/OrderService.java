package ruslan.araslanov;

//DIP
//OS зависит от абстракций CartService.
public class OrderService {
    private final String NAME_MONEY = "руб.";
    private final CartService cartService;

    public OrderService(CartService cartService) {
        this.cartService = cartService;
    }

    public void checkout() {
        if (cartService.getItems().isEmpty()) {
            throw new IllegalStateException("Корзина пуста");
        }
        double total = cartService.calculateTotal();
        System.out.println("Заказ оформлен на сумму: " + total + NAME_MONEY);
        cartService.clear();
    }
}
