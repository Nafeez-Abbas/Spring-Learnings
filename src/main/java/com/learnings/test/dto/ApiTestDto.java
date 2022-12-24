package com.learnings.test.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ApiTestDto implements Serializable {
	
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
