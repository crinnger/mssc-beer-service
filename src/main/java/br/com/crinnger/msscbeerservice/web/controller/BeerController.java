package br.com.crinnger.msscbeerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crinnger.msscbeerservice.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
		
		//todo implementar
		return new ResponseEntity<BeerDto>(BeerDto.builder().build(),HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto){
		//todo implementar
		return new ResponseEntity<BeerDto>(HttpStatus.CREATED);
	}
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> saveNewBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
		//todo implementar
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}
	

}
