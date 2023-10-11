package com.example.order.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderRequest {
    private Integer id;
    private Integer orderBy;
    private Date createdDate;
    private Date deliveryDate;
    private Integer productId;
}
