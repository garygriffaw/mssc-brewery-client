package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        URI uri = restTemplate.postForLocation(CUSTOMER_PATH_V1, customerDto);

        return restTemplate.getForObject(uri.getPath(), CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        restTemplate.put(CUSTOMER_ID_PATH_V1, customerDto, customerDto.getId());

        return getCustomerById(customerDto.getId());
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(CUSTOMER_ID_PATH_V1, customerId);
    }
}
