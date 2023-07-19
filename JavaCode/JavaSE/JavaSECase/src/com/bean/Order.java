package com.bean;

import com.util.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private int orderId;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private String createDate;
    private float sum;
    private OrderStatusType status = OrderStatusType.UNPAID;
    private int userId;

}
