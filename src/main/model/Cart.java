package main.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long cartId;
	
	@NotNull(message = "{cart.date.notnull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cart_date")
	private Date orderDate;
	
/**	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "{cart.cid.pattern}")
	@Size(min = 5, max = 20, message = "{cart.cid.size}")
	@Column(name = "customer_id")
	private String customerId;
*/	

	@Min(value = 0, message = "{cart.amount}")
	@Column(name = "amount")
	private BigDecimal amount = new BigDecimal("0");

	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_details_id")
	private OrderDetails orderDetails;
	*/
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartDetail> cartDetails;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

}
