package com.cg.paymentwalletspring.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentwalletspring.dto.Customer;
import com.cg.paymentwalletspring.exception.PaymentWalletException;
import com.cg.paymentwalletspring.service.PaymentWalletService;

@RestController
public class PaymentWalletController {
@Autowired
PaymentWalletService service;
	@RequestMapping(value="/regster",method=RequestMethod.POST)
	public Customer registerCustomer(@RequestBody Customer customer) throws PaymentWalletException
	{
		return service.registerCustomer(customer);
		
	}
	@RequestMapping(value="/deposit/{phone}/{amount}",method=RequestMethod.PUT)
	public Customer deposit(@PathVariable("phone")String phone,@PathVariable("amount")BigDecimal amount) throws PaymentWalletException
	{
		return service.depositMoney(phone,amount);
		
	}
	@RequestMapping(value="/withdraw/{phone}/{amount}",method=RequestMethod.PUT)
	public Customer withdraw(@PathVariable("phone")String phone,@PathVariable("amount")BigDecimal amount) throws PaymentWalletException
	{
		return service.withdrawMoney(phone,amount);
		
	}
	@RequestMapping(value="/deposit/{sourcephone}/{targetphone}/{amount}",method=RequestMethod.PUT)
	public Customer fundTransfer(@PathVariable("sourcephone")String sourcephone,@PathVariable("targetphone")String targetphone,@PathVariable("amount")BigDecimal amount) throws PaymentWalletException
	{
		return service.fundTransfer(sourcephone,targetphone,amount);
		
	}
	@RequestMapping(value="/showbalance/{phone}",method=RequestMethod.GET)
	public Customer showBalance(@PathVariable("phone")String phone) throws PaymentWalletException
	{
		return service.showBalance(phone);
		
	}
	@RequestMapping(value="/deposit/{phone}/{amount}",method=RequestMethod.PUT)
	public String statement(@PathVariable("phone")String phone) throws PaymentWalletException
	{
		return service.printTransaction(phone);
		
	}
	@RequestMapping(value="/deposit/{phone}/{password}",method=RequestMethod.GET)
	public boolean login(@PathVariable("phone")String phone,@PathVariable("password")String password) throws PaymentWalletException
	{
		return service.checkLogin(phone,password);
		
	}
}
