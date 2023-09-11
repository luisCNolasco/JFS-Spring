package com.mitocode.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SignoDTO {

	private Integer idSigno;
	
	private LocalDate fecha;
	private String temperatura;
	private String pulso;
	private String ritmo;
	
	private PatientDTO patient;
	
}
