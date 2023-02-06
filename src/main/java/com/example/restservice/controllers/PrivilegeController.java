package com.example.restservice.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.restservice.dtos.Privilege;
import com.example.restservice.services.*;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

	@Autowired
	private PrivilegeService privilegeService;

	@GetMapping("")
	public Page<Privilege> privilege(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "itemsPerPage", defaultValue = "0") int itemsPerPage) {
		if (itemsPerPage == 0)
			itemsPerPage = 10;
		var paginator = PageRequest.of(page, itemsPerPage, Sort.by("id").ascending());

		return privilegeService.findAllForList(paginator);
	}

	@GetMapping("/{privilegeId}")
	public Privilege getSingleItem(@PathVariable(value = "privilegeId") String id) throws Exception {
		var result = privilegeService.findByName(id);
		if (result == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CHECK YOUR REQUEST");
		}
		return result;
	}
/*
	@DeleteMapping("/{privilegeId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "OK")
	public void deletePrivilege(@PathVariable(value = "privilegeId") Long id) throws Exception {

		if (privilegeService.findByName(id) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		privilegeService.deleteById(id);
	}
*/
	/*
	@PostMapping // Map ONLY POST Requests
	public ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege) throws Exception {
		if (!privilege.isValid()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(privilegeService.savePrivilege(privilege));
	}

*/
	@PostMapping ("")// Map ONLY POST Requests
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createPrivilege(@RequestBody Collection<Privilege> privileges) throws Exception {
		
		for (Privilege privilege : privileges) {
			if (!privilege.isValid()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
	
			privilegeService.savePrivilege(privilege);
		}
	}
	
	

}
