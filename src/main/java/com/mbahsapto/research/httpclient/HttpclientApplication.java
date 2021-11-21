package com.mbahsapto.research.httpclient;

import java.time.Duration;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HttpclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpclientApplication.class, args);
	}

	/*
	@Bean
	public RequestConfig requestConfig() {
		RequestConfig result = RequestConfig.custom().setConnectionRequestTimeout(10 * 1000)
				.setConnectTimeout(10 * 1000).setSocketTimeout(10 * 1000).build();
		return result;
	}

	@Bean
	public CloseableHttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
			RequestConfig requestConfig) {
		CloseableHttpClient result = HttpClientBuilder.create().setConnectionManager(poolingHttpClientConnectionManager)
				.setDefaultRequestConfig(requestConfig).build();
		return result;
	}

	@Bean(name="restTemplate")
	public RestTemplate restTemplate(HttpClient httpClient) {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}

	@Bean
	public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
		PoolingHttpClientConnectionManager result = new PoolingHttpClientConnectionManager();
		result.setMaxTotal(2000);
		result.setDefaultMaxPerRoute(500);
		return result;
	}
	*/

	@Bean(name="restTemplateDefault")
	public RestTemplate restTemplateDefault(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(10*1000)).setReadTimeout(Duration.ofMillis(10*1000)).build();
	}

}
