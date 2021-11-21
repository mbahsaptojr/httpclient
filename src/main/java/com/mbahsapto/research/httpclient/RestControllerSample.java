package com.mbahsapto.research.httpclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/api")
public class RestControllerSample {

    /*
    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @GetMapping("/users")
	public String getDataSample(){

        String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);
		return response;
	}
    */

    @Autowired
    @Qualifier("restTemplateDefault")
    private RestTemplate restTemplateDefault;

   

    @GetMapping("/users/default")
	public String getDataSampleDefault(){

        String response = restTemplateDefault.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);
		return response;
	}


}
