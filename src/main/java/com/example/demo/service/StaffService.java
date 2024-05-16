package com.example.demo.service;

import com.example.demo.model.StaffDto;
import com.example.demo.repository.StaffRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    @RabbitListener(queues = {"${spring.rabbitmq.queue.name}"})
    public StaffDto save(StaffDto staff){
        return staffRepository.save(staff);
    }
}
