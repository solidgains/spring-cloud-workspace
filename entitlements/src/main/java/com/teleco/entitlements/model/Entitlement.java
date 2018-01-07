package com.teleco.entitlements.model;

import lombok.Data;

import java.util.List;

@Data
public class Entitlement {
    private String entitlementId;
    private String type;
    private boolean isLinear;
    private String entitlementName;
    private List<Movie> movies;
}
