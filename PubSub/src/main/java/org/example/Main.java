package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Creating a pub-sub system
        PubSubSystem pubSubSystem = new PubSubSystem();


        // Creating subscribers
        SampleSubscriber subscriber1 = new SampleSubscriber("Subscriber 1");
        SampleSubscriber subscriber2 = new SampleSubscriber("Subscriber 2");


        // Subscribing subscribers to topics
        pubSubSystem.subscribe("topic1", subscriber1);
        pubSubSystem.subscribe("topic2", subscriber2);


        // Publishing messages
        pubSubSystem.publishMessage("topic1", new Message("Hello Vansh from topic 1 give me 100Rs."));
        pubSubSystem.publishMessage("topic2", new Message("Hello Avi from topic 2 give me 350Rs."));

    }
}