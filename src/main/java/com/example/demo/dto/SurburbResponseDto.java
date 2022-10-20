package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurburbResponseDto {

  @JsonProperty("surburb_name")
  @NotBlank(message = "surburb name must not be blank")
  private List<String> surburbName;

  @JsonProperty("post_code")
  @NotBlank(message = "surburb name must not be blank")
  private String postCode;
  
  @JsonProperty("total")
  private long total;

}
