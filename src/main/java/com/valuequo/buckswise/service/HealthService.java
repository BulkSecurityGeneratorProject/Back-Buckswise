package com.valuequo.buckswise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuequo.buckswise.domain.Health;
import com.valuequo.buckswise.repository.HealthRepository;

@Service
public class HealthService {

	@Autowired
	private HealthRepository healthRepository;
	
	public Health save(int userid, String insureName, String issuer, String policyMode, String policyName,
			String policyNumber, String premiumName, String premium, String premiumTerm, String date, String sum) {
		Health health = new Health(userid, insureName, issuer, policyMode, policyName, policyNumber, premiumName, premium, premiumTerm, date, sum);
		health.setUserid(userid);
		health.setInsureName(insureName);
		health.setIssuer(issuer);
		health.setPolicyMode(policyMode);
		health.setPolicyName(policyName);
		health.setPolicyNumber(policyNumber);
		health.setPremiumName(premiumName);
		health.setPremium(premium);
		health.setPremiumTerm(premiumTerm);
		health.setDate(date);
		health.setSum(sum);
		healthRepository.save(health);
		
		return null;		
	}

	public List<Health> getDetail(int userid) {
		return healthRepository.findByUserid(userid);
	}

	public Health update(int userid, String insureName, String issuer, String policyMode, String policyName,
			String policyNumber, String premiumName, String premium, String premiumTerm, String date, String sum,
			Long id, Long uid) {
			List<Health> health = healthRepository.findById(id);
			for(Health hInsurence: health) {
				Long tableId = hInsurence.getId();
				if(tableId == id) {
					hInsurence.setInsureName(insureName);
					hInsurence.setIssuer(issuer);
					hInsurence.setPolicyMode(policyMode);
					hInsurence.setPolicyName(policyName);
					hInsurence.setPolicyNumber(policyNumber);
					hInsurence.setPremiumName(premiumName);
					hInsurence.setPremium(premium);
					hInsurence.setPremiumTerm(premiumTerm);
					hInsurence.setDate(date);
					hInsurence.setSum(sum);
					healthRepository.save(hInsurence);
				}
			}
		return null;
	}

	public void delete(Long id) {
		healthRepository.delete(id);
	}
	
}
