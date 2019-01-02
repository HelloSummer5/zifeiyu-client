package com.zifeiyu.client.common.response;


import com.zifeiyu.client.common.enums.CodeEnum;
import org.springframework.util.StringUtils;

/**
 * @author wujinjuan@qq.com
 * @packagecom.zifeiyu.client.common.response
 * @date 2019/1/2
 */
public class ResponseFactory {

    /**
     * 基础响应格式
     * @param code
     * @param msg
     * @return
     */
    public static ResultBean commonBuild(int code, String msg){
        ResultBean result = new ResultBean();
        result.setCode(code);
        if(StringUtils.isEmpty(msg)){
            result.setMsg(CodeEnum.getMsgDesc(code));
        }else {
            result.setMsg(msg);
        }
        return result;
    }

    public static ResultBean basebuild(int code){
        ResultBean result = commonBuild(code, CodeEnum.getMsgDesc(code));
        return result;
    }

    /**
     * 成功响应
     * @return
     */
    public static ResultBean build(){
        ResultBean result = commonBuild(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 成功响应并返回数据
     * @param data
     * @return
     */
    public static ResultBean build(Object data){
        ResultBean result = commonBuild(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 自定义码code, 并返回数据
     * @param code
     * @param data
     * @return
     */
    public static ResultBean build(int code, Object data){
        ResultBean result = commonBuild(code, CodeEnum.getMsgDesc(code));
        result.setData(data);
        return result;
    }

}
