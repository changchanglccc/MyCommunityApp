package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.BaseTest;
import ca.lccc.myCommunityApp.entity.Area;
import ca.lccc.myCommunityApp.service.impl.AreaServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testAreaList() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList.get(0).getAreaName());
        assertEquals("montreal", areaList.get(0).getAreaName());
    }
}
