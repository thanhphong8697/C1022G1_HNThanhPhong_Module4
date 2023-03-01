package com.example.service;

import com.example.model.MailBox;

public interface IMailService {
    MailBox mailBox();

    void update(MailBox mailBox);

}
