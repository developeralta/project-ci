package com.developeralta.banca_mifel.model.dto;

public class EncodeRequest {
    private String text;

    public EncodeRequest() {
    }

    public EncodeRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "EncodeRequest [text=" + text + "]";
    }

}
