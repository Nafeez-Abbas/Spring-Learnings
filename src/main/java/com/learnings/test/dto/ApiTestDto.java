package com.learnings.test.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class ApiTestDto implements Serializable {
	
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

}
