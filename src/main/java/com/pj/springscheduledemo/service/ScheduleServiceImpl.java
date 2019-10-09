package com.pj.springscheduledemo.service;

import com.pj.springscheduledemo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableAsync
public class ScheduleServiceImpl implements ScheduleService
{
    private Logger logger= LoggerFactory.getLogger(ScheduleServiceImpl.class);

    private final RestTemplate restTemplate;
    private static final String API_URL="http://localhost:8081/api/v1/employee";

    public ScheduleServiceImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Async
    @Scheduled(fixedDelay = 5000)
    @Override
    public void executeScheduleJob()
    {
        logger.info("Asyn Scheduled job started on {}", LocalDateTime.now());
        ResponseEntity<List<Employee>> employeeResponseEntity=restTemplate.exchange(API_URL.concat("/list"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});

        List<Employee> employees=employeeResponseEntity.getBody();

        logger.info("Employees: {}",employees);

    }
}
