package ua.kiev.prog.model;

/**
 * Created by Yuliia Kulyk on 06.06.2018.
 */
public class AnswerAndCount {
    private String answer;
    private Long count;

    public AnswerAndCount(String answer, Long count) {
        this.answer = answer;
        this.count = count;
    }

    public AnswerAndCount() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AnswerAndCount{" +
                "answer='" + answer + '\'' +
                ", count=" + count +
                '}';
    }
}
