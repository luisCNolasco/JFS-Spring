package com.mitocode.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.dto.SignoDTO;
import com.mitocode.model.Signo;
import com.mitocode.service.ISignoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/signos")
@RequiredArgsConstructor
public class SignoController {

	private final ISignoService service;

	@Qualifier("defaultMapper")
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<SignoDTO>> findAll() {
		List<SignoDTO> list = service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SignoDTO> findById(@PathVariable("id") Integer id) {
		SignoDTO dto = this.convertToDto(service.findById(id));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<SignoDTO> save(@Valid @RequestBody SignoDTO dto) {
		Signo obj = service.save(this.convertToEntity(dto));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSigno())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<SignoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SignoDTO dto) {
		dto.setIdSigno(id);
		Signo obj = service.update(this.convertToEntity(dto), id);
		return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Min(1) @PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<SignoDTO>> listPage(Pageable pageable) {
		Page<SignoDTO> page = service.listPage(pageable).map(p -> modelMapper.map(p, SignoDTO.class));
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	private SignoDTO convertToDto(Signo obj) {
		return modelMapper.map(obj, SignoDTO.class);
	}

	private Signo convertToEntity(SignoDTO dto) {
		return modelMapper.map(dto, Signo.class);
	}

}
