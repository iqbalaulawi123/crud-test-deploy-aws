package com.example.crudtestdeployaws.dto;

import com.example.crudtestdeployaws.entity.Product;

import java.util.List;

public class ResponseDTO<T>{
    private String status;
    private String message;
    private T data;

    public ResponseDTO(String status, String message, T data) {
        this.status = status;
        this.message=message;
        this.data=data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
