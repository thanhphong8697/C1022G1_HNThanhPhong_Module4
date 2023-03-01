package com.example.repository.impl;

import com.example.model.MailBox;
import com.example.repository.IMailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MailRepository implements IMailRepository {
    public static MailBox mailBox;

    {
        mailBox = new MailBox("English", 25, false, "Thor, King, Asgard");
    }

    @Override
    public MailBox mailBox() {
        return mailBox;
    }

    @Override
    public void update(MailBox mailBoxUpdate) {
        mailBox.setLanguages(mailBoxUpdate.getLanguages());
        mailBox.setPageSize(mailBoxUpdate.getPageSize());
        mailBox.setSpamsFilter(mailBoxUpdate.isSpamsFilter());
        mailBox.setSignature(mailBoxUpdate.getSignature());
    }
}
