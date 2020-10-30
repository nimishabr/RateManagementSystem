package com.rms.demo.service.impl;

import com.rms.demo.dto.RateDto;
import com.rms.demo.model.Rate;
import com.rms.demo.repository.RateRepository;
import com.rms.demo.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public Rate saveRate(RateDto rateDto) throws Exception {
        Rate rateToSave = new Rate();
        rateToSave.setRateEffectiveDate(rateDto.getRateEffectiveDate());
        rateToSave.setRateExpirationDate(rateDto.getRateExpirationDate());
        rateToSave.setAmount(rateDto.getAmount());
        rateToSave.setRateDescription(rateDto.getRateDescription());
        rateRepository.save(rateToSave);
        return rateToSave;
    }

    @Override
    public Rate findRateById(Integer rateId) throws Exception {
        Rate rate = null;
        try {
            Optional<Rate> rateOptional = rateRepository.findById(rateId);
            if(rateOptional.isPresent()){
                rate = rateOptional.get();
            }
        }catch(Exception e){
            throw new Exception();
        }
        return rate;
    }

    @Override
    public Rate updateRate(Integer rateId, RateDto rateDto) throws Exception {
        Rate rate = null;
        Optional<Rate> rateOptional = rateRepository.findById(rateId);
        if(rateOptional.isPresent()){
            rate = rateOptional.get();
        }

        if(rateDto.getRateEffectiveDate() !=null && rateDto.getRateEffectiveDate() != rate.getRateEffectiveDate()){
            rate.setRateEffectiveDate(rateDto.getRateEffectiveDate());
        }
        if(rateDto.getRateExpirationDate() !=null && rateDto.getRateExpirationDate() != rate.getRateExpirationDate()){
            rate.setRateExpirationDate(rateDto.getRateExpirationDate());
        }
        if(rateDto.getAmount() !=null && rateDto.getAmount() != rate.getAmount()){
            rate.setAmount(rateDto.getAmount());
        }
        if(rateDto.getRateDescription() !=null && rateDto.getRateDescription() != rate.getRateDescription()){
            rate.setRateDescription(rateDto.getRateDescription());
        }
        return rate;
    }

    @Override
    public void deleteRateById(Integer rateId) throws Exception {
        Rate rate = null;
        Optional<Rate> rateOptional = rateRepository.findById(rateId);
        if(rateOptional.isPresent()){
            rate = rateOptional.get();
        }
        if(rate != null){
            rateRepository.delete(rate);
        }
    }
}
