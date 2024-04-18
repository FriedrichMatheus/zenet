package br.com.zenet.zenet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenet.zenet.entity.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
