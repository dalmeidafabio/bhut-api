package com.bhut.api.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhut.api.api.domain.model.Log;
import com.bhut.api.api.domain.repository.LogRepository;

@RestController
@RequestMapping("apibhut")
public class LogController {

	@Autowired
	LogRepository logRepository;
	
	@GetMapping("logs")
	public List<Log> list() {
		return logRepository.findAll();
	}
}
