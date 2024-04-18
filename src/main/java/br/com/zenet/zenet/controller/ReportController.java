package br.com.zenet.zenet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenet.zenet.dto.CreateReportRequest;
import br.com.zenet.zenet.entity.ReportEntity;
import br.com.zenet.zenet.service.ReportService;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

	private ReportService reportService;
	
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok("Hello World!");
	}
	
	@PostMapping
	public ResponseEntity<ReportEntity> createReport(@RequestBody CreateReportRequest createReportRequest) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(reportService.createReport(createReportRequest));
	}
	
}
