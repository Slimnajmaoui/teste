package tn.slim.msarticle.client;


import entities.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("ms-stock")
public interface StockClient {
   // @RequestMapping(method = RequestMethod.GET, value = "/getAll")
   // List<StockDto> getStocks();
   // @RequestMapping(method = RequestMethod.GET, value = "stock/getStock/{id}")
   // StockDto getStockById(@PathVariable Long id);
    // firset coomm//;

    @GetMapping ("stock/getstock/{id}")
    StockDto getStockById(@PathVariable Long id);

}
