package com.ordermgmt.orderitemservice.validator;

import com.ordermgmt.orderitemservice.domain.ErrorResponse;

public interface Validator {

	ErrorResponse validate(Object objectToValidate);
}
