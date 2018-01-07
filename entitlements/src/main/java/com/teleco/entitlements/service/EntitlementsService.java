package com.teleco.entitlements.service;

import com.teleco.entitlements.model.Entitlement;
import com.teleco.entitlements.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntitlementsService {

    public List<Entitlement> retrieveEntitlements(String accountId) {
        List<Entitlement> entitlements = new ArrayList<>();
        Entitlement entitlement = new Entitlement();
        if (accountId.equals("01")) {
            entitlement.setEntitlementId("01");
            entitlement.setEntitlementName("premium");
            entitlement.setLinear(false);
            entitlement.setType("movies");

            Movie movie = new Movie();
            movie.setDirectorFirstName("David");
            movie.setDirectorLastName("Duchovny");
            movie.setDistributor("Universal");
            movie.setMovieId("01");
            movie.setReleaseDate("November 16, 2015");
            movie.setMovieTitle("Iron Man II");

            List<Movie> movies = new ArrayList<>();
            movies.add(movie);
            entitlement.setMovies(movies);

        } else {
            entitlement.setEntitlementId("01");
            entitlement.setEntitlementName("premium");
            entitlement.setLinear(false);
            entitlement.setType("movies");

            Movie movie = new Movie();
            movie.setDirectorFirstName("Roland");
            movie.setDirectorLastName("Emmerich");
            movie.setDistributor("MGM");
            movie.setMovieId("01");
            movie.setMovieTitle("Cast Away");
            movie.setReleaseDate("November 8, 2000");

            List<Movie> movies = new ArrayList<>();
            movies.add(movie);
            entitlement.setMovies(movies);
        }
        entitlements.add(entitlement);
        return entitlements;
    }
}
