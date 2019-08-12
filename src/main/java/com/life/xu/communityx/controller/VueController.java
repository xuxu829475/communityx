package com.life.xu.communityx.controller;

import com.life.xu.communityx.util.ResultVOUtil;
import com.life.xu.communityx.vo.NewsVO;
import com.life.xu.communityx.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @program: communityx
 * @description: 小付测试
 * @author: Mr.Xu
 * @create: 2019-08-06 11:14
 **/
@RestController
public class VueController {
    @GetMapping("/getImages")
    public ResultVO getImages(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("url", "1");
        objectMap.put("img", "https://b2.bmp.ovh/imgs/2019/08/06aefe9e3b2be141.jpg");
        mapList.add(objectMap);
        Map<String, Object> objectMap1 = new HashMap<>(16);
        objectMap1.put("url", "");
        objectMap1.put("img", "https://b2.bmp.ovh/imgs/2019/08/dc140b34618dd330.jpg");
        mapList.add(objectMap1);
        return ResultVOUtil.success(mapList);
    }

    @GetMapping("/getNews")
    public ResultVO getNews(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<NewsVO> mapList = new ArrayList<>();
        NewsVO newsVO;
        int i = 10;
        for (int a = 0; a < i; a++) {
            newsVO = new NewsVO();
            newsVO.setId((long) a).setTitle("测试标题：" + a)
                    .setClick((long) (a + 1)).setZhaiyao("摘要：" + a)
                    .setImg_url("https://b2.bmp.ovh/imgs/2019/08/dc140b34618dd330.jpg").setAdd_time(new Date());
            newsVO.setContent(a + "====>给他个合同一句安慰隔热管合同有好感仍然同");
            mapList.add(newsVO);
        }
        return ResultVOUtil.success(mapList);
    }
    @GetMapping("/getNews/{id}")
    public ResultVO getNews(HttpServletResponse response, @PathVariable Long id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        NewsVO newsVO = new NewsVO();
            newsVO.setId(id).setTitle("测试标题：" + id)
                    .setClick((long) (id + 1)).setZhaiyao("摘要：" + id)
                    .setImg_url("https://b2.bmp.ovh/imgs/2019/08/dc140b34618dd330.jpg").setAdd_time(new Date());
            newsVO.setContent(id + "====>给他个合同一句安慰隔热管合同有好感仍然同");

        return ResultVOUtil.success(newsVO);
    }
}
