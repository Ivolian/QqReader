package com.ivo.qqreader.recommend.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ExtInfo {

    /**
     * cashDays : 0
     * data : 0
     * forceLogin : 0
     * monthDays : 0
     * channelStatus : 0
     * show_limit : 0
     * showPosition : 0
     * packageType : 1
     * ref_info :
     * red : 0
     * actionTag : uniteqqreader://nativepage/book/detail?bid=509458
     * data_desc : 登临武道苍穹第一
     * property : 1
     * closeTime : 2017-04-14 11:30:01
     * action : detail
     * tag : 0
     * cash : 0
     * dayHigh : 0
     * chapterLength : 0
     * publishTime : 2017-04-12 11:30:01
     * live_time : 0
     * bookNews : 0
     * black : 0
     * uitype : 1
     * dayLow : 0
     * loginStatus : 0
     * priority : 76
     * userNew : 0
     * actionType : 0
     * month : 0
     * actionId : uniteqqreader://nativepage/book/detail?bid=509458
     * deviceModel :
     * position : 102961
     * category : 0
     */


    @Id(autoincrement = true)
    private Long id;
    private String cashDays;
    private String data;
    private String forceLogin;
    private String monthDays;
    private String channelStatus;
    private String show_limit;
    private String showPosition;
    private String packageType;
    private String ref_info;
    private String red;
    private String actionTag;
    private String data_desc;
    private String property;
    private String closeTime;
    private String action;
    private String tag;
    private String cash;
    private String dayHigh;
    private String chapterLength;
    private String publishTime;
    private String live_time;
    private String bookNews;
    private String black;
    private String uitype;
    private String dayLow;
    private String loginStatus;
    private String priority;
    private String userNew;
    private String actionType;
    private String month;
    private String actionId;
    private String deviceModel;
    private String position;
    private String category;


    @Generated(hash = 1984707400)
    public ExtInfo() {
    }


    @Generated(hash = 155237980)
    public ExtInfo(Long id, String cashDays, String data, String forceLogin,
            String monthDays, String channelStatus, String show_limit,
            String showPosition, String packageType, String ref_info, String red,
            String actionTag, String data_desc, String property, String closeTime,
            String action, String tag, String cash, String dayHigh,
            String chapterLength, String publishTime, String live_time,
            String bookNews, String black, String uitype, String dayLow,
            String loginStatus, String priority, String userNew, String actionType,
            String month, String actionId, String deviceModel, String position,
            String category) {
        this.id = id;
        this.cashDays = cashDays;
        this.data = data;
        this.forceLogin = forceLogin;
        this.monthDays = monthDays;
        this.channelStatus = channelStatus;
        this.show_limit = show_limit;
        this.showPosition = showPosition;
        this.packageType = packageType;
        this.ref_info = ref_info;
        this.red = red;
        this.actionTag = actionTag;
        this.data_desc = data_desc;
        this.property = property;
        this.closeTime = closeTime;
        this.action = action;
        this.tag = tag;
        this.cash = cash;
        this.dayHigh = dayHigh;
        this.chapterLength = chapterLength;
        this.publishTime = publishTime;
        this.live_time = live_time;
        this.bookNews = bookNews;
        this.black = black;
        this.uitype = uitype;
        this.dayLow = dayLow;
        this.loginStatus = loginStatus;
        this.priority = priority;
        this.userNew = userNew;
        this.actionType = actionType;
        this.month = month;
        this.actionId = actionId;
        this.deviceModel = deviceModel;
        this.position = position;
        this.category = category;
    }


    public String getCashDays() {
        return cashDays;
    }

    public void setCashDays(String cashDays) {
        this.cashDays = cashDays;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getForceLogin() {
        return forceLogin;
    }

    public void setForceLogin(String forceLogin) {
        this.forceLogin = forceLogin;
    }

    public String getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(String monthDays) {
        this.monthDays = monthDays;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public String getShow_limit() {
        return show_limit;
    }

    public void setShow_limit(String show_limit) {
        this.show_limit = show_limit;
    }

    public String getShowPosition() {
        return showPosition;
    }

    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getRef_info() {
        return ref_info;
    }

    public void setRef_info(String ref_info) {
        this.ref_info = ref_info;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getActionTag() {
        return actionTag;
    }

    public void setActionTag(String actionTag) {
        this.actionTag = actionTag;
    }

    public String getData_desc() {
        return data_desc;
    }

    public void setData_desc(String data_desc) {
        this.data_desc = data_desc;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(String dayHigh) {
        this.dayHigh = dayHigh;
    }

    public String getChapterLength() {
        return chapterLength;
    }

    public void setChapterLength(String chapterLength) {
        this.chapterLength = chapterLength;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLive_time() {
        return live_time;
    }

    public void setLive_time(String live_time) {
        this.live_time = live_time;
    }

    public String getBookNews() {
        return bookNews;
    }

    public void setBookNews(String bookNews) {
        this.bookNews = bookNews;
    }

    public String getBlack() {
        return black;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public String getUitype() {
        return uitype;
    }

    public void setUitype(String uitype) {
        this.uitype = uitype;
    }

    public String getDayLow() {
        return dayLow;
    }

    public void setDayLow(String dayLow) {
        this.dayLow = dayLow;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getUserNew() {
        return userNew;
    }

    public void setUserNew(String userNew) {
        this.userNew = userNew;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getPosition() {
        return this.position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


}
