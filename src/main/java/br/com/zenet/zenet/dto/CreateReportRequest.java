package br.com.zenet.zenet.dto;

import lombok.Data;

@Data
public class CreateReportRequest {
	private String title;
	private String description;
	private Long area;
}
