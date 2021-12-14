package com.bupt.bean;

import lombok.Data;

/**
 * @Author czgggggggg
 * @Date 2021/12/14
 * @Description  通用的返回值的模型
 */
@Data
public class BaseRespVo {
    Object data;//data数据
    int status;//状态值
    String errmsg;//错误信息
}
