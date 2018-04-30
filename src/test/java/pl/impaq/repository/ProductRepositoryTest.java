package pl.impaq.repository;

import org.junit.Assert;
import org.junit.Test;
import pl.impaq.entity.Barcode;
import pl.impaq.entity.Product;

public class ProductRepositoryTest {

    @Test
    public void addProductMethodShouldEnlargeProductRepositoryList(){
        ProductRepository productRepository = new ProductRepository();
        int sizeBeforeAdd = productRepository.getProducts().size();
        productRepository.addProduct(Product.builder().build());
        int sizeAfterAdd = productRepository.getProducts().size();

        Assert.assertEquals(sizeBeforeAdd + 1, sizeAfterAdd);
    }

    @Test
    public void findProductMethodShouldReturnProductByCodeBarCode(){
        ProductRepository productRepository = new ProductRepository();
        String code = "5900017304007";
        Barcode barcode = new Barcode(code);
        productRepository.addProduct(Product.builder().barcode(barcode).build());
        Product product = productRepository.findProduct(code);

        Assert.assertNotNull(product);
        Assert.assertEquals(barcode, product.getBarcode());
        Assert.assertEquals(code, product.getBarcode().getCode());
    }

}
