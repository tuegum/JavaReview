package review.J3.socket.dataJson.test;

import review.J3.socket.dataJson.dao.GoodsDao;
import review.J3.socket.dataJson.domain.Goods;

import java.util.List;

public class Test {

    @org.junit.Test
    public void GoodsDaoTest(){
        Goods goods = new Goods();
        GoodsDao goodsDao = new GoodsDao();
        goods.setId(3);
        Goods good = goodsDao.Query(goods);
        System.out.println(good);
    }

    @org.junit.Test
    public void findAllTest(){
        List<Goods> list = new GoodsDao().findAll();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }
}
