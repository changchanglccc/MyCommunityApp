package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.dao.AreaDao;
import ca.lccc.myCommunityApp.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(8, areaList.size());
    }
}
