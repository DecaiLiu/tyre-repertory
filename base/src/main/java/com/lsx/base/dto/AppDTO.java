package com.lsx.base.dto;

import lombok.Data;

/**
 * @author decai.liu
 * @desc 承载应用信息的数据传输实体类
 * @date 2020/03/24
 */
@Data
public class AppDTO extends IdName {

    /**
     * 操作系统（1：ios, 2：Android，3：web）
     */
    private Integer os;

    /**
     * 提供第三方账号的第三方应用ID
     */
    private String accAppId;

    /**
     * 提供推送渠道的第三方应用ID
     */
    private String pushAppId;
}
