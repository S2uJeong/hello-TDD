package chap07;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CardNumberValidator {
    public CardValidity validate(String cardNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = null;
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (response.body()) {
                case "ok" : return CardValidity.VALID;
                case "bad" : return CardValidity.INVAID;
                case "expired": return CardValidity.EXPIRED;
                case "theft": return CardValidity.THEFT;
                default: return CardValidity.UNKNOWN;
            }
        } catch (IOException | InterruptedException e) {
            return CardValidity.ERROR;
        }
    }
}
