package ru.kutnyashenko.ktelabs.testtask.config;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kutnyashenko.ktelabs.testtask.repository.DoctorRepository;
import ru.kutnyashenko.ktelabs.testtask.repository.TicketRepository;
import ru.kutnyashenko.ktelabs.testtask.service.HelloServiceImpl;

@Configuration
public class WSConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Bean
    public Endpoint helloEndpoint() {

        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl(doctorRepository, ticketRepository));
        endpoint.publish("/Create");
        return endpoint;
    }
}
