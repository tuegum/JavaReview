package review.J3.socket.dataJson.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import review.J3.socket.dataJson.domain.Goods;
import review.J3.socket.dataJson.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public Goods Query(Goods good){
        try {
            String sql = "select * from goods where id = ? ";
            Goods goods = template.queryForObject(sql, new BeanPropertyRowMapper<>(Goods.class), good.getId());
            return goods;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Goods> findAll(){
        String sql = "select * from goods";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return getGoodList(maps);
    }

    public List<Goods> getGoodList(List<Map<String, Object>> maps){
        List<Goods> list = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            list.add(new Goods((Integer)map.get("id"),(String)map.get("name"),(double)map.get("price"),(String)map.get("location")));
        }
        return list;
    }

}
