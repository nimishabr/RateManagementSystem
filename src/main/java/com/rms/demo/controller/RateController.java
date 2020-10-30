package com.rms.demo.controller;

import com.rms.demo.dto.RateDto;
import com.rms.demo.model.Rate;
import com.rms.demo.service.RateService;
import com.rms.demo.utilities.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rms/demo/rate")
public class RateController {

    @Autowired
    RateService rateService;

    @PostMapping(value = "/addRate")
    public ResponseEntity<?> addRate(@RequestBody RateDto rateDto) {
        ErrorResponse errorResponse = null;
        try {
            Rate savedRate = rateService.saveRate(rateDto);
            return new ResponseEntity<>(savedRate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(500, "internal server error, please contact admin"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/getRate")
    public ResponseEntity<?> getRate(@RequestBody Integer rateId) {
        Rate rate;
        try {
            rate = rateService.findRateById(rateId);
            return new ResponseEntity<>(rate, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(404, "Related not found in RMS"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/updateRate")
    public ResponseEntity<?> updateRate(@PathVariable Integer rateId, RateDto rateDto) {
        Rate rate;
        try {
            rate = rateService.updateRate(rateId, rateDto);
            return new ResponseEntity<>(rate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(417, "Cannot update rate"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(value = "/deleteRate")
    public ResponseEntity<?> deleteRate(@PathVariable Integer rateId) {
        Rate rate;
        try {
            rateService.deleteRateById(rateId);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(417, "Cannot delete rate"), HttpStatus.EXPECTATION_FAILED);
        }
    }

    }

