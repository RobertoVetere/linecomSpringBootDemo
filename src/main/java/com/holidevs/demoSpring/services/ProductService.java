package com.holidevs.demoSpring.services;

import com.holidevs.demoSpring.dto.ProductDto;
import com.holidevs.demoSpring.models.Category;
import com.holidevs.demoSpring.models.Product;
import com.holidevs.demoSpring.repositories.ProductRepository;
import com.holidevs.demoSpring.services.interfaces.ProductServiceInterface;
import jakarta.transaction.Transactional;
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

    @Transactional
    public ProductDto getProduct(Long id) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found"));

            // Convierte Product a ProductDto con todos los atributos
            ProductDto productDto = new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getStock(),
                    product.getPrice(),
                    product.getStatus(),
                    product.getCreateAt()
            );

            return productDto;
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while fetching the product with id " + id, ex);
        }
    }

    public Product createProduct(Product product) {
        try {
            //TODO: logica de negocio y validaciones
            Product newProduct = new Product(product.getName(),product.getDescription(),product.getStock(),
                    product.getPrice(),product.getStatus(),product.getCategory());
            productRepository.save(newProduct);
            return newProduct;
        } catch (Exception e) {// Aquí puedes personalizar la gestión de la excepción.
            //TODO implementar manejo personalizado de excepciones
            //throw new ProductCreationException("Error al crear el producto.");
            throw new RuntimeException("Error al crear el producto." + e.getMessage());
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            Optional<Product> existingProductOptional = productRepository.findById(product.getId());

            if (existingProductOptional.isPresent()) {
                Product existingProduct = existingProductOptional.get();

                if (product.getName() != null) {
                    existingProduct.setName(product.getName());
                }
                if (product.getDescription() != null) {
                    existingProduct.setDescription(product.getDescription());
                }
                if (product.getStock() != null) {
                    existingProduct.setStock(product.getStock());
                }
                if (product.getPrice() != null) {
                    existingProduct.setPrice(product.getPrice());
                }
                if (product.getStatus() != null) {
                    existingProduct.setStatus(product.getStatus());
                }
                if (product.getCategory() != null) {
                    existingProduct.setCategory(product.getCategory());
                }

                productRepository.save(existingProduct);

                return existingProduct;
            } else {
                // TODO: Implementar un manejo personalizado de excepciones
                throw new RuntimeException("Producto no encontrado con ID: " + product.getId());
            }
        } catch (Exception e) {
            // TODO: Implementar un manejo personalizado de excepciones
            throw new RuntimeException("Error al actualizar el producto: " + e.getMessage());
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
            throw new RuntimeException("Error al eliminar el producto." + e.getMessage());
        }
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
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
