package com.DDPointofSale.domain.transaction;

import com.DDPointofSale.domain.sales.Sale;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TransactionDTOTest {

    @Testable
    public static void DTOtesting() throws JsonProcessingException {
        TransactionDTO transactionDTO = new TransactionDTO();

        Sale sale1 = new Sale();
        Sale sale2 = new Sale();
        Sale sale3 = new Sale();
        sale1.setId(1);
        sale2.setId(2);
        sale3.setId(3);

        List<Sale> sales = new ArrayList<>();
        sales.add(sale1);
        sales.add(sale2);
        sales.add(sale3);

        transactionDTO.sales = sales;
        ObjectMapper jsonfromObj = new ObjectMapper();

        System.out.println(jsonfromObj.writeValueAsString(transactionDTO));
    }

    public static void main(String[] args) throws JsonProcessingException {
        DTOtesting();
    }
}