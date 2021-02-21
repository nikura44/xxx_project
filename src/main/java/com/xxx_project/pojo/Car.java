package com.xxx_project.pojo;

public class Car {
    private String status;
    private String city;
    private double price;
    private String brand;
    private String model;
    private Integer car_id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "status='" + status + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", car_id=" + car_id +
                '}';
    }
}
