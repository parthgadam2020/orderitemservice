package com.ordermgmt.orderitemservice.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ordermgmt.orderitemservice.common.AppConstant;
import com.ordermgmt.orderitemservice.common.OrderItemServiceUtil;
import com.ordermgmt.orderitemservice.domain.Error;
import com.ordermgmt.orderitemservice.domain.ErrorResponse;
import com.ordermgmt.orderitemservice.dto.OrderItemDTO;

@Component(value = "orderItemValidator" )
public class OrderItemValidatorImpl implements Validator{

	@Override
	public ErrorResponse validate(Object objectToValidate) {
		
	ErrorResponse validationResponse = new ErrorResponse();
	OrderItemDTO orderItemDTO = (OrderItemDTO) objectToValidate;
	
			if(StringUtils.isEmpty(orderItemDTO.getProductCode())) {
				validationResponse.addError(new Error(AppConstant.STR_PRODUCT_CODE_NOT_EMPTY));
			}
			
			if(StringUtils.isEmpty(orderItemDTO.getProductName())) {
				validationResponse.addError(new Error(AppConstant.STR_PRODUCT_NAME_NOT_EMPTY));
			}
			
			if(!OrderItemServiceUtil.hasId(orderItemDTO.getQuantity())) {
				validationResponse.addError(new Error(AppConstant.STR_QUANTITY_DIGIT));
			}
		
		return validationResponse;
	}

}
