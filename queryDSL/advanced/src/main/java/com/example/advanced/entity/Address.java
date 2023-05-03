package com.example.advanced.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    private String postcode;
    private String address;
    private String addressDetail;

    @Builder
    public Address(String postcode, String address, String addressDetail) {
        this.postcode = postcode;
        this.address = address;
        this.addressDetail = addressDetail;
    }
}
