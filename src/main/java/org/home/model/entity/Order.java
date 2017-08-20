package org.home.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dOrder")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    private String dishList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;

    public Order() {
    }

    public Order(Customer customer, String dishList) {
        setCustomer(customer);
        setDishList(dishList);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDishList() {
        return dishList;
    }

    public void setDishList(String dishList) {
        this.dishList = dishList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getDishList(), order.getDishList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDishList());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dishList='" + dishList + '\'' +
                '}';
    }
}
