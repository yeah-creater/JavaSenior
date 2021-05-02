package java6354.lesson01;

import java.util.List;

/**
 * @author Yeah
 * @date 2021/3/10 - 8:50
 */
public class Person6354 {
    private String name;

    public Person6354(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /**
     *
     * @param market 传入要购物的超市
     * @param pName  商品名称
     * @return       超市对象处理来返回信息
     */
    public String shopping(Market6354 market,String pName){
        if(market==null) {
            return "无该超市";
        }
        return market.sell(pName);
    }

    /**
     *
     * @param market 传入要购物的超市
     * @param pList 商品清单
     * @return      超市对象处理来返回信息
     */
    public String shopping(Market6354 market, List<Product6354> pList){
        if(market==null){
            System.out.println("无该超市");
            return null;
        }
        return market.sell(pList);
    }
}
