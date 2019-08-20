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
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        if(totalPage == 0){
            totalPage = 1;
        }
        if(page > totalPage && page != 1){
            page = totalPage;
        }

        this.totalPage = totalPage;
        this.page = page;

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

        if (page.equals(totalPage) || totalPage == 0) {
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
        if (pages.contains(totalPage) || totalPage == 0) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
