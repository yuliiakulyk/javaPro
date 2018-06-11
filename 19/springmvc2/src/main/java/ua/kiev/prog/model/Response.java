package ua.kiev.prog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Yuliia Kulyk on 05.06.2018.
 */
@Entity
@Table(name = "Responses")
public class Response {
    @Id
    @GeneratedValue
    private Long id;
    private String answer1;
    private String answer2;
    private String loginName;

    public Response(String answer1, String answer2, String loginName) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.loginName = loginName;
    }

    public Response() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", loginName=" + loginName +
                '}';
    }
}
