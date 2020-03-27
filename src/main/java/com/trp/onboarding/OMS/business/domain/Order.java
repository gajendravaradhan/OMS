package com.trp.onboarding.OMS.business.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;


/**
 * The type Order.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "useremail")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "userEmail is of invalid pattern")
    @NotBlank(message = "userEmail cannot be blank")
    private String userEmail;

    @Column(name = "ordertime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderTime;

    @Column(name = "ticker")
    @Pattern(regexp = "^([A-Za-z]){1,4}([.:\\-][A-Za-z\\d]{1,2})?$", message = "Ticker pattern is invalid")
    @NotBlank(message = "ticker cannot be blank")
    private String ticker;

    @Column(name = "direction")
    @Pattern(regexp = "^[BSbs]{1}$", message = "direction can only be B,b,S, or s")
    @NotNull(message = "direction cannot be empty")
    private String direction;

    @Column(name = "price")
    @DecimalMin(value = "0.001", message = "Price must be a value above 0.001")
    @NotNull(message = "price cannot be empty")
    private double price;

    @Column(name = "quantity")
    @Min(1)
    @Max(value = Short.MAX_VALUE)
    @NotNull(message = "quantity cannot be empty")
    private int quantity;

    /**
     * Instantiates a new Order.
     *
     * @param id        the id
     * @param userEmail the user email
     * @param orderTime the order time
     * @param ticker    the ticker
     * @param direction the direction
     * @param price     the price
     * @param quantity  the quantity
     */
    public Order(UUID id, String userEmail, LocalDateTime orderTime, String ticker, String direction, double price, int quantity) {
        this.id = id;
        this.userEmail = userEmail;
        this.orderTime = orderTime;
        this.ticker = ticker;
        this.direction = direction;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Order.
     *
     * @param userEmail the user email
     * @param orderTime the order time
     * @param ticker    the ticker
     * @param direction the direction
     * @param price     the price
     * @param quantity  the quantity
     */
    public Order(String userEmail, LocalDateTime orderTime, String ticker, String direction, double price, int quantity) {
        this.userEmail = userEmail;
        this.orderTime = orderTime;
        this.ticker = ticker;
        this.direction = direction;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Order.
     *
     * @param userEmail the user email
     * @param ticker    the ticker
     * @param direction the direction
     * @param price     the price
     * @param quantity  the quantity
     */
    public Order(String userEmail, String ticker, String direction, double price, int quantity) {
        this.userEmail = userEmail;
        this.ticker = ticker;
        this.direction = direction;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Order.
     */
    public Order() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public Order setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     * @return the user email
     */
    public Order setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    /**
     * Gets order time.
     *
     * @return the order time
     */
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    /**
     * Sets order time.
     *
     * @param orderTime the order time
     * @return the order time
     */
    public Order setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    /**
     * Gets ticker.
     *
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Sets ticker.
     *
     * @param ticker the ticker
     * @return the ticker
     */
    public Order setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     * @return the direction
     */
    public Order setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     * @return the price
     */
    public Order setPrice(double price) {
        this.price = price;
        return this;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     * @return the quantity
     */
    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
