package main.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ord_num;
	
	@NotNull(message = "{order.ord_date.notnull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ord_date;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{order.cust_id.pattern}")
	@Size(min = 5, max = 20, message = "{order.cust_id.size}")
	private String cust_id;

	@NotBlank(message = "{order.payment.notblank}")
	@Size(min = 4, max = 20, message = "{order.payment.size}")
	private String payment;
	
	@Min(value = 10, message = "{order.amount}")
	@Max(value = 1000, message = "{order.amount}")
	private BigDecimal amount = new BigDecimal("10");

	public long getOrd_num() {
		return ord_num;
	}

	public void setOrd_num(long ord_num) {
		this.ord_num = ord_num;
	}

	public Date getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
