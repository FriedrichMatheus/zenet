package br.com.zenet.zenet.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.zenet.zenet.enums.SituationEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity(name = "report")
public class ReportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "repo_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repo_user_reporter_id")
	private UserEntity reporter;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repo_user_resolver_id")
	private UserEntity resolver;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repo_area_id")
	private AreaEntity area;
	
	@Column(name = "repo_title", length = 250)
	private String title;

	@Column(name = "repo_description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "repo_situation")
	private SituationEnum situation;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "repo_create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "repo_update_date")
	private Date updateDate;
	
}
