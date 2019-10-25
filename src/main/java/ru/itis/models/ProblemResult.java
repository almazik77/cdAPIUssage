package ru.itis.models;

public class ProblemResult {
    Double points;//	Число с плавающей запятой.
    Long penalty;//	Целое число. Пенальти (в ICPC понимании) участника по задаче.
    Long rejectedAttemptCount;//	Целое число. Количество неправильный попыток.
    String type;    //Enum: PRELIMINARY, FINAL. Если имеет значение PRELIMINARY, то количество баллов может уменьшиться (например, если решение не пройдет системное тестирование). Иначе, участник может только лишь увеличить количество баллов, послав решение лучше..
    Long bestSubmissionTimeSeconds;    //Целое число. Время в секундах от начала соревнования до посылки, которая получила максимальный балл по задаче.

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Long getPenalty() {
        return penalty;
    }

    public void setPenalty(Long penalty) {
        this.penalty = penalty;
    }

    public Long getRejectedAttemptCount() {
        return rejectedAttemptCount;
    }

    public void setRejectedAttemptCount(Long rejectedAttemptCount) {
        this.rejectedAttemptCount = rejectedAttemptCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBestSubmissionTimeSeconds() {
        return bestSubmissionTimeSeconds;
    }

    public void setBestSubmissionTimeSeconds(Long bestSubmissionTimeSeconds) {
        this.bestSubmissionTimeSeconds = bestSubmissionTimeSeconds;
    }

    @Override
    public String toString() {
        return "ProblemResult{" +
                "points=" + points +
                ", penalty=" + penalty +
                ", rejectedAttemptCount=" + rejectedAttemptCount +
                ", type=" + type +
                ", bestSubmissionTimeSeconds=" + bestSubmissionTimeSeconds +
                '}';
    }
}
