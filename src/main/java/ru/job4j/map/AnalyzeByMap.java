package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double sc = 0;
        int count = 0;
    for (Pupil pupil : pupils) {
        for (Subject subject : pupil.subjects()) {
            sc += subject.score();
            count++;
        }
    }
        return sc / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sc = 0;
        int count = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sc += subject.score();
                count++;
            }
            labels.add(new Label(pupil.name(), sc / count));
            sc = 0;
            count = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        double count = 0;
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                    if (map.containsKey(subject.name())) {
                        map.put(subject.name(), subject.score() + map.get(subject.name()));
                    } else {
                        map.put(subject.name(), subject.score());
                    }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            labels.add(new Label(key, value / count));
        }
    return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sc = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sc += subject.score();
            }
            labels.add(new Label(pupil.name(), sc));
            sc = 0;

        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score() + map.get(subject.name()));
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            labels.add(new Label(key, value));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}