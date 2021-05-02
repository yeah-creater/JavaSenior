package java6354.lesson01;
import java.util.*;
/**
 * @author Yeah
 * @date 2021/3/10 - 8:50
 */
public class Market6354 {
    private String name;
    //商品及库存
    private  Map<Product6354,Integer> productLeft;

    public Market6354(String name, Map<Product6354, Integer> productLeft) {
        this.name = name;
        this.productLeft = productLeft;
    }

    public String getName() {
        return name;
    }

    public Map<Product6354, Integer> getProductLeft() {
        return productLeft;
    }

    public String sell(String pName){
        Product6354 p=new Product6354(pName);
        if(!productLeft.containsKey(p)) {
            return "无该商品";
        }
        if(productLeft.get(p)==0) {
            return "商品已售空";
        }
        //商品库存-1
        productLeft.put(p,productLeft.getOrDefault(p,0)-1);
        return "购买成功";
    }
    public String sell(List<Product6354> pList){
        for(Product6354 p:pList){
            if(!productLeft.containsKey(p)) {
                return "无" + p.getName()+"\n"+"下单失败";
            }
            if(productLeft.get(p)==0){
                return p.getName() + "已售空"+"下单失败";
            }
        }
        for(Product6354 p:pList) {
            productLeft.put(p,productLeft.getOrDefault(p,0)-1);
        }
        return "下单成功";
    }
    @Override
    public String toString() {
        return "Market6354{" +
                "name='" + name + '\'' +
                ", productLeft=" + productLeft +
                '}';
    }
}
