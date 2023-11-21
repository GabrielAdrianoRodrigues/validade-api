package br.com.thr3team.config.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import br.com.thr3team.domain.exceptions.ClientException;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "gs1-brasil")
public interface GS1BrasilClient {
    String url();
    String clientId();
    String accessToken();

    default String findProduct(long gtin) throws ClientException {
        try {
            return HttpClient.newHttpClient().send(HttpRequest.newBuilder(URI.create(String.format("%s/gs1/v0/product/%s", url(), gtin)))
                .GET()
                .header("client_id", clientId())
                .header("Content-Type", "application/json")
                //.header("access_token", accessToken())
            .build(), BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new ClientException("Erro ao realizar a consulta no GS1", e);
        } 
    }
}
