package ca.lccc.myCommunityApp.service;

import ca.lccc.myCommunityApp.entity.HeadLine;

import java.util.List;

public interface HeadLineService {

    /**
     * 根据传入的条件返回指定的头条列表
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition);
}
