package Collection.Set.TreeSet;

import java.util.TreeSet;

public class ProductTreeSet {
    public static void main(String[] args) {
        TreeSet<Product> productSet = new TreeSet<>();
        productSet.add(new Product("Laptop", 800.00));
        productSet.add(new Product("Phone", 500.00));
        productSet.add(new Product("Tablet", 300.00));

        System.out.println("Qiymətə görə sıralanmış məhsullar:");
        for (Product product : productSet) {
            System.out.println(product);
        }

        // 500$-dan aşağı qiymətli ilk məhsul
        Product product = productSet.lower(new Product("", 500.00));
        if (product != null) {
            System.out.println("500$-dan ucuz məhsul: " + product);
        }
    }

}
