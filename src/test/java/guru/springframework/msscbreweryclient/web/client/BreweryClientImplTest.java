package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientImplTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void testCreateNewBeer() {
        BeerDto newBeerDto = BeerDto.builder()
                .beerName("New beer")
                .build();

        BeerDto savedBeerDto = breweryClient.saveNewBeer(newBeerDto);

        assertNotNull(savedBeerDto);
    }

    @Test
    void testUpdateBeer() {
        BeerDto newBeerDto = BeerDto.builder()
                .beerName("New beer")
                .beerStyle("IPA")
                .build();

        BeerDto savedBeerDto = breweryClient.saveNewBeer(newBeerDto);

        final String updateStyle = "Lager";
        savedBeerDto.setBeerStyle(updateStyle);
        BeerDto updatedBeerDto = breweryClient.updateBeer(savedBeerDto);

        assertNotNull(updatedBeerDto.getBeerStyle(), updateStyle);
    }

    @Test
    void testDeleteBeer() {
        BeerDto newBeerDto = BeerDto.builder()
                .beerName("New beer")
                .beerStyle("IPA")
                .build();

        BeerDto savedBeerDto = breweryClient.saveNewBeer(newBeerDto);

        breweryClient.deleteBeer(savedBeerDto.getId());

//      verify beer no longer exists
    }
}