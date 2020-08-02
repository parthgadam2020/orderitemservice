package com.ordermgmt.orderitemservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
	private int orderId;
	private String customerName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Date orderDate;
	
	private String shippingAddress;
	
	private Integer orderItemId;
	
	private Long total;
}
