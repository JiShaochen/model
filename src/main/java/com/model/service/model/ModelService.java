package com.model.service.model;

import com.model.common.utils.page.PageParam;
import com.model.common.utils.page.PageResult;
import com.model.entity.vo.CourseVO;

/**
 * @author JiShaochen
 * @date 2020/12/7 16:59
 * @desc
 */
public interface ModelService {
    String getTest();

    CourseVO getOne();

    void postTest(CourseVO courseVO);

    PageResult postList(PageParam pageParam);
}
