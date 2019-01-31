package com.valuequo.buckswise.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.*;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import com.valuequo.buckswise.domain.Amc;
import com.valuequo.buckswise.domain.Amfi;
import com.valuequo.buckswise.repository.AmcRepository;
import com.valuequo.buckswise.repository.AmfiRepository;
import com.valuequo.buckswise.service.dto.AmfiDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class AmfiService {

    @Autowired
    private AmfiRepository amfiRepository;

    @Autowired
    private AmcRepository amcRepository;

    private SessionFactory hibernateFactory;

    Session session = null;

    Transaction tx;

    AmfiService(EntityManagerFactory factory) {
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    @Transactional
    @Modifying
    public void save(ArrayList<AmfiDTO> al) {
        List<Amfi> amfiDTO = amfiRepository.findAll();
        if (amfiDTO.isEmpty()) {
            int size = al.size();
            int count = 0;
            ArrayList<Amfi> amf = new ArrayList<Amfi>();
            for (AmfiDTO data : al) {
                Amfi amfi = new Amfi();
                amfi.setDate(data.getDate());
                amfi.setSchemeCode(data.getSchemeCode());
                amfi.setISINDivPayoutISINGrowth(data.getISINDivPayoutISINGrowth());
                amfi.setISINDivReinvestment(data.getISINDivReinvestment());
                amfi.setSchemeName(data.getSchemeName());
                amfi.setNetAssetValue(data.getNetAssetValue());
                amfi.setDate(data.getDate());
                amf.add(amfi);
                if ((count + 1) % 1000 == 0 || (count + 1) == size) {
                    amfiRepository.save(amf);
                }
                count++;
            }
        } else {
            ArrayList<Amfi> amf1 = new ArrayList<Amfi>();
            for (AmfiDTO result : al) {
                Amfi amfi = new Amfi();
                amfi.setDate(result.getDate());
                amfi.setSchemeCode(result.getSchemeCode());
                amfi.setNetAssetValue(result.getNetAssetValue());

                String schemeCode = amfi.getSchemeCode();
                String date = amfi.getDate();
                String nav = amfi.getNetAssetValue();

                Date day = new Date(date);
                int dayValue = day.getDate();
                String dayVal = Integer.toString(dayValue);
                String days = "day" + dayVal;
                update(schemeCode, nav, days);
            }
        }
    }

    public void update(String schemeCode, String nav, String days) {
        String str1 = new String(days);
        Date date = new Date();
        int dayValue = date.getDate();
        String dayVal = Integer.toString(dayValue);
        String currentDay = "day" + dayVal;
        String str2 = new String(currentDay);
        boolean isEqual = str1.equals(str2);
        if (isEqual) {
            try {
                session = this.hibernateFactory.openSession();
                tx = session.beginTransaction();
                String sqlQuery = "UPDATE Amfi a SET a." + days + "=" + nav + " where a.SchemeCode = " + schemeCode;
                Query query = session.createQuery(sqlQuery);
                query.executeUpdate();
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }

    @Transactional
    public void getAmfiCode() {
        List<Amc> amc = amcRepository.findAll();
        for (Amc result : amc) {
            String amc_code = result.getAmc_code();
            amfiRepository.update(amc_code);
        }
    }

    public List<Amfi> getAmcName(String name) {
        List<Amfi> nav = amfiRepository.findByAmc_code(name);
        return nav;

    }

    public List<Amc> getAllAmc() {
        List<Amc> nav = amcRepository.findAll();
        return nav;

    }

}