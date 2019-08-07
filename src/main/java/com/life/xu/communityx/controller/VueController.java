package com.life.xu.communityx.controller;

import com.life.xu.communityx.util.ResultVOUtil;
import com.life.xu.communityx.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: communityx
 * @description: 小付测试
 * @author: Mr.Xu
 * @create: 2019-08-06 11:14
 **/
@RestController
public class VueController {
    @GetMapping("/getImages")
    public ResultVO getImages(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> objectMap = new HashMap<>(16);
        objectMap.put("url","1");
        objectMap.put("img","https://b2.bmp.ovh/imgs/2019/08/06aefe9e3b2be141.jpg");
        mapList.add(objectMap);
        Map<String, Object> objectMap1 = new HashMap<>(16);
        objectMap1.put("url","");
        objectMap1.put("img","https://b2.bmp.ovh/imgs/2019/08/dc140b34618dd330.jpg");
        mapList.add(objectMap1);
        return ResultVOUtil.success(mapList);
    }
}
