package com.valuequo.buckswise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuequo.buckswise.domain.Income;
import com.valuequo.buckswise.domain.SuccessandFailtransaction;
import com.valuequo.buckswise.repository.SuccessandFailRepository;
import com.valuequo.buckswise.security.SecurityUtils;


@Service
public class SuccessAndFailService {
	
	@Autowired
	private SuccessandFailRepository successandFailRepository;
	@Autowired
	private PaymentService paymentService;

	public SuccessandFailtransaction saveTransaction(Long mihpayid, String status, String txnid, String productinfo, String email,
			String amount, String addedon) {
		Long uid = paymentService.getUserid();
		System.out.println(uid);
		SuccessandFailtransaction successfail = new SuccessandFailtransaction(mihpayid, status, txnid, productinfo, email, amount, addedon, uid);
		successfail.setMihpayid(mihpayid);
		successfail.setStatus(status);
		successfail.setTxnid(txnid);
		successfail.setProductinfo(productinfo);
		successfail.setEmail(email);
		successfail.setAmount(amount);
		successfail.setAddedon(addedon);
		successfail.setUserid(uid);
		return successandFailRepository.save(successfail);
	}


	public List<SuccessandFailtransaction> getDetail(Long userid) {
		return successandFailRepository.findByUserid(userid);
	}

}