package com.practicaspring.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSimple {
	
	@Scheduled(fixedDelay=5000) //5 seg.
	public void runJob() {
		System.out.println("Hello!");
	}
}
