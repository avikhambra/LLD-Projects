package org.example;

import java.util.ArrayList;
import java.util.List;


class Group {
    private String groupId;
    private String name;
    private List<User> members;
    private User admin;

    public Group(String name, User admin) {
        this.name = name;
        this.admin = admin;
        this.members = new ArrayList<>();
        members.add(admin);
    }

    public void addMember(User member) {
        members.add(member);
    }

    public void removeMember(User member) {
        members.remove(member);
    }

    public List<User> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }
}