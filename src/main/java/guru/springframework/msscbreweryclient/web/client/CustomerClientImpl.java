package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerClientImpl implements CustomerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";
    public final String CUSTOMER_ID_PATH_V1 = CUSTOMER_PATH_V1 + "/{customerId}";

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return restTemplate.getForObject(CUSTOMER_ID_PATH_V1, CustomerDto.class, customerId);
    }
}
