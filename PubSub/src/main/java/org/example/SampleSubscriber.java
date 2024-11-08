package org.example;

class SampleSubscriber implements Subscriber {

    private String name;
    public SampleSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println(name + " received message: " + message.getContent());
    }

}
