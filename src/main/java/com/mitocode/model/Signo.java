package com.mitocode.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Signo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSigno;
	
	private LocalDate fecha;
	private String temperatura;
	private String pulso;
	private String ritmo;
	
	@ManyToOne
	@JoinColumn(name = "idPatient",nullable = false)
	private Patient patient;
	
}
