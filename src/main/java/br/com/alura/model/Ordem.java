package br.com.alura.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Setter
@Getter
@Entity
@Table(name="ORDEM")
public class Ordem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preco;
	private String tipo;
	private LocalDateTime data;
	private String status;

	@Column(name="USER_ID")
	private Long userId;
	
	
}
