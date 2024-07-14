package com.example.labseq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LabseqControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetLabseqValue() {
        ResponseEntity<Integer> response = restTemplate.getForEntity("http://localhost:" + port + "/labseq/10", Integer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(3, response.getBody().intValue());
    }

    @Test
    void testInvalidIndex() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/labseq/-1", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Index must be a non-negative integer.", response.getBody());
    }

    @Test
    void testLabseqPerformance() {
        ResponseEntity<Integer> response = restTemplate.getForEntity("http://localhost:" + port + "/labseq/10000", Integer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}