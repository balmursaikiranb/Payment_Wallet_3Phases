package com.cg.paymentwalletspring.repo;

import java.math.BigDecimal;

import com.cg.paymentwalletspring.dto.Customer;
import com.cg.paymentwalletspring.exception.PaymentWalletException;



public interface PaymentWalletRepo {
	Customer registerCustomer(Customer customer) throws PaymentWalletException;
	Customer depositMoney(String phone,BigDecimal balance) throws PaymentWalletException;
Customer withdrawMoney(String phone,BigDecimal balance) throws PaymentWalletException;
Customer fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance) throws PaymentWalletException;
Customer showBalance(String phone) throws PaymentWalletException;
	String printTransaction(String phone) throws PaymentWalletException;
	boolean checkLogin(String number, String password);
	public abstract void commitTransaction();
	public abstract void beginTransaction();
}
