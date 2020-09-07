package review.freeStyle.bigReview.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import review.freeStyle.bigReview.domain.Suser;
import review.freeStyle.bigReview.utils.JDBCUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SuserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public List<Suser> queryForAll(){
        String sql = "select * from suser";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return getSuserList(maps);
    }

    public Suser queryForId(Suser suser){
        try {
            String sql = "select * from suser where id = ?";
            Suser user = template.queryForObject(sql, new BeanPropertyRowMapper<>(Suser.class), suser.getId());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Suser> queryForName(Suser suser){
        String sql = "select * from suser where name = ?";
        List<Map<String, Object>> maps = template.queryForList(sql,suser.getName());
        return getSuserList(maps);
    }


    public List<Suser> getSuserList(List<Map<String,Object>> maps){
        List<Suser> list = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            list.add(new Suser((Integer) map.get("id"),(String)map.get("name"),(String)map.get("gender"),(Integer)map.get("age")
                    ,(String)map.get("location"),(String)map.get("qq"),(String)map.get("email")));
        }
        return list;
    }
}














