package net.codetojoy.waro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result {
    @JsonProperty("card")
    private int card;

    @JsonProperty("message")
    private String message;

    public int getCard() { return card; }
    public void setCard(int card) { this.card = card; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
