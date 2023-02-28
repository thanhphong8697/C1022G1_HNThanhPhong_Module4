package com.example.service.impl;

import com.example.model.MailBox;
import com.example.repository.IMailRepository;
import com.example.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService {
    @Autowired
    IMailRepository iMailRepository;
    @Override
    public MailBox mailBox() {
        return iMailRepository.mailBox();
    }
}
