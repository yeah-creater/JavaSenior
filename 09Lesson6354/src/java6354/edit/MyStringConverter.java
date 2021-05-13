package java6354.edit;

import javafx.util.StringConverter;

import java.util.Objects;

/**
 * @author: yeah
 */
public class MyStringConverter extends StringConverter<Integer> {
    @Override
    public String toString(Integer object) {
        return Objects.toString(object);
    }

    @Override
    public Integer fromString(String string) {
        int input;
        try {
            input = Integer.parseInt(string);
            input = input >= 0 && input <= 100 ? input : -1;
        } catch (Exception e) {
            input = -1;
        }
        return input;
    }
}
