package com.maxtrain.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.maxtrain.prs.business.vendor.Vendor;
import com.maxtrain.prs.business.vendor.VendorRepository;
import com.maxtrain.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping("/Vendors")
public class VendorController extends BaseController {

	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody JsonResponse getAllVendors() {
		return JsonResponse.readSuccess(vendorRepository.findAll());
	}
	
	@GetMapping(path="/Get/{id}")
	public @ResponseBody JsonResponse getVendor(@PathVariable int id) {
		Optional<Vendor> vendor = vendorRepository.findById(id);
		if(!vendor.isPresent()) {
			return JsonResponse.readByPkFailure("Vendor", id);
		}
		return JsonResponse.readSuccess(vendor);
	}
	
	private @ResponseBody JsonResponse saveVendor(@RequestBody Vendor vendor) {
		try {
			vendorRepository.save(vendor);
			return JsonResponse.maintAddChangeSuccess(vendor);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.dataIntegrityViolationError(ex);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}
	
	@PostMapping("/Create")
	public @ResponseBody JsonResponse addVendor(@RequestBody Vendor vendor) {
		return saveVendor(vendor);
	}
	@PostMapping("/Change")
	public @ResponseBody JsonResponse changeVendor(@RequestBody Vendor vendor) {
		return saveVendor(vendor);
	}
	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removeVendor(@RequestBody Vendor vendor) {
		try {
			vendorRepository.delete(vendor);
			return JsonResponse.maintDeleteSuccess(vendor);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}
}
