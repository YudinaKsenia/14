package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();


    @Test

    public void shouldRemoveExistProduct() {

        Product product1 = new Product(1, "Кукольный дом", 3600);
        Product product2 = new Product(2, "Машинка", 1800);
        Product product3 = new Product(3, "Детская зубная щетка", 200);
        Product product4 = new Product(4, "Книга", 560);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        repo.remove(2);

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveNotExistProduct() {

        Product product1 = new Product(1, "Кукольный дом", 3600);
        Product product2 = new Product(2, "Машинка", 1800);
        Product product3 = new Product(3, "Детская зубная щетка", 200);
        Product product4 = new Product(4, "Книга", 560);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(8)
        );
    }

    @Test

    public void shouldAddProduct() {

        Product product1 = new Product(1, "Кукольный дом", 3600);

        repo.add(product1);


        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}