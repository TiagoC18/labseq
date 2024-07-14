package com.example.labseq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.labseq.service.LabseqService;

@RestController
@RequestMapping("/labseq")
public class LabseqController {

    private final LabseqService labseqService;

    @Autowired
    public LabseqController(LabseqService labseqService) {
        this.labseqService = labseqService;
    }

    @GetMapping("/{n}")
    public ResponseEntity<Object> getLabseqValue(@PathVariable int n) {
        if (n < 0) {
            return new ResponseEntity<>("Index must be a non-negative integer.", HttpStatus.BAD_REQUEST);
        }
        int result = labseqService.getLabseq(n);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
