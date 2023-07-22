package com.example.orderservice.model;


import com.example.orderservice.dto.OrderRequest;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer orderBy;
    private Date createdDate;
    private Date deliveryDate;
    private Integer productId;

    public Order(OrderRequest orderRequest) {
        this.orderBy=orderRequest.getOrderBy();
        this.productId=orderRequest.getProductId();
        this.createdDate=orderRequest.getCreatedDate();
        this.deliveryDate=orderRequest.getDeliveryDate();
    }


/*    @ManyToMany(mappedBy = "orders")
    private List<User> users;*/

}
