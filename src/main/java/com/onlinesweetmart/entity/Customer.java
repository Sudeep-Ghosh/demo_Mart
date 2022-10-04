package com.onlinesweetmart.entity;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
public class Customer {

	@Id
	@SequenceGenerator(
			name = "customer_sequence",
			sequenceName = "customer_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_sequence"
			)
	private Long userId;

	@Column(name = "UserName")
	private String userName;


	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private Cart cart;
}
