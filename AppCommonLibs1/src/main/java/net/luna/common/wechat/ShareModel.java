package net.luna.common.wechat;

public class ShareModel {

    public String id;

    /**
     * 标题，默认跟应用名一样
     */
    public String title;

    public int iconId;

    /**
     * 详情，貌似分享的时候不会展示这一项
     */
    public String description;

    /**
     * 图标的链接
     */
    public String icon;

    /**
     * 要去到的最终地址
     */
    public String url;

    /**
     * 回调回来地址。
     */
    public String fnUrl;

    public boolean isTimeLine;

}
