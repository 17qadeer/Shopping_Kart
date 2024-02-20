package com.shop.Shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.shop.Shopping.Entity.Product;
import com.shop.Shopping.Entity.ProductVariation;
import com.shop.Shopping.Entity.SpecialProduct;
import com.shop.Shopping.Repository.ProductRepo;
import com.shop.Shopping.Repository.ProdvariationRepo;
import com.shop.Shopping.Repository.SpecialProductRepo;
import com.shop.Shopping.exception.ResourceNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;
    
    @Autowired
    private ProdvariationRepo productvariationRepository;
    
    @Autowired
    private SpecialProductRepo spcproductRepository;

    public List<ProductVariation> getAllProducts() {
        return productvariationRepository.findAll();
    }

    public SpecialProduct findById(Long id) {
        return spcproductRepository.findById(id)
        										.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    private double calculateSimilarity(ProductVariation product1, ProductVariation product2) {
        double categorySimilarity = calculateCategorySimilarity(product1.getType(), product2.getType());
        double priceRangeSimilarity = calculatePriceRangeSimilarity(product1.getPrice(), product2.getPrice());

        // Weighted sum of similarities
        double similarity = 0.6 * categorySimilarity + 0.4 * priceRangeSimilarity;

        return similarity;
    }

    // Calculate similarity based on category
    private double calculateCategorySimilarity(String category1, String category2) {
        return category1.equals(category2) ? 1.0 : 0.0;
    }

    // Calculate similarity based on price range
    private double calculatePriceRangeSimilarity(double price1, double price2) {
        // Adjust this logic based on your price range criteria
        double priceDifference = Math.abs(price1 - price2);
        double maxPriceDifference = 100.0; // Maximum price difference to consider products similar

        return 1.0 - Math.min(priceDifference / maxPriceDifference, 1.0);
    }

    public List<ProductVariation> getRecommendedProducts(ProductVariation product) {
        List<ProductVariation> allProducts = productvariationRepository.findAll();
        List<ProductVariation> recommendedProducts = new ArrayList<>();

        // Iterate through all products to find similar products
        for (ProductVariation otherProduct : allProducts) {
            if (!otherProduct.equals(product)) {
                double similarity = calculateSimilarity(product, otherProduct);
                // You can define a threshold for similarity to consider a product as recommended
                if (similarity >= 0.75) { // Adjust the threshold as needed
                    recommendedProducts.add(otherProduct);
                }
            }
        }

        return recommendedProducts;
    }

    public ProductVariation getProductVarById(Long productId) {
        return productvariationRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public List<ProductVariation> searchProductsByName(String name) {
        // Perform case-insensitive search for products starting with the given name
        return productvariationRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public List<ProductVariation> searchProductsByType(String type) {
        // Perform case-insensitive search for products by type
        return productvariationRepository.findByTypeIgnoreCase(type);
    }

    public List<ProductVariation> filterProductsByGender(List<ProductVariation> products, String gender) {
        // Filter products by gender
        return products.stream()
                .filter(product -> product.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }
    public List<ProductVariation> getAllProductsPage() {
        List<ProductVariation> allProducts = productvariationRepository.findAll();
        Collections.shuffle(allProducts); // Shuffle the list to get products in random order
        return allProducts;
    }
    public List<ProductVariation> getRandomProducts(int page, int pageSize) {
        List<ProductVariation> allProducts = productvariationRepository.findAll();
        Collections.shuffle(allProducts); // Shuffle the list to get products in random order

        int startIdx = page * pageSize;
        int endIdx = Math.min(startIdx + pageSize, allProducts.size());
        
        if (startIdx >= allProducts.size()) {
            return Collections.emptyList();
        }
        
        return allProducts.subList(startIdx, endIdx);
    }
}
