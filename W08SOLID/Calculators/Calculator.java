package W08SOLID.Calculators;


import W08SOLID.products.Product;

import java.util.List;

public interface Calculator {
    double sum (List<Product> products);
    double average (List<Product> products);
}
