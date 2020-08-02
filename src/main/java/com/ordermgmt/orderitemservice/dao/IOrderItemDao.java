package com.ordermgmt.orderitemservice.dao;

import java.util.List;

import com.ordermgmt.orderitemservice.dto.OrderItemDTO;
import com.ordermgmt.orderitemservice.dto.ProductCodeDTO;

public interface IOrderItemDao {

	 /**
	  * create Order
	  * 
	  * @param OrderDTO
	  * @return boolean
	  */
	 public boolean createOrderItem(List<ProductCodeDTO> productCodeList, Integer orderId);
	 /**
	  * get all order
	  * @return List<OrderItemDTO>
	  */
	 public List<OrderItemDTO> getAllOrderItem();
	 
	 /**
	  * Get order item by id
	  * 
	  * @param orderItemId
	  * @return OrderItemDTO
	  */
	 public OrderItemDTO getOrderItemById(Integer orderItemId);
	 
	 /**
	  * Get order item id by product code
	  * 
	  * @param productCd
	  * @return Integer
	  */
	 public Integer getOrderItemIdByProductCd(String productCd);
	 
	 /**
	  * get Order Item List By OrderId
	  * @param orderId
	  * @return List<ProductCodeDTO>
	  */
	 public List<ProductCodeDTO> getOrderItemListByOrderId(Integer orderId);
}
