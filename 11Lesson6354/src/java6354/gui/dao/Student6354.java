package java6354.gui.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yeah
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student6354 {
    private int id;
    private String sno;
    private String sname;
    private int lx1;
    private int lx2;

    public Student6354(String sno, String sname, int lx1, int lx2) {
        this.sno = sno;
        this.sname = sname;
        this.lx1 = lx1;
        this.lx2 = lx2;
    }
}
