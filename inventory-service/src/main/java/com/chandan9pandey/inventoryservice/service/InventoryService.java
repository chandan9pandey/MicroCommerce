package com.chandan9pandey.inventoryservice.service;

import com.chandan9pandey.inventoryservice.dto.InventoryResponse;
import com.chandan9pandey.inventoryservice.model.Inventory;
import com.chandan9pandey.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
    	
//      // Simulating Timeout
//      log.info("Wait Started");
//      try {
//          Thread.sleep(10000);
//      } catch (InterruptedException e) {
//          log.info("Exception from Thread: ", e);
//      }
//      log.info("Wait Ended");
    	
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}