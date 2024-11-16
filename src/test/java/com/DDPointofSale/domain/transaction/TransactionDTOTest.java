package com.DDPointofSale.domain.transaction;

import com.DDPointofSale.domain.dto.SaleDTO;
import com.DDPointofSale.domain.dto.TransactionDTO;
import com.DDPointofSale.domain.dao.Sale;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.List;


class TransactionDTOTest {

    @Testable
    public static void DTOtesting() throws JsonProcessingException {
        TransactionDTO transactionDTO = new TransactionDTO();

        var sale1 = new SaleDTO();
        var sale2 = new SaleDTO();
        var sale3 = new SaleDTO();

        List<SaleDTO> sales = new ArrayList<>();
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