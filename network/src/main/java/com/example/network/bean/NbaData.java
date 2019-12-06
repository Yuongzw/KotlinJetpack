package com.example.network.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/2
 * desc   :
 */
public class NbaData implements Serializable {

    /**
     * result : {"title":"NBA赛事","statuslist":{"st0":"未开赛","st1":"直播中","st2":"已结束"},"list":[{"title":"12-02 周一","tr":[{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc0020023ejign.html","m_link2url":"http://v.qq.com/cover/m/mzc0020023ejign.html","player1":"热火","player1logo":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1url":"","player2":"篮网","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2url":"","score":"109:106","status":"2","time":"12-02 04:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","m_link2url":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","player1":"凯尔特人","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1url":"","player2":"尼克斯","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2url":"","score":"113:104","status":"2","time":"12-02 04:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","m_link2url":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","player1":"灰熊","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1url":"","player2":"森林狼","player2logo":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2url":"","score":"115:107","status":"2","time":"12-02 04:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","m_link2url":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","player1":"独行侠","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1url":"","player2":"湖人","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2url":"","score":"114:100","status":"2","time":"12-02 05:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","m_link2url":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","player1":"马刺","player1logo":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1url":"","player2":"活塞","player2logo":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2url":"","score":"98:132","status":"2","time":"12-02 06:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","m_link2url":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","player1":"雷霆","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1url":"","player2":"鹈鹕","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2url":"","score":"107:104","status":"2","time":"12-02 06:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","m_link2url":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","player1":"勇士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"魔术","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2url":"","score":"96:100","status":"2","time":"12-02 07:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","m_link2url":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","player1":"爵士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"猛龙","player2logo":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2logobig":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2url":"","score":"110:130","status":"2","time":"12-02 07:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","m_link2url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","player1":"奇才","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1url":"","player2":"快船","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2url":"","score":"125:150","status":"2","time":"12-02 11:30"}],"live":[{"liveurl":"http://v.qq.com/cover/m/mzc0020023ejign.html","player1":"热火","player1info":"","player1location":"(客)","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1url":"","player2":"篮网","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2url":"","score":"109:106","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","player1":"凯尔特人","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1url":"","player2":"尼克斯","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2url":"","score":"113:104","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","player1":"灰熊","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1url":"","player2":"森林狼","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2url":"","score":"115:107","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","player1":"独行侠","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1url":"","player2":"湖人","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2url":"","score":"114:100","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","player1":"马刺","player1info":"","player1location":"(客)","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1url":"","player2":"活塞","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2url":"","score":"98:132","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","player1":"雷霆","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1url":"","player2":"鹈鹕","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2url":"","score":"107:104","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","player1":"勇士","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"魔术","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2url":"","score":"96:100","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","player1":"爵士","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"猛龙","player2info":"","player2location":"(主)","player2logobig":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2url":"","score":"110:130","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","player1":"奇才","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1url":"","player2":"快船","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2url":"","score":"125:150","status":"2","title":"12-02  周一"}],"livelink":[{"text":"视频集锦","url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html"},{"text":"技术统计","url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html"}],"bottomlink":[{"text":"常规赛赛程","url":""},{"text":"社区讨论","url":""},{"text":"球队排名","url":"http://nba.stats.qq.com/standings/"},{"text":"球员排名","url":"http://nba.stats.qq.com/stats/detail/?order=defen&type=player"}]},{"title":"12-03 周二","tr":[{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"太阳","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/21.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/21.png","player1url":"","player2":"黄蜂","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/30.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/30.png","player2url":"","score":"0:0","status":"0","time":"12-03 08:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"爵士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"76人","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/20.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/20.png","player2url":"","score":"0:0","status":"0","time":"12-03 08:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"勇士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"老鹰","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/1.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1.png","player2url":"","score":"0:0","status":"0","time":"12-03 08:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"步行者","player1logo":"https://img1.gtimg.com/sports/pics/hv1/43/116/2220/144385123.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/43/116/2220/144385123.png","player1url":"","player2":"灰熊","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player2url":"","score":"0:0","status":"0","time":"12-03 09:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"尼克斯","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player1url":"","player2":"雄鹿","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/15.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/15.png","player2url":"","score":"0:0","status":"0","time":"12-03 09:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"公牛","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/4.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/4.png","player1url":"","player2":"国王","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/23.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/23.png","player2url":"","score":"0:0","status":"0","time":"12-03 11:00"}],"live":null,"livelink":null,"bottomlink":[{"text":"常规赛赛程","url":""},{"text":"社区讨论","url":""},{"text":"球队排名","url":"http://nba.stats.qq.com/standings/"},{"text":"球员排名","url":"http://nba.stats.qq.com/stats/detail/?order=defen&type=player"}]}],"teammatch":[{"name":"老鹰","url":"http://nba.stats.qq.com/schedule/index.htm?team=hawks"},{"name":"凯尔特人","url":"http://nba.stats.qq.com/schedule/index.htm?team=celtics"},{"name":"鹈鹕","url":"http://nba.stats.qq.com/schedule/index.htm?team=pelicans"},{"name":"公牛","url":"http://nba.stats.qq.com/schedule/index.htm?team=bulls"},{"name":"骑士","url":"http://nba.stats.qq.com/schedule/index.htm?team=cavaliers"},{"name":"独行侠","url":"http://nba.stats.qq.com/schedule/index.htm?team=mavericks"},{"name":"掘金","url":"http://nba.stats.qq.com/schedule/index.htm?team=nuggets"},{"name":"活塞","url":"http://nba.stats.qq.com/schedule/index.htm?team=pistons"},{"name":"勇士","url":"http://nba.stats.qq.com/schedule/index.htm?team=warriors"},{"name":"火箭","url":"http://nba.stats.qq.com/schedule/index.htm?team=rockets"},{"name":"步行者","url":"http://nba.stats.qq.com/schedule/index.htm?team=pacers"},{"name":"快船","url":"http://nba.stats.qq.com/schedule/index.htm?team=clippers"},{"name":"湖人","url":"http://nba.stats.qq.com/schedule/index.htm?team=lakers"},{"name":"热火","url":"http://nba.stats.qq.com/schedule/index.htm?team=heat"},{"name":"雄鹿","url":"http://nba.stats.qq.com/schedule/index.htm?team=bucks"},{"name":"森林狼","url":"http://nba.stats.qq.com/schedule/index.htm?team=timberwolves"},{"name":"篮网","url":"http://nba.stats.qq.com/schedule/index.htm?team=nets"},{"name":"尼克斯","url":"http://nba.stats.qq.com/schedule/index.htm?team=knicks"},{"name":"魔术","url":"http://nba.stats.qq.com/schedule/index.htm?team=magic"},{"name":"76人","url":"http://nba.stats.qq.com/schedule/index.htm?team=sixers"},{"name":"太阳","url":"http://nba.stats.qq.com/schedule/index.htm?team=suns"},{"name":"开拓者","url":"http://nba.stats.qq.com/schedule/index.htm?team=blazers"},{"name":"国王","url":"http://nba.stats.qq.com/schedule/index.htm?team=kings"},{"name":"马刺","url":"http://nba.stats.qq.com/schedule/index.htm?team=spurs"},{"name":"雷霆","url":"http://nba.stats.qq.com/schedule/index.htm?team=thunder"},{"name":"爵士","url":"http://nba.stats.qq.com/schedule/index.htm?team=jazz"},{"name":"奇才","url":"http://nba.stats.qq.com/schedule/index.htm?team=wizards"},{"name":"猛龙","url":"http://nba.stats.qq.com/schedule/index.htm?team=raptors"},{"name":"灰熊","url":"http://nba.stats.qq.com/schedule/index.htm?team=grizzlies"},{"name":"黄蜂","url":"http://nba.stats.qq.com/schedule/index.htm?team=hornets"}]}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean implements Serializable {
        /**
         * title : NBA赛事
         * statuslist : {"st0":"未开赛","st1":"直播中","st2":"已结束"}
         * list : [{"title":"12-02 周一","tr":[{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc0020023ejign.html","m_link2url":"http://v.qq.com/cover/m/mzc0020023ejign.html","player1":"热火","player1logo":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1url":"","player2":"篮网","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2url":"","score":"109:106","status":"2","time":"12-02 04:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","m_link2url":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","player1":"凯尔特人","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1url":"","player2":"尼克斯","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2url":"","score":"113:104","status":"2","time":"12-02 04:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","m_link2url":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","player1":"灰熊","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1url":"","player2":"森林狼","player2logo":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2url":"","score":"115:107","status":"2","time":"12-02 04:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","m_link2url":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","player1":"独行侠","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1url":"","player2":"湖人","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2url":"","score":"114:100","status":"2","time":"12-02 05:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","m_link2url":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","player1":"马刺","player1logo":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1url":"","player2":"活塞","player2logo":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2url":"","score":"98:132","status":"2","time":"12-02 06:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","m_link2url":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","player1":"雷霆","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1url":"","player2":"鹈鹕","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2url":"","score":"107:104","status":"2","time":"12-02 06:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","m_link2url":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","player1":"勇士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"魔术","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2url":"","score":"96:100","status":"2","time":"12-02 07:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","m_link2url":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","player1":"爵士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"猛龙","player2logo":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2logobig":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2url":"","score":"110:130","status":"2","time":"12-02 07:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","m_link2url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","player1":"奇才","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1url":"","player2":"快船","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2url":"","score":"125:150","status":"2","time":"12-02 11:30"}],"live":[{"liveurl":"http://v.qq.com/cover/m/mzc0020023ejign.html","player1":"热火","player1info":"","player1location":"(客)","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1url":"","player2":"篮网","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2url":"","score":"109:106","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","player1":"凯尔特人","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1url":"","player2":"尼克斯","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2url":"","score":"113:104","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","player1":"灰熊","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1url":"","player2":"森林狼","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2url":"","score":"115:107","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","player1":"独行侠","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1url":"","player2":"湖人","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2url":"","score":"114:100","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","player1":"马刺","player1info":"","player1location":"(客)","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1url":"","player2":"活塞","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2url":"","score":"98:132","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","player1":"雷霆","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1url":"","player2":"鹈鹕","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2url":"","score":"107:104","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","player1":"勇士","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"魔术","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2url":"","score":"96:100","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","player1":"爵士","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"猛龙","player2info":"","player2location":"(主)","player2logobig":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2url":"","score":"110:130","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","player1":"奇才","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1url":"","player2":"快船","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2url":"","score":"125:150","status":"2","title":"12-02  周一"}],"livelink":[{"text":"视频集锦","url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html"},{"text":"技术统计","url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html"}],"bottomlink":[{"text":"常规赛赛程","url":""},{"text":"社区讨论","url":""},{"text":"球队排名","url":"http://nba.stats.qq.com/standings/"},{"text":"球员排名","url":"http://nba.stats.qq.com/stats/detail/?order=defen&type=player"}]},{"title":"12-03 周二","tr":[{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"太阳","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/21.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/21.png","player1url":"","player2":"黄蜂","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/30.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/30.png","player2url":"","score":"0:0","status":"0","time":"12-03 08:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"爵士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"76人","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/20.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/20.png","player2url":"","score":"0:0","status":"0","time":"12-03 08:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"勇士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"老鹰","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/1.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1.png","player2url":"","score":"0:0","status":"0","time":"12-03 08:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"步行者","player1logo":"https://img1.gtimg.com/sports/pics/hv1/43/116/2220/144385123.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/43/116/2220/144385123.png","player1url":"","player2":"灰熊","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player2url":"","score":"0:0","status":"0","time":"12-03 09:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"尼克斯","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player1url":"","player2":"雄鹿","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/15.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/15.png","player2url":"","score":"0:0","status":"0","time":"12-03 09:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"","m_link2url":"","player1":"公牛","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/4.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/4.png","player1url":"","player2":"国王","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/23.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/23.png","player2url":"","score":"0:0","status":"0","time":"12-03 11:00"}],"live":null,"livelink":null,"bottomlink":[{"text":"常规赛赛程","url":""},{"text":"社区讨论","url":""},{"text":"球队排名","url":"http://nba.stats.qq.com/standings/"},{"text":"球员排名","url":"http://nba.stats.qq.com/stats/detail/?order=defen&type=player"}]}]
         * teammatch : [{"name":"老鹰","url":"http://nba.stats.qq.com/schedule/index.htm?team=hawks"},{"name":"凯尔特人","url":"http://nba.stats.qq.com/schedule/index.htm?team=celtics"},{"name":"鹈鹕","url":"http://nba.stats.qq.com/schedule/index.htm?team=pelicans"},{"name":"公牛","url":"http://nba.stats.qq.com/schedule/index.htm?team=bulls"},{"name":"骑士","url":"http://nba.stats.qq.com/schedule/index.htm?team=cavaliers"},{"name":"独行侠","url":"http://nba.stats.qq.com/schedule/index.htm?team=mavericks"},{"name":"掘金","url":"http://nba.stats.qq.com/schedule/index.htm?team=nuggets"},{"name":"活塞","url":"http://nba.stats.qq.com/schedule/index.htm?team=pistons"},{"name":"勇士","url":"http://nba.stats.qq.com/schedule/index.htm?team=warriors"},{"name":"火箭","url":"http://nba.stats.qq.com/schedule/index.htm?team=rockets"},{"name":"步行者","url":"http://nba.stats.qq.com/schedule/index.htm?team=pacers"},{"name":"快船","url":"http://nba.stats.qq.com/schedule/index.htm?team=clippers"},{"name":"湖人","url":"http://nba.stats.qq.com/schedule/index.htm?team=lakers"},{"name":"热火","url":"http://nba.stats.qq.com/schedule/index.htm?team=heat"},{"name":"雄鹿","url":"http://nba.stats.qq.com/schedule/index.htm?team=bucks"},{"name":"森林狼","url":"http://nba.stats.qq.com/schedule/index.htm?team=timberwolves"},{"name":"篮网","url":"http://nba.stats.qq.com/schedule/index.htm?team=nets"},{"name":"尼克斯","url":"http://nba.stats.qq.com/schedule/index.htm?team=knicks"},{"name":"魔术","url":"http://nba.stats.qq.com/schedule/index.htm?team=magic"},{"name":"76人","url":"http://nba.stats.qq.com/schedule/index.htm?team=sixers"},{"name":"太阳","url":"http://nba.stats.qq.com/schedule/index.htm?team=suns"},{"name":"开拓者","url":"http://nba.stats.qq.com/schedule/index.htm?team=blazers"},{"name":"国王","url":"http://nba.stats.qq.com/schedule/index.htm?team=kings"},{"name":"马刺","url":"http://nba.stats.qq.com/schedule/index.htm?team=spurs"},{"name":"雷霆","url":"http://nba.stats.qq.com/schedule/index.htm?team=thunder"},{"name":"爵士","url":"http://nba.stats.qq.com/schedule/index.htm?team=jazz"},{"name":"奇才","url":"http://nba.stats.qq.com/schedule/index.htm?team=wizards"},{"name":"猛龙","url":"http://nba.stats.qq.com/schedule/index.htm?team=raptors"},{"name":"灰熊","url":"http://nba.stats.qq.com/schedule/index.htm?team=grizzlies"},{"name":"黄蜂","url":"http://nba.stats.qq.com/schedule/index.htm?team=hornets"}]
         */

        private String title;
        private StatuslistBean statuslist;
        private List<ListBean> list;
        private List<TeammatchBean> teammatch;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public StatuslistBean getStatuslist() {
            return statuslist;
        }

        public void setStatuslist(StatuslistBean statuslist) {
            this.statuslist = statuslist;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<TeammatchBean> getTeammatch() {
            return teammatch;
        }

        public void setTeammatch(List<TeammatchBean> teammatch) {
            this.teammatch = teammatch;
        }

        public static class StatuslistBean implements Serializable  {
            /**
             * st0 : 未开赛
             * st1 : 直播中
             * st2 : 已结束
             */

            private String st0;
            private String st1;
            private String st2;

            public String getSt0() {
                return st0;
            }

            public void setSt0(String st0) {
                this.st0 = st0;
            }

            public String getSt1() {
                return st1;
            }

            public void setSt1(String st1) {
                this.st1 = st1;
            }

            public String getSt2() {
                return st2;
            }

            public void setSt2(String st2) {
                this.st2 = st2;
            }
        }

        public static class ListBean implements Serializable {
            /**
             * title : 12-02 周一
             * tr : [{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc0020023ejign.html","m_link2url":"http://v.qq.com/cover/m/mzc0020023ejign.html","player1":"热火","player1logo":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1url":"","player2":"篮网","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2url":"","score":"109:106","status":"2","time":"12-02 04:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","m_link2url":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","player1":"凯尔特人","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1url":"","player2":"尼克斯","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2url":"","score":"113:104","status":"2","time":"12-02 04:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","m_link2url":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","player1":"灰熊","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1url":"","player2":"森林狼","player2logo":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2url":"","score":"115:107","status":"2","time":"12-02 04:30"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","m_link2url":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","player1":"独行侠","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1url":"","player2":"湖人","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2url":"","score":"114:100","status":"2","time":"12-02 05:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","m_link2url":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","player1":"马刺","player1logo":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1url":"","player2":"活塞","player2logo":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2url":"","score":"98:132","status":"2","time":"12-02 06:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","m_link2url":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","player1":"雷霆","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1url":"","player2":"鹈鹕","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2url":"","score":"107:104","status":"2","time":"12-02 06:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","m_link2url":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","player1":"勇士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"魔术","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2url":"","score":"96:100","status":"2","time":"12-02 07:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","m_link2url":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","player1":"爵士","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"猛龙","player2logo":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2logobig":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2url":"","score":"110:130","status":"2","time":"12-02 07:00"},{"link1text":"视频集锦","link1url":"","link2text":"技术统计","link2url":"","m_link1url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","m_link2url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","player1":"奇才","player1logo":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1url":"","player2":"快船","player2logo":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2url":"","score":"125:150","status":"2","time":"12-02 11:30"}]
             * live : [{"liveurl":"http://v.qq.com/cover/m/mzc0020023ejign.html","player1":"热火","player1info":"","player1location":"(客)","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png","player1url":"","player2":"篮网","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/17.png","player2url":"","score":"109:106","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200z6zglp2.html","player1":"凯尔特人","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/2.png","player1url":"","player2":"尼克斯","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/18.png","player2url":"","score":"113:104","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200jbtf5ur.html","player1":"灰熊","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/29.png","player1url":"","player2":"森林狼","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/16.png","player2url":"","score":"115:107","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200p2hcnxi.html","player1":"独行侠","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/6.png","player1url":"","player2":"湖人","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/13.png","player2url":"","score":"114:100","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc002008x8pcyt.html","player1":"马刺","player1info":"","player1location":"(客)","player1logobig":"https://img1.gtimg.com/sports/pics/hv1/231/116/2220/144385311.png","player1url":"","player2":"活塞","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/new/8.png","player2url":"","score":"98:132","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200rejwh1u.html","player1":"雷霆","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/25.png","player1url":"","player2":"鹈鹕","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/3.png","player2url":"","score":"107:104","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc002008jsjs0j.html","player1":"勇士","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/9.png","player1url":"","player2":"魔术","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/19.png","player2url":"","score":"96:100","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200t1vdjo1.html","player1":"爵士","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/26.png","player1url":"","player2":"猛龙","player2info":"","player2location":"(主)","player2logobig":"https://img1.gtimg.com/sports/pics/hv1/133/21/2268/147482188.png","player2url":"","score":"110:130","status":"2","title":"12-02  周一"},{"liveurl":"http://v.qq.com/cover/m/mzc00200rpttpkp.html","player1":"奇才","player1info":"","player1location":"(客)","player1logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/27.png","player1url":"","player2":"快船","player2info":"","player2location":"(主)","player2logobig":"https://mat1.gtimg.com/sports/nba/logo/1602/1201.png","player2url":"","score":"125:150","status":"2","title":"12-02  周一"}]
             * livelink : [{"text":"视频集锦","url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html"},{"text":"技术统计","url":"http://v.qq.com/cover/m/mzc00200rpttpkp.html"}]
             * bottomlink : [{"text":"常规赛赛程","url":""},{"text":"社区讨论","url":""},{"text":"球队排名","url":"http://nba.stats.qq.com/standings/"},{"text":"球员排名","url":"http://nba.stats.qq.com/stats/detail/?order=defen&type=player"}]
             */

            private String title;
            private List<TrBean> tr;
            private List<LiveBean> live;
            private List<LivelinkBean> livelink;
            private List<BottomlinkBean> bottomlink;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<TrBean> getTr() {
                return tr;
            }

            public void setTr(List<TrBean> tr) {
                this.tr = tr;
            }

            public List<LiveBean> getLive() {
                return live;
            }

            public void setLive(List<LiveBean> live) {
                this.live = live;
            }

            public List<LivelinkBean> getLivelink() {
                return livelink;
            }

            public void setLivelink(List<LivelinkBean> livelink) {
                this.livelink = livelink;
            }

            public List<BottomlinkBean> getBottomlink() {
                return bottomlink;
            }

            public void setBottomlink(List<BottomlinkBean> bottomlink) {
                this.bottomlink = bottomlink;
            }

            public static class TrBean implements Serializable {
                /**
                 * link1text : 视频集锦
                 * link1url :
                 * link2text : 技术统计
                 * link2url :
                 * m_link1url : http://v.qq.com/cover/m/mzc0020023ejign.html
                 * m_link2url : http://v.qq.com/cover/m/mzc0020023ejign.html
                 * player1 : 热火
                 * player1logo : https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png
                 * player1logobig : https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png
                 * player1url :
                 * player2 : 篮网
                 * player2logo : https://mat1.gtimg.com/sports/nba/logo/1602/17.png
                 * player2logobig : https://mat1.gtimg.com/sports/nba/logo/1602/17.png
                 * player2url :
                 * score : 109:106
                 * status : 2
                 * time : 12-02 04:00
                 */

                private String link1text;
                private String link1url;
                private String link2text;
                private String link2url;
                private String m_link1url;
                private String m_link2url;
                private String player1;
                private String player1logo;
                private String player1logobig;
                private String player1url;
                private String player2;
                private String player2logo;
                private String player2logobig;
                private String player2url;
                private String score;
                private String status;
                private String time;

                public String getLink1text() {
                    return link1text;
                }

                public void setLink1text(String link1text) {
                    this.link1text = link1text;
                }

                public String getLink1url() {
                    return link1url;
                }

                public void setLink1url(String link1url) {
                    this.link1url = link1url;
                }

                public String getLink2text() {
                    return link2text;
                }

                public void setLink2text(String link2text) {
                    this.link2text = link2text;
                }

                public String getLink2url() {
                    return link2url;
                }

                public void setLink2url(String link2url) {
                    this.link2url = link2url;
                }

                public String getM_link1url() {
                    return m_link1url;
                }

                public void setM_link1url(String m_link1url) {
                    this.m_link1url = m_link1url;
                }

                public String getM_link2url() {
                    return m_link2url;
                }

                public void setM_link2url(String m_link2url) {
                    this.m_link2url = m_link2url;
                }

                public String getPlayer1() {
                    return player1;
                }

                public void setPlayer1(String player1) {
                    this.player1 = player1;
                }

                public String getPlayer1logo() {
                    return player1logo;
                }

                public void setPlayer1logo(String player1logo) {
                    this.player1logo = player1logo;
                }

                public String getPlayer1logobig() {
                    return player1logobig;
                }

                public void setPlayer1logobig(String player1logobig) {
                    this.player1logobig = player1logobig;
                }

                public String getPlayer1url() {
                    return player1url;
                }

                public void setPlayer1url(String player1url) {
                    this.player1url = player1url;
                }

                public String getPlayer2() {
                    return player2;
                }

                public void setPlayer2(String player2) {
                    this.player2 = player2;
                }

                public String getPlayer2logo() {
                    return player2logo;
                }

                public void setPlayer2logo(String player2logo) {
                    this.player2logo = player2logo;
                }

                public String getPlayer2logobig() {
                    return player2logobig;
                }

                public void setPlayer2logobig(String player2logobig) {
                    this.player2logobig = player2logobig;
                }

                public String getPlayer2url() {
                    return player2url;
                }

                public void setPlayer2url(String player2url) {
                    this.player2url = player2url;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }

            public static class LiveBean implements Serializable  {
                /**
                 * liveurl : http://v.qq.com/cover/m/mzc0020023ejign.html
                 * player1 : 热火
                 * player1info :
                 * player1location : (客)
                 * player1logobig : https://img1.gtimg.com/sports/pics/hv1/212/15/2292/149041337.png
                 * player1url :
                 * player2 : 篮网
                 * player2info :
                 * player2location : (主)
                 * player2logobig : https://mat1.gtimg.com/sports/nba/logo/1602/17.png
                 * player2url :
                 * score : 109:106
                 * status : 2
                 * title : 12-02  周一
                 */

                private String liveurl;
                private String player1;
                private String player1info;
                private String player1location;
                private String player1logobig;
                private String player1url;
                private String player2;
                private String player2info;
                private String player2location;
                private String player2logobig;
                private String player2url;
                private String score;
                private String status;
                private String title;

                public String getLiveurl() {
                    return liveurl;
                }

                public void setLiveurl(String liveurl) {
                    this.liveurl = liveurl;
                }

                public String getPlayer1() {
                    return player1;
                }

                public void setPlayer1(String player1) {
                    this.player1 = player1;
                }

                public String getPlayer1info() {
                    return player1info;
                }

                public void setPlayer1info(String player1info) {
                    this.player1info = player1info;
                }

                public String getPlayer1location() {
                    return player1location;
                }

                public void setPlayer1location(String player1location) {
                    this.player1location = player1location;
                }

                public String getPlayer1logobig() {
                    return player1logobig;
                }

                public void setPlayer1logobig(String player1logobig) {
                    this.player1logobig = player1logobig;
                }

                public String getPlayer1url() {
                    return player1url;
                }

                public void setPlayer1url(String player1url) {
                    this.player1url = player1url;
                }

                public String getPlayer2() {
                    return player2;
                }

                public void setPlayer2(String player2) {
                    this.player2 = player2;
                }

                public String getPlayer2info() {
                    return player2info;
                }

                public void setPlayer2info(String player2info) {
                    this.player2info = player2info;
                }

                public String getPlayer2location() {
                    return player2location;
                }

                public void setPlayer2location(String player2location) {
                    this.player2location = player2location;
                }

                public String getPlayer2logobig() {
                    return player2logobig;
                }

                public void setPlayer2logobig(String player2logobig) {
                    this.player2logobig = player2logobig;
                }

                public String getPlayer2url() {
                    return player2url;
                }

                public void setPlayer2url(String player2url) {
                    this.player2url = player2url;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class LivelinkBean implements Serializable {
                /**
                 * text : 视频集锦
                 * url : http://v.qq.com/cover/m/mzc00200rpttpkp.html
                 */

                private String text;
                private String url;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class BottomlinkBean implements Serializable {
                /**
                 * text : 常规赛赛程
                 * url :
                 */

                private String text;
                private String url;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class TeammatchBean implements Serializable  {
            /**
             * name : 老鹰
             * url : http://nba.stats.qq.com/schedule/index.htm?team=hawks
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
