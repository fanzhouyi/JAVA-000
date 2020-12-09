package com.commerce.demo.services;

import com.commerce.demo.vo.OrderVO;

import java.util.List;

public interface IOrderService {
    OrderVO findOrderById(Long orderId);

    List<OrderVO> findOrderList(OrderVO orderVO);

    void add(OrderVO orderVO);

    void batchAdd(List<OrderVO> list);

    void createTable();

    void deleteTable();
}
