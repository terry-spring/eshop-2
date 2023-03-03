package main.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

	public enum Payment {
		money, card;
	}

	//public Order() {
		//setOrderDetail(new OrderDetail());
	//}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;
	
	@NotNull(message = "{order.date.notnull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "order_date")
	private Date orderDate;

	@Size(max = 20)
	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "payment")
	private Payment payment;

	@Min(value = 0, message = "{order.amount}")
	@Column(name = "amount")
	private BigDecimal amount = new BigDecimal("0");

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetail> orderDetails;

	@Column(name = "update_date")
	private Date updateDate = Date.from(Instant.now());

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public BigDecimal getAmount() {
		return amount.setScale(0, RoundingMode.DOWN);
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetail(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
