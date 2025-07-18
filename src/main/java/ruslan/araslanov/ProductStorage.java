package ruslan.araslanov;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductStorage() {
        products.add(new ElecrtonicProduct(ProductCategory.TV,1,"Samsung",55000,55));
        products.add(new ElecrtonicProduct(ProductCategory.PHONE,2,"Iphone16",800000,6.7));
        products.add(new ElecrtonicProduct(ProductCategory.LAPTOP,3,"Lenovo",45000,25));

    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getID() == id)
                .findFirst()
                .orElse(null);
    }
}
