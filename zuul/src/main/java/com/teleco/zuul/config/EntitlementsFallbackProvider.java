package com.teleco.zuul.config;

import com.google.gson.Gson;
import com.teleco.zuul.model.Entitlement;
import com.teleco.zuul.model.Movie;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
class EntitlementsFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "entitlements";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return 200;
            }

            @Override
            public String getStatusText() {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {
                Entitlement entitlement = new Entitlement();
                entitlement.setEntitlementId("01");
                entitlement.setEntitlementName("premium");
                entitlement.setLinear(false);
                entitlement.setType("movies");

                Movie movie = new Movie();
                movie.setDirectorFirstName("Chris");
                movie.setDirectorLastName("Columbus");
                movie.setDistributor("20th Century Fox");
                movie.setMovieId("01");
                movie.setReleaseDate("November 16, 1990");
                movie.setMovieTitle("Home Alone");

                List<Movie> movies = new ArrayList<>();
                movies.add(movie);
                entitlement.setMovies(movies);

                List<Entitlement> entitlements = new ArrayList<>();
                entitlements.add(entitlement);

                Gson gson = new Gson();
                String entitlementsJson = gson.toJson(entitlements);

                return new ByteArrayInputStream(entitlementsJson.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return 200;
            }

            @Override
            public String getStatusText() {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {
                Entitlement entitlement = new Entitlement();
                entitlement.setEntitlementId("01");
                entitlement.setEntitlementName("premium");
                entitlement.setLinear(false);
                entitlement.setType("movies");

                Movie movie = new Movie();
                movie.setDirectorFirstName("Chris");
                movie.setDirectorLastName("Columbus");
                movie.setDistributor("20th Century Fox");
                movie.setMovieId("01");
                movie.setReleaseDate("November 16, 1990");
                movie.setMovieTitle("Home Alone");

                List<Movie> movies = new ArrayList<>();
                movies.add(movie);
                entitlement.setMovies(movies);

                List<Entitlement> entitlements = new ArrayList<>();
                entitlements.add(entitlement);

                Gson gson = new Gson();
                String entitlementsJson = gson.toJson(entitlements);

                return new ByteArrayInputStream(entitlementsJson.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}