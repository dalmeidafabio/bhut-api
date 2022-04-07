package com.bhut.api.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.bhut.api.api.domain.model.Car;
import com.bhut.api.api.domain.model.Log;
import com.bhut.api.api.domain.repository.LogRepository;

@RestController
@RequestMapping("apibhut")
public class CarController {

	@Autowired
	LogRepository logRepository;
	
	@GetMapping("listcars")
	public List<Car> list() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("api-test.bhut.com.br")
				.path("api/cars")
				.port(3000)
				.build();
		
		ResponseEntity<Car[]> carsEntity = restTemplate.getForEntity(uri.toString(), Car[].class);
		
		return Arrays.asList(carsEntity.getBody());
	}
	
	@GetMapping("listcars/{id}")
	public ResponseEntity<?> findById(@PathVariable String id){
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			
			UriComponents uri = UriComponentsBuilder.newInstance()
					.scheme("http")
					.host("api-test.bhut.com.br")
					.path("api/cars/" + id)
					.port(3000)
					.build();				
			
			ResponseEntity resposneEntity = restTemplate.getForEntity(uri.toString(), Car.class);
			
			if(resposneEntity.getStatusCode().equals(HttpStatus.OK)) {
				return ResponseEntity.ok(resposneEntity.getBody());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}		
	}
	
	@PostMapping("createcar")
	public ResponseEntity<?> create(@RequestBody Car car) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			UriComponents uri = UriComponentsBuilder.newInstance()
					.scheme("http")
					.host("api-test.bhut.com.br")
					.path("api/cars")
					.port(3000)
					.build();		
			

			
			return restTemplate.postForEntity(uri.toString(), car, String.class);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());			
		} finally {
			Log log = new Log();
			log.setCarId(car.get_id());
			logRepository.save(log);
			System.out.println(log);
		}
	}
}
