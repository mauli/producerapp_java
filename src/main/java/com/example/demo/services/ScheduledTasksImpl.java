/**
 * 
 */
package com.example.demo.services;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.bean.WeatherModel;

@Service
@ConfigurationProperties("my.weather")
public class ScheduledTasksImpl implements ScheduledTasks {

	@Autowired
	private KafkaTemplate<String, WeatherModel> kafkaTemplate;

	@Value(value = "${greeting.topic.name}")
	private String greetingTopicName;

	
	@Scheduled(fixedRate = 30000)
	@Override
	public void scheduleTaskWithFixedRate() {
		System.out.println("called server");

		Date date = new Date();
	    
		WeatherModel weather = new WeatherModel(); 
		weather.setHumidity(String.valueOf(ScheduledTasksImpl.rand(0,100)));
		weather.setSiteid(String.valueOf(ScheduledTasksImpl.rand(0,10)));
		weather.setTemperature(String.valueOf(ScheduledTasksImpl.rand(-40, 40)));
		weather.setWindspeed(String.valueOf(ScheduledTasksImpl.rand(-20, 400)) + " km/h");
		weather.setCreatedate(date);
		kafkaTemplate.send(greetingTopicName, weather);
	}

	public static int rand(int min, int max)
	{
		if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
			throw new IllegalArgumentException("Invalid range");
		}

		return new Random().nextInt(max - min + 1) + min;
	}

}
