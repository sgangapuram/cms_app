package com.srione.cms.api;


import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/profilerconnectedmessage")
public class ProfilerAppConnectController {

    public RestTemplate restTemplate;

    @GetMapping
    public String getResponseMessageFromCMS() throws URISyntaxException {
        restTemplate = new RestTemplate(getClientHttpRequestFactory());
        final String baseUrl = "http://localhost:8994";
        URI uri = new URI(baseUrl);
        return restTemplate.getForObject(uri, String.class);
    }

    private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClient());
        return clientHttpRequestFactory;
    }

    private HttpClient httpClient() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("user", "password"));
        HttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider).build();
        return client;
    }
}

