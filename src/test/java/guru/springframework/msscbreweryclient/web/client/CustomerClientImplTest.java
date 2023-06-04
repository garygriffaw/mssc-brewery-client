package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientImplTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testCreateNewCustomer() {
        CustomerDto newCustomer = CustomerDto.builder()
                .name("B Halls")
                .build();

        CustomerDto savedDto = customerClient.saveNewCustomer(newCustomer);

        assertNotNull(savedDto);
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto newCustomer = CustomerDto.builder()
                .name("B Halls")
                .build();

        CustomerDto savedDto = customerClient.saveNewCustomer(newCustomer);

        final String updateName = "B Halls 2";
        savedDto.setName(updateName);
        CustomerDto updatedDto = customerClient.updateCustomer(savedDto);

        assertNotNull(updatedDto);
    }
}