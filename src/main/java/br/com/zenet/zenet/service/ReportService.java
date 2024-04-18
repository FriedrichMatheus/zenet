package br.com.zenet.zenet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zenet.zenet.dto.CreateReportRequest;
import br.com.zenet.zenet.entity.AreaEntity;
import br.com.zenet.zenet.entity.ReportEntity;
import br.com.zenet.zenet.enums.SituationEnum;
import br.com.zenet.zenet.exception.NotFoundException;
import br.com.zenet.zenet.repository.ReportRepository;

@Service
public class ReportService {

	private ReportRepository reportRepository;
	
	public ReportService(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
	
	@Transactional(readOnly = true)
	public List<ReportEntity> getAllReport() {
		return reportRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public ReportEntity getReportById(Long id) throws NotFoundException {
		Optional<ReportEntity> reportEntity = this.reportRepository.findById(id);
		
		return reportEntity.orElseThrow(() -> new NotFoundException("Pedido de suporte não encontrado!"));
	}
	
	@Transactional(readOnly = false)
	public ReportEntity updateSituationReport(Long id, SituationEnum situation) {
		ReportEntity reportEntity = new ReportEntity();
		reportEntity.setId(id);
		reportEntity.setSituation(situation);
		
		return reportRepository.save(reportEntity);
	}
	
	@Transactional(readOnly = false)
	public ReportEntity createReport(CreateReportRequest createReportRequest) {
		AreaEntity areaEntity = new AreaEntity();
		areaEntity.setId(createReportRequest.getArea());
		
		ReportEntity reportEntity = new ReportEntity();
		reportEntity.setTitle(createReportRequest.getTitle());
		reportEntity.setDescription(createReportRequest.getDescription());
//		reportEntity.setArea(areaEntity);
		reportEntity.setSituation(SituationEnum.PENDING);
	
		return reportRepository.save(reportEntity);
	}
	
	
}
