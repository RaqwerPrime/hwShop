package ruslan.araslanov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductStorage storage = new ProductStorage();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService(cartService);
        Scanner scanner = new Scanner(System.in);

        ConsoleShop consoleShop = new ConsoleShop(storage,cartService,orderService,scanner);
        consoleShop.Run();
    }
}
