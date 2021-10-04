package dbsharding;

import dbsharding.dao.OrderDao;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * OrderDaoTest
 *
 * @author longhuashen
 * @since 2021-08-21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcSimpleBootstrap.class})
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsertOrder() {
        for (int i = 0; i < 10; i++) {
            orderDao.insertOrder(new BigDecimal(11), 1L, "SUCCESS");
        }
    }

    @Test
    public void testFind() {
        List<Long> ids = Lists.newArrayList();
        ids.add(635906974575230977L);
        ids.add(635943066473070592L);
        List<Map> maps = orderDao.selectOrderByIds(ids);
    }
}
