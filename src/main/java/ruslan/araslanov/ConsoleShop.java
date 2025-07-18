package ruslan.araslanov;

import java.util.Scanner;

public class ConsoleShop {
    //теперь кейсы это не магические значения!
    private static final int PRODUCT_MENU = 1;
    private static final int ADD_CART = 2;
    private static final int MENU_CART = 3;
    private static final int CHECKOUT = 4;
    private static final int EXIT = 0;

    private final ProductRepository productRepository;
    private final CartService cartService;
    private final OrderService orderService;
    private final Scanner scanner;

    public ConsoleShop(ProductRepository productRepository, CartService cartService, OrderService orderService, Scanner scanner) {
        this.productRepository = productRepository;
        this.cartService = cartService;
        this.orderService = orderService;
        this.scanner = scanner;

    }

    public void Run() {
        while (true) {
            printMenu();
            int input = scanner.nextInt();

            switch (input) {
                case PRODUCT_MENU -> productMenu();
                case ADD_CART -> addCart();
                case MENU_CART -> menuCart();
                case CHECKOUT -> chekout();
                case EXIT -> {
                   System.out.println("Работа завершена! До новых встреч !");
                   return;
               }
                default -> System.out.println("не кооректный выбор!");
            }
        }

    }

    private void printMenu() {
        System.out.println("Меню магазина !");
        System.out.println("1. Показать товары");
        System.out.println("2. Добавить в корзину");
        System.out.println("3. Показать корзину");
        System.out.println("4. Оформить заказ");
        System.out.println("0. Выход");
        System.out.print("Выберите пункт: ");
    }

    private void productMenu() {
        System.out.println("Товары");
        productRepository.getAllProducts().forEach(System.out::println);
    }

    private void addCart() {
        productMenu();
        System.out.print("Введите ID товара: ");
        int id = scanner.nextInt();

        Product product =  productRepository.getProductById(id);
        if (product != null) {
            cartService.addProduct(product);
            System.out.println(product.getNAME() + " добавлен в корзину");
        } else {
            System.out.println("Товар не найден !");
        }
    }

    private void menuCart() {
        System.out.println("Ваша корзина");
        if (cartService.getItems().isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        cartService.getItems().forEach(System.out::println);
        System.out.println("Итого: " + cartService.calculateTotal() + " руб.");
    }

    private void chekout() {
        try {
            orderService.checkout();
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }
}
