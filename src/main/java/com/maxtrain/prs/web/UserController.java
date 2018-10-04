package com.maxtrain.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.maxtrain.prs.business.user.User;
import com.maxtrain.prs.business.user.UserRepository;
import com.maxtrain.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping(path="/Users")
public class UserController extends BaseController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody JsonResponse getAllUsers() {
		return JsonResponse.readSuccess(userRepository.findAll());
	}
	
	@GetMapping(path="/Get/{id}")
	public @ResponseBody JsonResponse getUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return JsonResponse.readByPkFailure("User", id);
		}
		return JsonResponse.readSuccess(user);
	}
	
	private @ResponseBody JsonResponse saveUser(@RequestBody User user) {
		try {
			userRepository.save(user);
			return JsonResponse.maintAddChangeSuccess(user);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.dataIntegrityViolationError(ex);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}
	
	@PostMapping("/Create")
	public @ResponseBody JsonResponse addUser(@RequestBody User user) {
		return saveUser(user);
	}
	@PostMapping("/Change")
	public @ResponseBody JsonResponse changeUser(@RequestBody User user) {
		return saveUser(user);
	}
	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removeUser(@RequestBody User user) {
		try {
			userRepository.delete(user);
			return JsonResponse.maintDeleteSuccess(user);
		} catch (Exception ex) {
			return JsonResponse.generalExceptionError(ex);
		}
	}
}
