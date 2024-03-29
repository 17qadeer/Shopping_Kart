package com.shop.Shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.shop.Shopping.Entity.Product;
import com.shop.Shopping.Entity.ProductVariation;
import com.shop.Shopping.Entity.SpecialProduct;
import com.shop.Shopping.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/products")
    public String showProductsPage(Model model) {
        List<ProductVariation> products = productService.getAllProducts(); // Assuming ProductService has a method to fetch all products
        model.addAttribute("products", products);
        return "products"; // Assuming "products.jsp" is the name of your JSP page
    }

    @GetMapping("/")
    public String home(Model model) {
        // Fetch specific products by their IDs
        SpecialProduct firstProduct = productService.findById(12345L);
        SpecialProduct secondProduct = productService.findById(12346L);
        SpecialProduct thirdProduct = productService.findById(12347L);
        SpecialProduct fourthProduct = productService.findById(12348L);
        SpecialProduct fifthProduct = productService.findById(12349L);
        SpecialProduct sixthProduct = productService.findById(12350L);
        SpecialProduct seventhProduct = productService.findById(12351L);
        SpecialProduct eighthProduct = productService.findById(12352L);
        SpecialProduct ninthProduct = productService.findById(12353L);
        SpecialProduct tenthProduct = productService.findById(12354L);
        SpecialProduct eleventhProduct = productService.findById(12355L);

        // Add the products to the model
        model.addAttribute("firstProduct", firstProduct);
        model.addAttribute("secondProduct", secondProduct);
        model.addAttribute("thirdProduct", thirdProduct);
        model.addAttribute("fourthProduct", fourthProduct);
        model.addAttribute("fifthProduct", fifthProduct);
        model.addAttribute("sixthProduct", sixthProduct);
        model.addAttribute("seventhProduct", seventhProduct);
        model.addAttribute("eighthProduct", eighthProduct);
        model.addAttribute("ninthProduct", ninthProduct);
        model.addAttribute("tenthProduct", tenthProduct);
        model.addAttribute("eleventhProduct", eleventhProduct);

        return "home";
    }

    @GetMapping("/products/{productId}")
    public ModelAndView getProductPage(@PathVariable Long productId) {
        ModelAndView modelAndView = new ModelAndView("productpage");
        // Fetch the product details from the database using the productId
        ProductVariation product = productService.getProductVarById(productId);
        // Pass the product object to the JSP page
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    // Get recommended products based on a product
    @GetMapping("/recommendedProduct/{productId}")
    public ModelAndView getRecommendedProducts(@PathVariable Long productId, Model model) {
        ProductVariation product = productService.getProductVarById(productId);
        model.addAttribute("product", product);

        // Fetch recommended products
        List<ProductVariation> recommendedProducts = productService.getRecommendedProducts(product);
        model.addAttribute("recommendedProducts", recommendedProducts);

        // Return the model and view for rendering the recommendedProduct page
        return new ModelAndView("recommendedProduct"); // Assuming your JSP page is named "recommendedProduct"
    }
    // Get product by ID
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
    
    
    
// Nikhitha

//    // Search products by name
//    @GetMapping("/search")
//    public List<ProductVariation> searchProductsByName(@RequestParam String name) {
//        return productService.searchProductsByName(name);
//    }
//
//    // Search products by type
//    @GetMapping("/searchByType")
//    public List<ProductVariation> searchProductsByType(@RequestParam String type) {
//        return productService.searchProductsByType(type);
//    }
    
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)            
	public String searchProducts(@RequestParam(required = false)String query, Model model) {
 
		if (query != "") {
				// Search by name
				List<ProductVariation> products1= productService.searchByName(query);
				System.out.println(products1);
				
				// Search by type
				List<ProductVariation> products2 = productService.searchByType(query);
				System.out.println(products2);

				if(products1.size()!=0) {
					System.out.println("if");
				model.addAttribute("view", products1);
				}else if(products2.size()!=0){
					System.out.println("else if");
					model.addAttribute("view", products2);
				}else {
					System.out.println("else");
					return "home";
				}
				
			return "productSearch";
		}
		return "home";
	}
    
    
    
    
 // Nikhitha

    // Filter products by gender
    @GetMapping("/filterByGender")
    public List<ProductVariation> filterProductsByGender(@RequestParam String gender) {
        List<ProductVariation> allProducts = productService.getAllProducts();
        return productService.filterProductsByGender(allProducts, gender);
    }
    @GetMapping("/r")
    public List<ProductVariation> getAllProductsRandomOrder() {
        return productService.getAllProductsPage();
    }
    @GetMapping("/random")
    public List<ProductVariation> getRandomProducts(@RequestParam(required = false, defaultValue = "0") int page) {
        int pageSize = 10; // Adjust the page size as needed
        return productService.getRandomProducts(page, pageSize);
    }
    
}
