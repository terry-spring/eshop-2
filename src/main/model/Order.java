package main.model;

import java.math.BigDecimal;
import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Future;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Order {
	
	/*
	public enum Continent {
		AFRICA, ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA;
	}
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ord_num;
	
	@NotNull(message = "{tour.date.notnull}")
	// @Future(message = "{tour.date.future}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ord_date;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{tour.code.pattern}")
	private String cust_id;

	@NotBlank(message = "{tour.name.notblank}")
	@Size(min = 5, max = 20, message = "{tour.name.size}")
	private String payment;
	
	private BigDecimal amount;
	
	public int getId() {
		return ord_num;
	}

	public void setId(int ord_num) {
		this.ord_num = ord_num;
	}
	
	public Date getDate() {
		return ord_date;
	}

	public void setDate(Date ord_date) {
		this.ord_date = ord_date;
	}
	
	public String getCid() {
		return cust_id;
	}

	public void setCid(String cust_id) {
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
	
	/*
	private Continent continent;
	
	@Min(value = 7, message = "{tour.duration}")
	@Max(value = 21, message = "{tour.duration}")
	private int duration;
	
	@Column(name = "all_inclusive")
	private boolean allInclusive = false;

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAllInclusive() {
		return allInclusive;
	}

	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}
	*/
	
}
