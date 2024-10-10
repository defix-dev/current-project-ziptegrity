package com.elemply.controllers.currencyConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services/currency_converter")
public class CurrencyConverterController {
    @GetMapping
    public String currencyConverter() {
        return "currency_converter";
    }
}
