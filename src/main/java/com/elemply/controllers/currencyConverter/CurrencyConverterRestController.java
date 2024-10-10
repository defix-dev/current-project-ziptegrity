package com.elemply.controllers.currencyConverter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.JsonReadContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/currency_converter")
public class CurrencyConverterRestController {
    @GetMapping("/get_data")
    public String getData(@RequestParam String from, @RequestParam String to,
                          @RequestParam int fromValue) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        URI uri = URI.create(String.format("https://cash.rbc.ru/cash/json/converter_currency_rate/?currency_from=%s&currency_to=%s&source=cbrf&sum=%s&date=",
                from, to, fromValue));
        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        return client.send(req, HttpResponse.BodyHandlers.ofString()).body();
    }
}
