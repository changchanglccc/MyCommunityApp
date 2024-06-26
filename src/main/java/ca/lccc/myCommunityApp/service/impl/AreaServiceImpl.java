package ca.lccc.myCommunityApp.service.impl;

import ca.lccc.myCommunityApp.dao.AreaDao;
import ca.lccc.myCommunityApp.entity.Area;
import ca.lccc.myCommunityApp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
