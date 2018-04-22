package serializeClass;

/**
 * Created by Yuliia Kulyk on 22.04.2018.
 */
@SaveToFile(path = "src\\serializeClass\\file.txt")
public class TestClass {
    @Save() public String field1;
    @Save() public String field2;
    @Save() public int intField1;
    public String notSerialized;

    public TestClass(String field1, String field2, int intField1, String notSerialized) {
        this.field1 = field1;
        this.field2 = field2;
        this.intField1 = intField1;
        this.notSerialized = notSerialized;
    }

    public TestClass() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public int getIntField1() {
        return intField1;
    }

    public void setIntField1(int intField1) {
        this.intField1 = intField1;
    }

    public String getNotSerialized() {
        return notSerialized;
    }

    public void setNotSerialized(String notSerialized) {
        this.notSerialized = notSerialized;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", intField1=" + intField1 +
                ", notSerialized='" + notSerialized + '\'' +
                '}';
    }
}
