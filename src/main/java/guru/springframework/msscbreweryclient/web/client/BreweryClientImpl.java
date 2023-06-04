package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BreweryClientImpl implements BreweryClient {

    private final RestTemplateBuilder restTemplateBuilder;

    public final String BEER_PATH_V1 = "/api/v1/beer";
    public final String BEER_BY_ID_PATH_V1 = BEER_PATH_V1 + "/{beerId}";

    @Override
    public BeerDto getBeerById(UUID beerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject(BEER_BY_ID_PATH_V1, BeerDto.class, beerId);
    }
}
