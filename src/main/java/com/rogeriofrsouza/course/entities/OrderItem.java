package com.rogeriofrsouza.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rogeriofrsouza.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private final OrderItemPK id = new OrderItemPK();
	
	private @Getter @Setter Integer quantity;
	private @Getter @Setter Double price;
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Double getSubTotal() {
		return quantity * price;
	}

}
