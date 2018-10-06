package com.maxtrain.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.maxtrain.prs.business.purchaserequest.PurchaseRequest;
import com.maxtrain.prs.business.purchaserequest.PurchaseRequestRepository;
import com.maxtrain.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping("/PurchaseRequests")
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody JsonResponse getAllPurchaseRequests() {
		return JsonResponse.readSuccess(purchaseRequestRepository.findAll());
	}
	
	@GetMapping(path="/Get/{id}")
	public @ResponseBody JsonResponse getPurchaseRequest(@PathVariable int id) {
		Optional<PurchaseRequest> purchaseRequest = purchaseRequestRepository.findById(id);
		if(!purchaseRequest.isPresent()) {
			return JsonResponse.readByPkFailure("PurchaseRequest", id);
		}
		return JsonResponse.readSuccess(purchaseRequest);
	}
	
	private @ResponseBody JsonResponse savePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		try {
			purchaseRequestRepository.save(purchaseRequest);
			return JsonResponse.maintAddChangeSuccess(purchaseRequest);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.dataIntegrityViolationError(ex);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}
	
	@PostMapping("/Create")
	public @ResponseBody JsonResponse addPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		return savePurchaseRequest(purchaseRequest);
	}
	@PostMapping("/Change")
	public @ResponseBody JsonResponse changePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		return savePurchaseRequest(purchaseRequest);
	}
	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		try {
			purchaseRequestRepository.delete(purchaseRequest);
			return JsonResponse.maintDeleteSuccess(purchaseRequest);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}

}
