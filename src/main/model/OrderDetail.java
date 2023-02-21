package main.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotBlank(message = "{tour.productId.notblank}")
	@Column(name = "order_detail_id")
	private long orderDetailId;
	
	@NotBlank(message = "{tour.productId.notblank}")
	@Column(name = "product_id")
	private long productId;
	
	@NotBlank(message = "{tour.orderId.notblank}")
	@Column(name = "order_id")
	private long orderId;
	
	@NotBlank(message = "{tour.quantity.notblank}")
	@Column(name = "quantity")
	private long quantity;
	
	@NotBlank(message = "{tour.name.notblank}")
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@NotBlank(message = "{tour.name.notblank}")
	private BigDecimal discount;
	
	@ManyToOne
	@JoinColumn(name = "orders_order_id")
	private Order order;

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
