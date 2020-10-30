package com.rms.demo.service;

import com.rms.demo.dto.RateDto;
import com.rms.demo.model.Rate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RateService {

    public Rate saveRate(RateDto rateDto) throws Exception;

    public Rate findRateById(Integer rateId) throws Exception;

    public Rate updateRate(Integer rateId, RateDto rateDto) throws Exception;

    public void deleteRateById(Integer rateId) throws Exception;
}
