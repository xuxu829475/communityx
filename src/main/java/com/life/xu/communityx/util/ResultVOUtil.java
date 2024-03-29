package com.life.xu.communityx.util;

import com.life.xu.communityx.vo.ResultVO;

/**
 * @program: supplySAAS_org
 * @description: http返回对象工具类
 * @author: Mr.Xu
 * @create: 2019-07-25 14:56
 **/
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
