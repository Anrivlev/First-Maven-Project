package ru.example.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring", "Spring desc"),
            new Topic("1", "Uno", "1 desc"),
            new Topic("java", "Java", "Java desc")
    ));

    public List<Topic> getAllTopics() {
        return this.topics;
    }

    public Topic getTopic(String id) {
        return this.topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        this.removeTopic(id);
        this.addTopic(topic);
    }

    public void removeTopic(String id) {
        this.topics.removeIf(t -> t.getId().equals(id));
    }
}
