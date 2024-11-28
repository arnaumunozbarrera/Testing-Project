package main.java.cat.uab.tqs.view;

import java.util.ArrayList;
import java.util.List;

public class MockMessageView extends MessageView {
    private final List<String> messages = new ArrayList<>();

    @Override
    public void showMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void clearMessages() {
        messages.clear();
    }
    
    public boolean containsMessage(String message) {
    	return messages.contains(message);
    }
}
