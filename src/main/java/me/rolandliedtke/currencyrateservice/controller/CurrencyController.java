package me.rolandliedtke.currencyrateservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.rolandliedtke.currencyrateservice.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;

@RestController
@RequestMapping("/api")
@Tag(name = "CurrencyRateAPI", description = "3rd Party API for getting currency rate from NBP API")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Single Endpoint getting currency and days as arguments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CurrencyRate was returned"),
            @ApiResponse(responseCode = "400", description = "400 Bad Request - nieprawidłowo sformułowane zapytanie", content = @Content),
            @ApiResponse(responseCode = "404", description = "404 Not found - brak danych dla prawidłowo określonego zakresu czasowego", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/currency/{currency}")
    public ResponseEntity<String> getMovieById(@PathVariable Currency currency, @RequestParam(defaultValue = "1") Integer days ) {
        return ResponseEntity.ok(currency.getCurrencyCode());
    }
}
