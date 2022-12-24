package com.learnings.test.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learnings.test.dto.ApiTestDto;

@Component
public interface ApiTestService {

	public ApiTestDto saveData(ApiTestDto input);
	
	public ApiTestDto fetchData(Integer id);
	
	public List<ApiTestDto> fetchAll();
	
}
