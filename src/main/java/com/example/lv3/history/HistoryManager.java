package com.example.lv3.history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryManager<T extends Number, R> {

    private final List<History<T, R>> histories;

    public HistoryManager() {
        this.histories = new ArrayList<>();
    }

    public void addHistory(History<T, R> history) {
        histories.add(history);
    }

    public List<History<T, R>> getAllHistories() {
        return new ArrayList<>(histories);
    }

    public List<History<T, R>> getHistoriesWithResultGreaterThan(double threshold) {
        return histories.stream()
                .filter(h -> (Double) h.getResult() > threshold)
                .collect(Collectors.toList());
    }

    public void clearHistories() {
        histories.clear();
    }

    public void removeOldHistory() {
        if (histories.isEmpty()) {
            System.out.println("계산 결과가 존재하지 않습니다.");
            return;
        }

        histories.remove(0);
    }
}
