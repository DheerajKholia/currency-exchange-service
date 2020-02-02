package com.dheeraj.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchnageValue,Long> {
    public ExchnageValue findByFromAndTo(String from, String to);
}
