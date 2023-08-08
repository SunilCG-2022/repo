package com.cg.ms.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.ms.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from , String to);
}
