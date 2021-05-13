package java6354.edit;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yeah
 */

public class Score6354 {
    private SimpleStringProperty name;
    private SimpleIntegerProperty chinese;
    private SimpleIntegerProperty math;
    private SimpleIntegerProperty english;

    public Score6354() {
    }

    public Score6354(String name, int chinese, int math, int english) {
        this.name = new SimpleStringProperty(name);
        this.chinese = new SimpleIntegerProperty(chinese);
        this.math = new SimpleIntegerProperty(math);
        this.english = new SimpleIntegerProperty(english);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getChinese() {
        return chinese.get();
    }

    public SimpleIntegerProperty chineseProperty() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese.set(chinese);
    }

    public int getMath() {
        return math.get();
    }

    public SimpleIntegerProperty mathProperty() {
        return math;
    }

    public void setMath(int math) {
        this.math.set(math);
    }

    public int getEnglish() {
        return english.get();
    }

    public SimpleIntegerProperty englishProperty() {
        return english;
    }

    public void setEnglish(int english) {
        this.english.set(english);
    }

    @Override
    public String toString() {
        return "Score6354{" +
                "name=" + name +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
}
