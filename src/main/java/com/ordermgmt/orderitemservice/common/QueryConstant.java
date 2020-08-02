package com.ordermgmt.orderitemservice.common;

public interface QueryConstant {
	String GET_ALL_ORDER_ITEM = " SELECT o.order_item_id as orderItemId, o.product_code as productCode, o.product_name as productName, o.quantity as quantity FROM oms.order_item o";

	String INSERT_NEW_ORDER_ITEM  = " INSERT INTO order_item (PRODUCT_CODE, PRODUCT_NAME, QUANTITY, ORDER_ID) "
			+ " VALUES( ?,?,?,?) ";
	
	String GET_ALL_ORDER_ITEM_BY_ID = " SELECT o.order_item_id as orderItemId, o.product_code as productCode, o.product_name as productName, o.quantity as quantity "
			+ " FROM order_item o where o.order_item_id = ?";
	
	String GET_ORDER_ITEM_ID_BY_PRODUCT_CODE = "SELECT o.order_item_id FROM order_item o where o.product_code = ? ";
	
	String GET_ALL_ORDER_ITEM_BY_ORDER_ID = "SELECT o.product_code as productCode, o.product_name as productName, o.quantity as quantity FROM order_item o " 
			 + " where o.order_id = ? ";
}
