package review.freeStyle.bigReview.test;

import org.junit.Test;
import review.freeStyle.bigReview.dao.SuserDao;
import review.freeStyle.bigReview.domain.Suser;

import java.util.List;


public class SuserDaoTest {

    @Test
    public void queryForAllTest(){
        List<Suser> list = new SuserDao().queryForAll();
        for (Suser suser : list) {
            System.out.println(suser);
        }

    }

    @Test
    public void queryForIdTest(){
        Suser suser = new Suser();
        SuserDao dao = new SuserDao();
        suser.setId(3);
        Suser user = dao.queryForId(suser);
        System.out.println(user);
    }
}
