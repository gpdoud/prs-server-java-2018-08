package com.maxtrain.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.maxtrain.prs.business.product.Product;
import com.maxtrain.prs.business.product.ProductRepository;
import com.maxtrain.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping("/Products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody JsonResponse getAllProducts() {
		return JsonResponse.readSuccess(productRepository.findAll());
	}
	
	@GetMapping(path="/Get/{id}")
	public @ResponseBody JsonResponse getProduct(@PathVariable int id) {
		Optional<Product> product = productRepository.findById(id);
		if(!product.isPresent()) {
			return JsonResponse.readByPkFailure("Product", id);
		}
		return JsonResponse.readSuccess(product);
	}
	
	private @ResponseBody JsonResponse saveProduct(@RequestBody Product product) {
		try {
			productRepository.save(product);
			return JsonResponse.maintAddChangeSuccess(product);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.dataIntegrityViolationError(ex);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}
	
	@PostMapping("/Create")
	public @ResponseBody JsonResponse addProduct(@RequestBody Product product) {
		return saveProduct(product);
	}
	@PostMapping("/Change")
	public @ResponseBody JsonResponse changeProduct(@RequestBody Product product) {
		return saveProduct(product);
	}
	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removeProduct(@RequestBody Product product) {
		try {
			productRepository.delete(product);
			return JsonResponse.maintDeleteSuccess(product);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}

}
