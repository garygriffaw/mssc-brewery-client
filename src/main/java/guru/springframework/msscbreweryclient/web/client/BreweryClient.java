package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

import java.util.UUID;

public interface BreweryClient {
    BeerDto getBeerById(UUID beerId);
}
