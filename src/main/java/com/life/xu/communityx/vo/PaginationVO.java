package com.life.xu.communityx.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: communityx
 * @description: 分页VO
 * @author: Mr.Xu
 * @create: 2019-08-12 16:59
 **/
@Data
public class PaginationVO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer pageSize;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void getTotalPage(Integer totalCount){
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }

        if (page > totalPage) {
            page = totalPage;
        }
    }

    public void setPagination(Integer totalCount, Integer page,Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        getTotalPage(totalCount);

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        // 是否展示下一页
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
