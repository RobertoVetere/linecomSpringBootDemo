package com.holidevs.demoSpring.services;

import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import com.holidevs.demoSpring.repositories.ProductRepository;
import com.holidevs.demoSpring.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts() {return productRepository.findAll();}

    public Product getProduct(Long id) {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found"));
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while fetching the product with id " + id, ex);
        }
    }

    public Product createProduct(Product product) {
        try {
            //TODO logica de negocio y validaciones
            productRepository.save(product);
            return product;
        } catch (Exception e) {// Aquí puedes personalizar la gestión de la excepción.
            //TODO implementar manejo personalizado de excepciones
            //throw new ProductCreationException("Error al crear el producto.");
            throw new RuntimeException("Error al crear el producto." + e);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            //TODO logica de negocio y validaciones
            productRepository.save(product);
            return product;
        }catch (Exception e){
            //TODO implementar manejo personalizado de excepciones
            throw new RuntimeException("Error al actualiar el producto." + e);
        }
    }

    @Override
    public Product removeProduct(Product product) {
        try {
            //TODO logica de negocio y validaciones
            productRepository.delete(product);
            return product;
        }catch (Exception e){
            //TODO implementar manejo personalizado de excepciones
            throw new RuntimeException("Error al eliminar el producto." + e);
        }
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return null;
    }

    @Override
    public Optional<Product> updateStock(Long id, Double quantity) {
        try{
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                Product updatedProduct = product.get();

                updatedProduct.setStock(quantity);

                productRepository.save(updatedProduct);

                return Optional.of(updatedProduct);
            } else {
                //TODO manejar en caso de que no encontremos el objeto solicitado
                return Optional.empty();
            }
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar el producto: " + e.getMessage());
        }
    }

}
