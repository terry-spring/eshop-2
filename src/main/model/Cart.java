package main.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long cartId;
	
	@NotNull(message = "{cart.date.notnull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cart_date")
	private Date orderDate;
	
//	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{cart.cid.pattern}")
//	@Size(min = 5, max = 20, message = "{cart.cid.size}")
//	@Column(name = "customer_id")
//	private String customerId;
	

	@Min(value = 0, message = "{cart.amount}")
	@Column(name = "amount")
	private BigDecimal amount = new BigDecimal("0");

	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_details_id")
	private OrderDetails orderDetails;
	*/

}
