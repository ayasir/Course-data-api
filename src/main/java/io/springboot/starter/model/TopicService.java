package io.springboot.starter.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring description"),
			new Topic("Hibernate","Hibernate Framework","Hibernate description"),
			new Topic("Springboot","Springboot Framework","Springboot description")
			));
	
	public List<Topic> getAllTopics(){
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
		
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		topicRepository.save(topic);
		
	}

	public void deleteTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
		
	}
}
