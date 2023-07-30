package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SummaryProjection;

public class SummaryDTO {

	private String sellerName;
    private Double amount;
    
    
	public SummaryDTO(String sellerName, Double amount) {
		super();
		this.sellerName = sellerName;
		this.amount = amount;
	}
    
	 public SummaryDTO(SummaryProjection projection) {
		 	sellerName = projection.getName();
	        amount = projection.getSalesAmount();
	    	//BeanUtils.copyProperties(projection, this);
	    }

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}	

    
}
