package com.example.demo.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "surburb_name" }, name = "UK_SUB_NAME") }, indexes = {
		@Index(name = "IDX_POST_CODE", columnList = "post_code", unique = false) })
public class SurburbModel {
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private UUID id;

	@Column(name = "surburb_name")
	@Convert(converter = ListToStringConverter.class)
	private List<String> suburbName;

	@Column(name = "post_code")
	private String postCode;
}
