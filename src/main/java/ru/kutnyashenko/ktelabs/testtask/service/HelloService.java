package ru.kutnyashenko.ktelabs.testtask.service;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

import java.util.Date;

@WebService(targetNamespace = "http://service.ws.schedule/", name = "ScheduleService")
public interface HelloService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "Schedule",
            targetNamespace = "http://service.ws.schedule/",
            className = "ru.kutnyashenko.ktelabs.testtask.service.ScheduleService")
    @ResponseWrapper(localName = "ScheduleResponse",
            targetNamespace = "http://service.ws.schedule/",
            className = "ru.kutnyashenko.ktelabs.testtask.service.ScheduleResponse")
    public String createSchedule(@WebParam(name = "startDataTime", targetNamespace = "") Date startDataTime,
                                 @WebParam(name = "durationTicket", targetNamespace = "") int durationTicket,
                                 @WebParam(name = "doctorId", targetNamespace = "") int doctorId,
                                 @WebParam(name = "countTicketInDay", targetNamespace = "") int countTicketInDay);
}
