package com.lsx.base.common.enums;

import com.lsx.base.dto.IdName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author decai.liu
 * @desc 字典类型枚举 0：性别，1：轮胎，2：客户类型，3：付款状态，4：付款方式，5：订单类型，6：订单状态
 * @date 2020/03/24
 */
public enum DictTypeEnum {

    SEX(0, "性别"),
    GOOD_TYPE(1, "商品类型"),
    CUSTOMER_TYPE(2, "客户类型"),
    PAY_STATUS(3, "付款状态"),
    PAY_WAY(4, "付款方式"),
    ORDER_TYPE(5, "订单类型"),
    ORDER_STATUS(6, "订单状态");

    public int value;

    public String phrase;

    private static Map<Integer, String> map = new HashMap();
    public static List<IdName> list = new ArrayList<>();

    static {
        for (DictTypeEnum dictTypeEnum : DictTypeEnum.values()) {
            map.put(dictTypeEnum.value, dictTypeEnum.phrase);
            IdName idName = new IdName();
            idName.setId(Long.valueOf(dictTypeEnum.value));
            idName.setName(dictTypeEnum.phrase);
            list.add(idName);
        }
    }

    DictTypeEnum(int value, String phrase) {
        this.value = value;
        this.phrase = phrase;
    }

    public static DictTypeEnum getByValue(int value) {
        for (DictTypeEnum dictTypeEnum : values()) {
            if (dictTypeEnum.value == value) {
                return dictTypeEnum;
            }
        }
        return null;
    }

    public static String getPhrase(Integer value) {
        return map.get(value) == null ? "未知状态" : map.get(value);
    }
}
