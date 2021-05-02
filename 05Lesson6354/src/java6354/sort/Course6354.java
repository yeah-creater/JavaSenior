package java6354.sort;

import java.util.Objects;

/**
 * @purpose:
 */
public class Course6354 implements Comparable<Course6354> {
    private String name;
    private String term;
    private String no;
    private int credit;
    private int score;

    public Course6354() {
    }

    public Course6354(String name, String term, String no, int credit, int score) {
        this.name = name;
        this.term = term;
        this.no = no;
        this.credit = credit;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "成绩: " + score + "," + term + "," + credit + "学分," + "【" + no + "】\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course6354 that = (Course6354) o;
        return credit == that.credit &&
                score == that.score &&
                Objects.equals(name, that.name) &&
                Objects.equals(term, that.term) &&
                Objects.equals(no, that.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, term, no, credit, score);
    }

    @Override
    public int compareTo(Course6354 o) {
        if (this.equals(o)) {
            return 0;
        }
        return o.score - score >= 0 ? 1 : -1;
    }
}
