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
		return JsonResponse.ReadSuccess(userRepository.findAll());
	}
	
	@GetMapping(path="/Get/{id}")
	public @ResponseBody JsonResponse getUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			return JsonResponse.ReadByPkFailure("User", id);
		}
		return JsonResponse.ReadSuccess(user);
	}
	
	private @ResponseBody JsonResponse saveUser(@RequestBody User user) {
		try {
			userRepository.save(user);
			return new JsonResponse(0, "User Added/Changed.", user, null);
		} catch (DataIntegrityViolationException ex) {
			return new JsonResponse(-1, ex.getRootCause().toString(), null, ex);
		} catch (Exception ex) {
			return new JsonResponse(-2, ex.getMessage(), null, ex);
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
			return new JsonResponse(0, "User Deleted.", user, null);
		} catch (Exception ex) {
			return new JsonResponse(-2, ex.getMessage(), null, ex);
		}
	}
}
