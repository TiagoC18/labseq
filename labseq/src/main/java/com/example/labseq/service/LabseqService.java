package com.example.labseq.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LabseqService {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public LabseqService() {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 0);
        cache.put(3, 1);
    }

    public int getLabseq(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        for (int i = 4; i <= n; i++) {
            cache.putIfAbsent(i, cache.get(i - 4) + cache.get(i - 3));
        }

        return cache.get(n);
    }
}