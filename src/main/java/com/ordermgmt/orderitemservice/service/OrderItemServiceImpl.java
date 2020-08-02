package com.ordermgmt.orderitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordermgmt.orderitemservice.dao.IOrderItemDao;
import com.ordermgmt.orderitemservice.dto.OrderItemDTO;
import com.ordermgmt.orderitemservice.dto.ProductCodeDTO;

@Service
@Transactional
public class OrderItemServiceImpl implements IOrderItemService{

	@Autowired
	IOrderItemDao iOrderItemDao;

	/**
	 * {@inheritDoc}
	 */
	public boolean createOrderItem(List<ProductCodeDTO> productCodeList, Integer orderId) {
		return iOrderItemDao.createOrderItem(productCodeList, orderId);
	}
	/**
	 * {@inheritDoc}
	 */
	 public List<OrderItemDTO> getAllOrderItem(){
			return iOrderItemDao.getAllOrderItem();

	 }
	
	 /**
	  * {@inheritDoc}
	  */
	public OrderItemDTO getOrderItemById(Integer orderItemId) {
		return iOrderItemDao.getOrderItemById(orderItemId);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Integer getOrderItemIdByProductCd(String productCd) {
		return iOrderItemDao.getOrderItemIdByProductCd(productCd);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<ProductCodeDTO> getOrderItemListByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		return iOrderItemDao.getOrderItemListByOrderId(orderId);
	}

}
