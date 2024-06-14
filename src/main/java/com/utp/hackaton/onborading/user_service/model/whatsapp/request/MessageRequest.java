package com.utp.hackaton.onborading.user_service.model.whatsapp.request;

import lombok.Builder;

@Builder
public class MessageRequest {
    private String messaging_product;
    private String to;
    private Text text;

    // Getters and Setters

    public String getMessaging_product() {
        return messaging_product;
    }

    public void setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
