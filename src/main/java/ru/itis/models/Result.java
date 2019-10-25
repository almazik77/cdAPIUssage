package ru.itis.models;

import java.util.List;

public class Result {
    private Contest contest;
    private List<Problem> problems;
    private List<RanklistRow> rows;

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public List<RanklistRow> getRows() {
        return rows;
    }

    public void setRows(List<RanklistRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Result{" +
                "contest=" + contest +
                ", problems=" + problems +
                ", rows=" + rows +
                '}';
    }
}
