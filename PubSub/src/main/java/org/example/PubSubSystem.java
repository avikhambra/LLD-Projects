package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PubSubSystem implements Publisher {

    private Map<String, List<Subscriber>> topicSubscribersMap;

    public PubSubSystem() {
        this.topicSubscribersMap = new HashMap<>();
    }

    // Method to subscribe to a topic
    public void subscribe(String topic, Subscriber subscriber) {
        topicSubscribersMap.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    // Method to unsubscribe from a topic
    public void unsubscribe(String topic, Subscriber subscriber) {

        List<Subscriber> subscribersList = topicSubscribersMap.get(topic);

        if (subscribersList != null) {
            subscribersList.remove(subscriber);
            if (subscribersList.isEmpty()) {
                topicSubscribersMap.remove(topic);
            }
        }

    }

    @Override
    public void publishMessage(String topic, Message message) {

        List<Subscriber> subscribersList = topicSubscribersMap.get(topic);

        if (subscribersList != null) {
            for (Subscriber s : subscribersList) {
                s.receiveMessage(message);
            }
        }

    }

}