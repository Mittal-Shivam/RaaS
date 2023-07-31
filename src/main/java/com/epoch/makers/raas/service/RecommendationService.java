package com.epoch.makers.raas.service;

import com.epoch.makers.raas.model.Data;
import com.epoch.makers.raas.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epoch.makers.raas.constant.Constants.*;

@Service
public class RecommendationService {

    private final ObjectMapper objectMapper;

    public RecommendationService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<String> getAccountOffers() throws IOException {
        Double kids = 0.0;
        Double travel = 0.0;
        Double supermarkets = 0.0;


        Transaction transactionList1 = objectMapper.readValue(new ClassPathResource("450000_10000000.json").getInputStream(), Transaction.class);
        Transaction transactionList2 = objectMapper.readValue(new ClassPathResource("450000_20000000.json").getInputStream(), Transaction.class);

        for (Data data : transactionList1.getData()) {
            if ("DEBIT".equalsIgnoreCase(data.getTransactionType())) {
                if (AIRLINES.equalsIgnoreCase(data.getCategory().getMerchantCategory2Name())) {
                    travel -= data.getAmount();
                } else if (SUPERMARKETS.equalsIgnoreCase(data.getCategory().getMerchantCategory2Name())) {
                    supermarkets -= data.getAmount();
                } else if (KIDS_SHOPPING.equalsIgnoreCase(data.getCategory().getMerchantCategory2Name())) {
                    kids -= data.getAmount();
                }
            }
        }

        for (Data data : transactionList2.getData()) {
            if ("DEBIT".equalsIgnoreCase(data.getTransactionType())) {
                if (AIRLINES.equalsIgnoreCase(data.getCategory().getMerchantCategory2Name())) {
                    travel -= data.getAmount();
                } else if (SUPERMARKETS.equalsIgnoreCase(data.getCategory().getMerchantCategory2Name())) {
                    supermarkets -= data.getAmount();
                } else if (KIDS_SHOPPING.equalsIgnoreCase(data.getCategory().getMerchantCategory2Name())) {
                    kids -= data.getAmount();
                }
            }
        }

        String travelCard = "You've spent £" + travel + " on travel in past 2 months, try our Reward Black credit card for no fee on purchases abroad with this card and earn 1% back in " +
                "Rewards on supermarket spending";

        String supermarketCard = "You've spent £" + supermarkets + " on purchases at supermarkets in past 2 months, try our Reward credit card to get 1-15% back at chosen MyRewards retailers and earn 1% back in " +
                "Rewards on supermarket spending";

        String childAndTeenProducts = "Explore our child and teen products such as Junior ISA, Child Trust Fund, Pocket money cards for kids and more to build a safe and secure future for your kid!";

        List<String> list = new ArrayList<>();
        list.add(travelCard);
        list.add(supermarketCard);
        if (kids != 0.0)
            list.add(childAndTeenProducts);
        return list;
    }
}
