package ruslan.araslanov;

import java.util.List;
//OCP
//Используя интерфейс можно добавить другую реализацию зранения данных,
//не меняя написанный код.

//ISP
//Только два метода, избегаем не нужного функционала.
public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(int id);
}
