package ca.lccc.myCommunityApp.dao;

import ca.lccc.myCommunityApp.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeadLineDao {

    /**
     * 根据传入的查询条件(eg: 头条名查询头条)
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);

    /**
     * 根据头条id返回唯一的头条信息
     */
    HeadLine queryHeadLineById(long lineId);

    /**
     * 根据传入的Id列表查询头条信息(供超级管理员选定删除头条的时候用，主要是处理图片)
     */
    List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);

    /**
     * 插入头条
     */
    int insertHeadLine(HeadLine headLine);

    /**
     * 更新头条信息
     */
    int updateHeadLine(HeadLine headLine);

    /**
     * 删除头条
     */
    int deleteHeadLine(long headLineId);

    /**
     * 批量删除
     */
    int batchDeleteHeadLine(List<Long> lineIdList);
}
