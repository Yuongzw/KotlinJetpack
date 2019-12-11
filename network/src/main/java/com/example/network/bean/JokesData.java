package com.example.network.bean;

import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/11
 * desc   :
 */
public class JokesData {

    /**
     * error_code : 0
     * reason : Succes
     * result : [{"content":"这是STEAM的规矩！","hashId":"A9A6ABA505CC2C59C5ADB5433F9F6A0C","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=458c0fbae42a4aceac719f91cd76d206.png"},{"content":"一点职业道德都没有","hashId":"779F3D2AC8924E6567EF3D1082F67583","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=c616103d44f24a498fd5987d7429b9f6.jpg"},{"content":"养狗你可以遛狗，但是养猫\u2026\u2026\u2026","hashId":"D9725EC3275A989796001E5C3432BC8D","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=5bbc1df3ea284575835c0c357a5126e1.gif"},{"content":"太不公平","hashId":"02571AD2D58648B315F320F85FCE8F3D","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=a00a3e3d801445508fe6204f2c5f84cb.jpg"},{"content":"被这样无辜的眼神看着，都不敢把喵喵弄疼了","hashId":"AFFE901413FC00E1DB0F97A6966ED34F","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=71946fdcd6224caa884e422103107d91.jpg"},{"content":"揭假结婚下的京牌交易：京户买主7万 外地户需10万","hashId":"AAD03F6CF0AC56358994FE06A4BACBCC","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=a23ff6d4cf7f42ccb8813a50f9e5082d.jpg"},{"content":"每天都在不停思考的人生难题[拜拜]","hashId":"7ECBDDF8F485B7F784D4347982A554C3","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=a07639dd193042aab9c95ef9854b4746.jpg"},{"content":"盘点明星们尴尬的瞬间[doge]，哈哈哈笑精神了","hashId":"3CE471FED4EFFB0ACD61711F37F69DB2","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=0731f74ccb4749a2a812a8909f295bb5.gif"},{"content":"感谢设计师的抬爱","hashId":"0C76921F3009B1CD4636C13C69D31F2F","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=81eae5bb6e4d46fdae171b756ed0666e.jpg"},{"content":"真正的VR体验，莫名的心疼这位老板","hashId":"D66459D1CA0E588BABAA04DC0918B0BD","unixtime":"1503632630","updatetime":"2017-08-25 11:43:50","url":"http://api.avatardata.cn/Joke/Img?file=5176ed3a304d40a4ad6e14a6654aaed0.gif"}]
     */

    private int error_code;
    private String reason;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 这是STEAM的规矩！
         * hashId : A9A6ABA505CC2C59C5ADB5433F9F6A0C
         * unixtime : 1503632630
         * updatetime : 2017-08-25 11:43:50
         * url : http://api.avatardata.cn/Joke/Img?file=458c0fbae42a4aceac719f91cd76d206.png
         */

        private String content;
        private String hashId;
        private String unixtime;
        private String updatetime;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
