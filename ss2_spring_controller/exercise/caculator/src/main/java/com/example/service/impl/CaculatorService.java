package com.example.service.impl;

import com.example.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public double caculate(double numberFirst, double numberSecond, String method) {
        switch (method) {
            case "Addition(+)":
                return  numberFirst + numberSecond;
            case "Subtraction(-)":
                return numberFirst - numberSecond;
            case "Multiplication(*)":
                return numberFirst * numberSecond;
            case "Division(/)":
                if (numberSecond == 0) {
                    return 0;
                } else {
                    return  numberFirst / numberSecond;
                }
        }
        return 0;
    }
}
