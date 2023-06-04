package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerClient {
    CustomerDto getCustomerById(UUID customerId);
}
