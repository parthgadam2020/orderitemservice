package com.ordermgmt.orderitemservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ordermgmt.orderitemservice.common.OrderItemServiceUtil;
import com.ordermgmt.orderitemservice.domain.ServiceResponse;
import com.ordermgmt.orderitemservice.dto.OrderItemDTO;
import com.ordermgmt.orderitemservice.dto.ProductCodeDTO;
import com.ordermgmt.orderitemservice.service.IOrderItemService;
import com.ordermgmt.orderitemservice.validator.Validator;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/orderitemservice")
public class OrderItemServiceController {
	
	private static final Logger LOGGER = Logger.getLogger(OrderItemServiceController.class);
	
	@Autowired
	IOrderItemService iOrderItemService;
	
	@Autowired
	@Qualifier(value = "orderItemValidator")
	private Validator orderItemValidator;
	
	
	@ApiOperation(value = "Create New Order Item", notes = "Create New Order Item.")
	@RequestMapping(value = "/createOrderItem/{orderId}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ServiceResponse createOrderItem(@RequestBody List<ProductCodeDTO> productCodeList, @PathVariable Integer orderId) {
		LOGGER.debug("...in .createOrderItem controller start.");
		boolean f = iOrderItemService.createOrderItem(productCodeList, orderId);
		return OrderItemServiceUtil.getServiceResponse(f);
	}
	
	@ApiOperation(value = "get All Order Item", notes = "get All Order Item.")
	@RequestMapping(value = "/getAllOrderItem", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ServiceResponse getOrderItem() {
		LOGGER.debug("...in .getAllOrderItem controller start.");
		  List<OrderItemDTO> orderItemList = iOrderItemService.getAllOrderItem();
		return OrderItemServiceUtil.getServiceResponse(orderItemList);
	}
	
	@ApiOperation(value = "get Order Item By Id", notes = "get Order Item By Id.")
	@RequestMapping(value = "/getOrderItemById/{orderItemId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ServiceResponse getOrderItemById(@PathVariable Integer orderItemId) {
		LOGGER.debug("...in .getOrderItemById controller start.");
		  OrderItemDTO orderItem = iOrderItemService.getOrderItemById(orderItemId);
		return OrderItemServiceUtil.getServiceResponse(orderItem);
	}
	
	@ApiOperation(value = "get Order Item Id by product code", notes = "get Order Item Id by product code.")
	@RequestMapping(value = "/getOrderItemIdByProductCode/{productCd}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Integer getOrderItemIdByProductCode(@PathVariable String productCd) {
		LOGGER.debug("...in .getOrderItemIdByProductCode controller start.");
		  Integer orderItemId = iOrderItemService.getOrderItemIdByProductCd(productCd);
		return orderItemId;
	}
	
	@ApiOperation(value = "get Order Item List by order Id", notes = "get Order Item List by order Id")
	@RequestMapping(value = "/getOrderItemListByOrderId/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProductCodeDTO> getOrderItemListByOrderId(@PathVariable Integer orderId) {
		LOGGER.debug("...in .getOrderItemListByOrderId controller start.");
		List<ProductCodeDTO> productCodeList = iOrderItemService.getOrderItemListByOrderId(orderId);
		return productCodeList;
	}
}
