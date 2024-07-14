package com.example.labseq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.labseq.service.LabseqService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

@SpringBootTest
class LabseqServiceTest {

    @Autowired
    private LabseqService labseqService;

    @Test
    void testLabseqBaseCases() {
        assertEquals(0, labseqService.getLabseq(0));
        assertEquals(1, labseqService.getLabseq(1));
        assertEquals(0, labseqService.getLabseq(2));
        assertEquals(1, labseqService.getLabseq(3));
    }

    @Test
    void testLabseqValues() {
        assertEquals(1, labseqService.getLabseq(4));
        assertEquals(1, labseqService.getLabseq(5));
        assertEquals(1, labseqService.getLabseq(6));
        assertEquals(2, labseqService.getLabseq(7));
        assertEquals(2, labseqService.getLabseq(8));
        assertEquals(2, labseqService.getLabseq(9));
        assertEquals(3, labseqService.getLabseq(10));
    }

    @Test
    void testLabseqPerformance() {
        assertTimeout(Duration.ofSeconds(10), () -> {
            labseqService.getLabseq(10000);
        });
    }

    @Test
    void testLabseqCaching() {
        int firstCall = labseqService.getLabseq(50);
        int secondCall = labseqService.getLabseq(50);
        assertEquals(firstCall, secondCall, "Cached value should be the same as the first calculated value.");
    }
}