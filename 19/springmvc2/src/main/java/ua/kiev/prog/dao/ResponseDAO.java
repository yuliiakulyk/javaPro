package ua.kiev.prog.dao;

import ua.kiev.prog.model.AnswerAndCount;
import ua.kiev.prog.model.Response;

import java.util.List;

/**
 * Created by Yuliia Kulyk on 05.06.2018.
 */
public interface ResponseDAO {
    public void addResponse(Response response);
    public List<Response> getAll();
    public List<AnswerAndCount> getQuestion1Responses();
    public List<AnswerAndCount> getQuestion2Responses();
    public Response getById(long id);
    public Response getByUserName(String userName);
}
