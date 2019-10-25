package ru.itis.models;

public class ContestInfo {
    String status;
    Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ContestInfo{" +
                "status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
