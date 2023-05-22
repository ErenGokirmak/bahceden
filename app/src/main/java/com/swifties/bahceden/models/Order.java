package com.swifties.bahceden.models;

public class Order {

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
    private ShipmentType shipmentType;
    private Address deliveryAddress;
    private OrderStatus status;

    private void calculateTotalPrice() {
        totalPrice = amount * product.getPricePerUnit();
    }

    public boolean offsetAmountBy(int offset) {
        if (amount + offset < 1) return false;
        amount += offset;
        return true;
    }

    public Customer getCustomer ()
    {
        return deliveryAddress.getCustomer();
    }

    public int getId() {
        return id;
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

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public OrderStatus getStatus() {
        return status;
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

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}