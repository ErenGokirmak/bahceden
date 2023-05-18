package com.swifties.bahceden.models;

public class Order implements Retrievable<Order> {

    public enum ShipmentType {
        CUSTOMER_PICKUP, PRODUCER_DELIVERY, SHIPMENT
    }

    public enum OrderStatus {
        IN_CART, PENDING, DELIVERED, CANCELLED
    }

    private int id;
    private String dateOfPurchase;
    private Product product;
    private int amount;
    private double totalPrice;
    private Customer customer;
    private ShipmentType shipmentType;
    private Address address;
    private OrderStatus orderStatus;

    public Order(int id) {
        this.id = id;
        this.amount = 1;
    }

    private void calculateTotalPrice() {
        totalPrice = amount * product.getPricePerUnit();
    }

    public boolean offsetAmountBy(int offset) {
        if (amount + offset < 1) return false;
        amount += offset;
        return true;
    }

    public int getId() {
        return id;
    }

    @Override
    public void fillFrom(Order obj) {

    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public Address getAddress() {
        return address;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}