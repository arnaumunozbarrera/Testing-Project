package main.java.cat.uab.tqs.view;

public class MockInputView extends InputView {
    private final int[] inputs;
    private int index = 0;

    public MockInputView(int[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public int getIntInput(String prompt) {
        if (index < inputs.length) {
            return inputs[index++];
        } else {
            throw new RuntimeException("No more inputs available in MockInputView.");
        }
    }
} 
