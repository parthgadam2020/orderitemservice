package com.ordermgmt.orderitemservice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ordermgmt.orderitemservice.common.QueryConstant;
import com.ordermgmt.orderitemservice.dto.OrderItemDTO;
import com.ordermgmt.orderitemservice.dto.ProductCodeDTO;


@Repository
public class OrderItemDaoImpl implements IOrderItemDao{
	
	private static final Logger LOGGER = Logger.getLogger(OrderItemDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * {@inheritDoc}
	 */
	public boolean createOrderItem(List<ProductCodeDTO> productCodeList, Integer orderId) {
		if(!CollectionUtils.isEmpty(productCodeList)){
			for(ProductCodeDTO p : productCodeList){
				jdbcTemplate.update(QueryConstant.INSERT_NEW_ORDER_ITEM , p.getProductCode(),
						p.getProductName(), p.getQuantity(), orderId);
			}
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<OrderItemDTO> getAllOrderItem(){
		 String sbSelectQuery = QueryConstant.GET_ALL_ORDER_ITEM;
			return jdbcTemplate.query(sbSelectQuery.toString(),
						new BeanPropertyRowMapper<OrderItemDTO>(OrderItemDTO.class));
	 }

	/**
	 * {@inheritDoc}
	 */
	public OrderItemDTO getOrderItemById(Integer orderItemId) {
		OrderItemDTO orderItemDTO = null;
		try {
			orderItemDTO = jdbcTemplate.queryForObject(QueryConstant.GET_ALL_ORDER_ITEM_BY_ID,
					new BeanPropertyRowMapper<OrderItemDTO>(OrderItemDTO.class),
					new Object[] { orderItemId });
		}
		catch (EmptyResultDataAccessException e) {
			LOGGER.debug("Error while getOrderItemById in OrderItemDaoImpl, " + e.getMessage());
		}
		return orderItemDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer getOrderItemIdByProductCd(String productCd) {
		Integer orderItemId = null;
		try {
			orderItemId = jdbcTemplate.queryForObject(QueryConstant.GET_ORDER_ITEM_ID_BY_PRODUCT_CODE,
					new Object[] { productCd }, Integer.class);
		}
		catch (EmptyResultDataAccessException e) {
			LOGGER.debug("Error while getOrderItemIdByProductCd in OrderItemDaoImpl, " + e.getMessage());
		}
		return orderItemId;
	}

	/**
	 * {@inheritDoc}
	 *
	 */
	public List<ProductCodeDTO> getOrderItemListByOrderId(Integer orderId) {
		 String sbSelectQuery = QueryConstant.GET_ALL_ORDER_ITEM_BY_ORDER_ID;
			return jdbcTemplate.query(sbSelectQuery.toString(), new Object[] { orderId },
						new BeanPropertyRowMapper<ProductCodeDTO>(ProductCodeDTO.class));
	}

}
