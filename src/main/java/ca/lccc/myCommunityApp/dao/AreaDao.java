package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 查询所有区域
     * @return areaList
     */
    List<Area> queryArea();
}
