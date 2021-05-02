package java6354.nio2;

import java.util.Objects;

/**
 * @purpose:
 */
public class MyFile6354 implements Comparable<MyFile6354>{
    private String name;
    private String modifiedTime;
    private String type;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public MyFile6354(String name, String modifiedTime, String type, String size) {
        this.name = name;
        this.modifiedTime = modifiedTime;
        this.type = type;
        this.size = size;
    }

    public MyFile6354() {
    }

    public MyFile6354(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyFile6354 that = (MyFile6354) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public int compareTo(MyFile6354 file) {
        if(file.type.compareTo(type)!=0) {
            return file.type.compareTo(type);
        }
        return name.compareTo(file.name);
    }
}
