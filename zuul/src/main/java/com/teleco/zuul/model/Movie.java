package com.teleco.zuul.model;

import lombok.Data;

@Data
public class Movie {
    private String movieId;
    private String movieTitle;
    private String distributor;
    private String releaseDate;
    private String directorFirstName;
    private String directorLastName;
}
