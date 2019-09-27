package com.xahi.reporteddata.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author YangPeng
 * @describe 数据上报返回DTO
 * @date 2019-09-27 15:39
 */
@Getter
@Setter
public class ResultDTO {
    /**
     * 处理结果
     * 0.系统错误；1.处理成功；2.数据校验不通过；
     */
    private String code;

    /**
     * 处理序列号
     * 导入任务的序列号，用于后续下载校验不通过的数据集
     */
    private String batchNumber;

    /**
     * 受理时间戳
     * 格式为yyyyMMddHHmmssSSS
     */
    private String timestamp;
}
