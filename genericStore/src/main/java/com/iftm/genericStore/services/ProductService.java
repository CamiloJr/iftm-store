package com.iftm.genericStore.services;

import com.iftm.genericStore.entities.Product;
import com.iftm.genericStore.message.ProductSendMessage;
import com.iftm.genericStore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductSendMessage productSendMessage;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductSendMessage productSendMessage) {
        this.productRepository = productRepository;
        this.productSendMessage = productSendMessage;
    }

    public Product findById(String id) {
        var product = productRepository.findById(id).stream().findFirst().orElse(null);
        return product;
    }

    public List<Product> findAll() {
        var productList = productRepository.findAll();
        return productList;
    }

    public Product create(Product product) {
        var newProduct = productRepository.save(product);

        //Enviando mensagem ao Exchange do RabbitMQ
        productSendMessage.sendMessage(newProduct);

        return newProduct;
    }

    public Product update(Product product) {
        if(product != null && !product.getId().isEmpty()) {
            var dbProduct = findById(product.getId());
            if(dbProduct != null)
                return productRepository.save(product);
        }
        return null;
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void deleteById(String id) {
        if(!id.isEmpty())
            productRepository.deleteById(id);
    }
}
