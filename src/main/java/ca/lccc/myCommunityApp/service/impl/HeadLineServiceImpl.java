package ca.lccc.myCommunityApp.service.impl;

import ca.lccc.myCommunityApp.dao.HeadLineDao;
import ca.lccc.myCommunityApp.entity.HeadLine;
import ca.lccc.myCommunityApp.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    @Override
    @Transactional
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
        return headLineDao.queryHeadLine(headLineCondition);
    }
}
