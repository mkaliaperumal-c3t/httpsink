package com.agent511.testutils;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SinkController {

	@Value( "${request.waitsecs}" )
	private Long requestWaitTime;
	
	@GetMapping(path="/**")
    public String receiveGet(HttpServletRequest request) {
		
		System.out.println("Received:" + request.getRequestURL());
        return "OK";
    }
	
	@PostMapping(path="/**")
    public HttpStatus receivePost(HttpServletRequest request) throws IOException {
		
		System.out.println("Received:" + request.getRequestURL());
		System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		if (requestWaitTime > 0) {
			try {
				Thread.sleep(requestWaitTime*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        return HttpStatus.OK;
    }
}
