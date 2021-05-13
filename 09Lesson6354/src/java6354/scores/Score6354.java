package java6354.scores;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yeah
 */
@Data
@NoArgsConstructor
public class Score6354 {
    private String name;
    private int chinese;
    private int math;
    private int english;
    private int sum;

    public Score6354(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public int getSum(){
        sum=chinese+math+english;
        return chinese+math+english;
    }
}
