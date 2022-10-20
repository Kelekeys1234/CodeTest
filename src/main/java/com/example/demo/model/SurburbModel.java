package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class SurburbModel {
	@Id
	@Column(name = "id", unique = true, nullable = false, length=36)
    private String id;
	
	@Column
	@Convert(converter = ListToStringConverter.class)
    private List<String> suburbName;
	
	@Column
	private String postCode;
}
