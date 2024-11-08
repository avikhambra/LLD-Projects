package com.example.ecom.libraries;

import com.example.ecom.libraries.models.GLocation;
import org.springframework.stereotype.Component;

@Component
public interface MapApiAdapter {
    public int estimate(GLocation src, GLocation dest);
}
