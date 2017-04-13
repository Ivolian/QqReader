package com.ivo.qqreader.recommend.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class Ad {

    /**
     * action : detail
     * actiontag : uniteqqreader://nativepage/book/detail?bid=509458
     * category :
     * count : 0
     * descr : 《乾坤剑神》
     * expire_date : 1492140601000
     * id : 70104143
     * image_url : http://wfqqreader.3g.qq.com/cover/topic/newad_69911483_1491965724970.png
     * link_url : uniteqqreader://nativepage/book/detail?bid=509458
     * read_online :
     * start_date : 1491967801000
     * title : 废柴崛起，制霸异世大陆！
     * type : 102961
     * valuetype : 1
     */

    private long extInfoId;

    @ToOne(joinProperty = "extInfoId")
    public ExtInfo extInfo;

    private String action;
    private String actiontag;
    private String category;
    private int count;
    private String descr;
    private long expire_date;
    @Id
    private long id;
    private String image_url;
    private String link_url;
    private String read_online;
    private long start_date;
    private String title;
    private int type;
    private int valuetype;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1364545578)
    private transient AdDao myDao;

    @Generated(hash = 846910398)
    public Ad(long extInfoId, String action, String actiontag, String category, int count, String descr,
            long expire_date, long id, String image_url, String link_url, String read_online,
            long start_date, String title, int type, int valuetype) {
        this.extInfoId = extInfoId;
        this.action = action;
        this.actiontag = actiontag;
        this.category = category;
        this.count = count;
        this.descr = descr;
        this.expire_date = expire_date;
        this.id = id;
        this.image_url = image_url;
        this.link_url = link_url;
        this.read_online = read_online;
        this.start_date = start_date;
        this.title = title;
        this.type = type;
        this.valuetype = valuetype;
    }

    @Generated(hash = 413799064)
    public Ad() {
    }

    @Generated(hash = 1197137580)
    private transient Long extInfo__resolvedKey;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActiontag() {
        return actiontag;
    }

    public void setActiontag(String actiontag) {
        this.actiontag = actiontag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public long getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(long expire_date) {
        this.expire_date = expire_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getRead_online() {
        return read_online;
    }

    public void setRead_online(String read_online) {
        this.read_online = read_online;
    }

    public long getStart_date() {
        return start_date;
    }

    public void setStart_date(long start_date) {
        this.start_date = start_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValuetype() {
        return valuetype;
    }

    public void setValuetype(int valuetype) {
        this.valuetype = valuetype;
    }

    public long getExtInfoId() {
        return this.extInfoId;
    }

    public void setExtInfoId(long extInfoId) {
        this.extInfoId = extInfoId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1171216975)
    public ExtInfo getExtInfo() {
        long __key = this.extInfoId;
        if (extInfo__resolvedKey == null || !extInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExtInfoDao targetDao = daoSession.getExtInfoDao();
            ExtInfo extInfoNew = targetDao.load(__key);
            synchronized (this) {
                extInfo = extInfoNew;
                extInfo__resolvedKey = __key;
            }
        }
        return extInfo;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1490838833)
    public void setExtInfo(@NotNull ExtInfo extInfo) {
        if (extInfo == null) {
            throw new DaoException(
                    "To-one property 'extInfoId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.extInfo = extInfo;
            extInfoId = extInfo.getId();
            extInfo__resolvedKey = extInfoId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 765582737)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAdDao() : null;
    }
}
