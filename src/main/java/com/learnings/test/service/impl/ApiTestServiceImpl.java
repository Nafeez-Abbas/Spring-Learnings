package com.learnings.test.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnings.test.dto.ApiTestDto;
import com.learnings.test.model.ApiTest;
import com.learnings.test.repository.ApiTestRepository;
import com.learnings.test.service.ApiTestService;

//Cmt:5 - Classes will be loaded into the Context container only 
//if they are annotated with @Component / @Service / etc...
//Converts the class into a Spring Bean
@Service
@Transactional
public class ApiTestServiceImpl implements ApiTestService {
	

//	Cmt:6 Inversion of Control - implemented using Dependency Injection
//	Instead of we creating the objects, Spring creates the Objects of the specified Type in run time (IoC)
//	Achieved with Autowiring

//	Cmt:6.1) Instance Variable Autowiring
	@Autowired
	private ApiTestRepository apiTestRepository;
//	the above annotation searches for ApiTestRepository (type of obj) in the Context Container, 
//	creates an object of the matching class and injects into this variable

//	Cmt:6.2) Setter Based Autowiring
//	@Autowired
//	public void setApiTestRepository(ApiTestRepository apiTestRepository) {
//		pre-processing can be added, if any 
//		this.apiTestRepository = apiTestRepository;
//	}

//	Cmt:6.3) Constructor based Autowiring
//	@Autowired
//	public ApiTestServiceImpl(ApiTestRepository apiTestRepository) {
//		this.apiTestRepository = apiTestRepository;
//	}

	@Override
	public ApiTestDto saveData(ApiTestDto input) {
		ApiTest apiTest = new ApiTest();
		apiTest.setName(input.getName());
		apiTest = apiTestRepository.save(apiTest);
		input.setId(apiTest.getId());
		return input;
	}

	@Override
	public ApiTestDto fetchData(Integer id) {
		ApiTestDto apiTestDto = new ApiTestDto();
		Optional<ApiTest> apiTest = apiTestRepository.findById(id);
		if (apiTest.isPresent()) {
			apiTestDto.setId(apiTest.get().getId());
			apiTestDto.setName(apiTest.get().getName());
		}
		return apiTestDto;
	}

	@Override
	public List<ApiTestDto> fetchAll() {
		List<ApiTest> apiTests = apiTestRepository.findAll();
		
		return apiTests.stream().map(d -> {
			ApiTestDto apiTestDto = new ApiTestDto();
			apiTestDto.setId(d.getId());
			apiTestDto.setName(d.getName());
			return apiTestDto;
		}).collect(Collectors.toList());
	}

}
