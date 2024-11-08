package com.example.ecom.libraries;

import com.example.ecom.libraries.models.GLocation;
import org.springframework.stereotype.Component;

@Component
public class GoogleMapAPIAdapter implements MapApiAdapter{

    private GoogleMapsApi googleMapsApi;

    public GoogleMapAPIAdapter() {
        this.googleMapsApi = new GoogleMapsApi();
    }

    @Override
    public int estimate(GLocation src, GLocation dest) {
        return googleMapsApi.estimate(src, dest);
    }
}
