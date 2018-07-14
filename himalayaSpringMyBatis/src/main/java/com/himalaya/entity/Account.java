package com.himalaya.entity;

public class Account {
    
	private String account;

    private Double amount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String toString(){
    	return "Account : " + this.getAccount() +", Amount : " + this.getAmount();
    }
}