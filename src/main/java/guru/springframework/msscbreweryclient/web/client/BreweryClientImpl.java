package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        URI uri = restTemplate.postForLocation(BEER_PATH_V1, beerDto);

        return restTemplate.getForObject(uri.getPath(), BeerDto.class);
    }

    @Override
    public BeerDto updateBeer(BeerDto beerDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        restTemplate.put(BEER_BY_ID_PATH_V1, beerDto, beerDto.getId());

        return getBeerById(beerDto.getId());
    }
}
