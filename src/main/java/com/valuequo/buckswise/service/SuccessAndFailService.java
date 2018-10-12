package com.valuequo.buckswise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuequo.buckswise.domain.Income;
import com.valuequo.buckswise.domain.SuccessandFailtransaction;
import com.valuequo.buckswise.repository.SuccessandFailRepository;


@Service
public class SuccessAndFailService {
	
	@Autowired
	private SuccessandFailRepository successandFailRepository;


	public SuccessandFailtransaction saveTransaction(String mihpayid, String status, String txnid, String productinfo, String email,
			String amount, String addedon) {
		SuccessandFailtransaction successfail = new SuccessandFailtransaction(mihpayid, status, txnid, productinfo, email, amount, addedon);
		successfail.setMihpayid(mihpayid);
		successfail.setStatus(status);
		successfail.setTxnid(txnid);
		successfail.setProductinfo(productinfo);
		successfail.setEmail(email);
		successfail.setAmount(amount);
		successfail.setAddedon(addedon);
		return successandFailRepository.save(successfail);
	}


	public List<SuccessandFailtransaction> getDetail() {
		return successandFailRepository.findAll();
	}

}
