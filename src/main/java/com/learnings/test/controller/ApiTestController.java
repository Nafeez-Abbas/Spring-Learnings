package com.learnings.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.test.dto.ApiTestDto;
import com.learnings.test.service.ApiTestService;


//Cmt:9) REST Api - Architectural style - it is a Specification
//data can be passed in many formats - JSON commonly used

//Cmt:9.1) Controller - used to expose server methods as api's
//each method is provided with a url and they can be invoked using that url

@RestController
@RequestMapping("/api")
public class ApiTestController {
	
	@Autowired
	private ApiTestService apiTestService;
	
	@PostMapping(value = "/save")
	public ApiTestDto saveData(@RequestBody ApiTestDto apiTestDto) {
		return apiTestService.saveData(apiTestDto);
	}
	
	@GetMapping(value = "/fetch/{id}")
	public ApiTestDto fetchData(@PathVariable(name = "id") Integer id) {
		return apiTestService.fetchData(id);
	}
	
	@GetMapping(value = "/fetch/all")
	public List<ApiTestDto> fetchAll() {
		return apiTestService.fetchAll();
	}

}
