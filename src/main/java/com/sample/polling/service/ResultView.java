package com.sample.polling.service;

public class ResultView {

    private Double price ;
    private Long responseTime;

    public ResultView(Double price, Long responseTime) {
        this.price = price;
        this.responseTime = responseTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void getResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
