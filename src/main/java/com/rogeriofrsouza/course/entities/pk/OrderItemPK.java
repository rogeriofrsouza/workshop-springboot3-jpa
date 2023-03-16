package com.rogeriofrsouza.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.rogeriofrsouza.course.entities.Order;
import com.rogeriofrsouza.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable  // Classe auxiliar utilizada como chave primária composta
public class OrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Referências para as entidades
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	// Não possui construtores

	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	// Compara por Order e Product pois os dois juntos identificam o item
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
}
