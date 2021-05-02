package java6354.lesson01;

import java.util.Objects;

/**
 * @author Yeah
 * @date 2021/3/10 - 8:51
 */
public class Product6354 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product6354(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "商品:"+name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product6354 that = (Product6354) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
