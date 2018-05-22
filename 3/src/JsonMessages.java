import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;

    public JsonMessages(List<Message> sourceList, int fromIndex) {
        this.list = new ArrayList<>();
        for (int i = fromIndex; i < sourceList.size(); i++)
            list.add(sourceList.get(i));
    }

    public List<Message> getList() {
        return this.list;
        //return Collections.unmodifiableList(list);
    }

    public synchronized String toJSON() {
        if (this.list.size() == 0) return null;
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this.list);
    }
}
