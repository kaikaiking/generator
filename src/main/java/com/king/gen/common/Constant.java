package com.king.gen.common;

/**
 * 枚举常量
 *
 * @author xiongAn
 * @Date 2017/4/27
 */
public class Constant {

    /**
     * 返回状态值
     */
    public enum RESULT {
        /**
         * 成功
         */
        CODE_YES("0"),
        /**
         * 失败
         */
        CODE_NO("-1"),
        /**
         * 失败msg
         */
        MSG_YES("操作成功"),
        /**
         * 失败msg
         */
        MSG_NO("操作失败");

        private String value;

        RESULT(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    /**
     * 代码生成方式
     */
    public enum genType {
        /**
         * 本地项目
         */
        local(0),
        /**
         * web下载
         */
        webDown(1);

        private int value;

        genType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
