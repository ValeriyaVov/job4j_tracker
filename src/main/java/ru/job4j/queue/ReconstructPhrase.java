package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int arraySize = evenElements.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arraySize; i += 2) {
            stringBuilder.append(evenElements.poll());
            evenElements.poll();

        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        int arraySize = descendingElements.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; arraySize > i; i++) {
            stringBuilder.append(descendingElements.pollLast());
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}