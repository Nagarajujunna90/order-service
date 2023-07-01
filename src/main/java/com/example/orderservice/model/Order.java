package com.example.orderservice.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderBy;
    private Date orderDate;


/*    @ManyToMany(mappedBy = "orders")
    private List<User> users;*/

}
