package ruslan.araslanov;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private final List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            items.add(product);
        }
    }

    public void clear() {
        items.clear();
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }
    //DRY
    //этот метод используется и в другом месте
    //в методе chekout в класе OrderService
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(Product::getPRICE)
                .sum();
    }
}
