import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 19.05.2018.
 */
public class AbstractDAO <T> {
    private Class aClass;
    private Connection conn;
    private String tableName;
    private String createTableQuery;

    public AbstractDAO(Class aClass, Connection conn, String tableName, String createTableQuery) {
        this.aClass = aClass;
        this.conn = conn;
        this.tableName = tableName;
        this.createTableQuery = createTableQuery;
    }

    public void createTableIfNotExists() {
        try (Statement statement = conn.createStatement()) {
            statement.execute(this.createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder fieldsNames = new StringBuilder();
        StringBuilder fieldsValues = new StringBuilder();
        for (Field field: fields) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(Id.class)) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    fieldsNames.append(column.name() + ",");
                } else {
                    fieldsNames.append(field.getName() + ",");
                }
                try {
                    if (field.getType().equals(boolean.class)) {
                        fieldsValues.append(field.get(object) + ",");
                    } else {
                        fieldsValues.append("\"" + field.get(object) + "\",");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        fieldsNames.deleteCharAt(fieldsNames.length() - 1);
        fieldsValues.deleteCharAt(fieldsValues.length() - 1);
        String query = "insert into " + this.tableName + " (" + fieldsNames.toString() + ") values (" + fieldsValues + ");";
        try (Statement statement = conn.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        Field[] fields = this.aClass.getDeclaredFields();
        Field idField = null;
        String idColumnName = "";
        for (Field field: fields) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                idField = field;
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    idColumnName = column.name();
                } else {
                    idColumnName = field.getName();
                }
                break;
            }
        }
        try (Statement statement = conn.createStatement()) {
            String query = "delete from " + this.tableName + " where " + idColumnName + "=\"" + id + "\"";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        Field idField = null;
        String idColumnName = "";
        for (Field field: fields) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                idField = field;
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    idColumnName = column.name();
                } else {
                    idColumnName = field.getName();
                }
                break;
            }
        }
        try (Statement statement = conn.createStatement()) {
            String query = "delete from " + this.tableName + " where " + idColumnName + "=\"" + idField.get(object) + "\"";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public List<T> getAll(Class<T> cls) {
        List<T> result = new ArrayList<>();
        String query = "select * from " + this.tableName;
        try (Statement statement = conn.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    T object = cls.newInstance();
                    Field[] fields = cls.getDeclaredFields();
                    for (Field field: fields) {
                        field.setAccessible(true);
                        String columnName;
                        if (field.isAnnotationPresent(Column.class)) {
                            Column column = field.getAnnotation(Column.class);
                            columnName = column.name();
                        } else {
                            columnName = field.getName();
                        }
                        field.set(object, resultSet.getObject(columnName));
                    }
                    result.add(object);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
