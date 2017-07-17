package com.mark.basemodule.mvp.bean;

import java.util.List;

/**
 * Created by Mark.Han on 2017/7/11.
 */

public class IndexData {
    /**
     * liveCourse : {"adminName":"点睛说","tapes":[{"id":66,"courseId":55,"duration":14,"playUrl":"http://1253521423.vod2.myqcloud.com/e45d4c03vodtransgzp1253521423/eb6485e99031868222982350556/f0.f20.mp4","hlsPlayUrl":"","fileSize":"726111","startTime":1498528215000,"endTime":1498528220000,"videoId":"210001775_2c76405dce5d49fb999d1ca09e74c9e7","fileId":"9031868222992144387","fileFormat":"mp4","vod2flag":0,"recordFileId":"9031868222992144387","streamParam":"bizid=8982&record=mp4&record_interval=5400&txSecret=6f3f939e312982e894c47d2ccf944990&txTime=59530A2E"}],"peoples":110,"id":55,"userId":1,"streamId":"djzb_4489388424","groupid":"djim_6305489102","title":"全国中小学学校法律顾问业务开拓培训","nickname":"王朝勇","headpic":"/resources/upload/images/2017/06-27/09-44-050883588590839.jpg","frontcover":"/resources/upload/images/2017/06-27/17-43-230233-441355786.jpg","location":"北京","pushUrl":"rtmp://8982.livepush2.myqcloud.com/live/djzb_4489388424?bizid=8982&record=mp4&record_interval=5400&txSecret=6f3f939e312982e894c47d2ccf944990&txTime=59530A2E","status":2,"likeCount":0,"viewerCount":0,"checkStatus":0,"forbidflag":null,"createTime":1498527854000,"playUrl":"rtmp://8982.liveplay.myqcloud.com/live/djzb_4489388424","flvPlayUrl":"http://8982.liveplay.myqcloud.com/live/djzb_4489388424.flv","hlsPlayUrl":"http://8982.liveplay.myqcloud.com/live/djzb_4489388424.m3u8","isPlayback":1,"duration":16,"startTime":1495177500000,"price":0.01,"createUserid":1,"courseType":2,"isEnd":1,"playerimage":null,"isfree":1,"courseDesc":"学生是民族的未来和希望，是社会的花朵。然而，在生活中，暴力伤害、财产损害等侵害未成年人的犯罪行为时有发生，学生容易成为受犯罪威胁的高危人群。就此，王朝勇提供专业法制教育经验，让广大中学生能切实提高应对违法犯罪的能力喝水平。","userDesc":"现为北京市京师律师事务所战略规划与案件指导部主任、虚假诉讼法律事务部主任；京师律师学院执行院长；京师中国企业重大法律事务解决中心副主任；京师疑难案件中心秘书长。"}
     */

    private LiveCourseBean liveCourse;

    public LiveCourseBean getLiveCourse() {
        return liveCourse;
    }

    public void setLiveCourse(LiveCourseBean liveCourse) {
        this.liveCourse = liveCourse;
    }

    public static class LiveCourseBean {
        /**
         * adminName : 点睛说
         * tapes : [{"id":66,"courseId":55,"duration":14,"playUrl":"http://1253521423.vod2.myqcloud.com/e45d4c03vodtransgzp1253521423/eb6485e99031868222982350556/f0.f20.mp4","hlsPlayUrl":"","fileSize":"726111","startTime":1498528215000,"endTime":1498528220000,"videoId":"210001775_2c76405dce5d49fb999d1ca09e74c9e7","fileId":"9031868222992144387","fileFormat":"mp4","vod2flag":0,"recordFileId":"9031868222992144387","streamParam":"bizid=8982&record=mp4&record_interval=5400&txSecret=6f3f939e312982e894c47d2ccf944990&txTime=59530A2E"}]
         * peoples : 110
         * id : 55
         * userId : 1
         * streamId : djzb_4489388424
         * groupid : djim_6305489102
         * title : 全国中小学学校法律顾问业务开拓培训
         * nickname : 王朝勇
         * headpic : /resources/upload/images/2017/06-27/09-44-050883588590839.jpg
         * frontcover : /resources/upload/images/2017/06-27/17-43-230233-441355786.jpg
         * location : 北京
         * pushUrl : rtmp://8982.livepush2.myqcloud.com/live/djzb_4489388424?bizid=8982&record=mp4&record_interval=5400&txSecret=6f3f939e312982e894c47d2ccf944990&txTime=59530A2E
         * status : 2
         * likeCount : 0
         * viewerCount : 0
         * checkStatus : 0
         * forbidflag : null
         * createTime : 1498527854000
         * playUrl : rtmp://8982.liveplay.myqcloud.com/live/djzb_4489388424
         * flvPlayUrl : http://8982.liveplay.myqcloud.com/live/djzb_4489388424.flv
         * hlsPlayUrl : http://8982.liveplay.myqcloud.com/live/djzb_4489388424.m3u8
         * isPlayback : 1
         * duration : 16
         * startTime : 1495177500000
         * price : 0.01
         * createUserid : 1
         * courseType : 2
         * isEnd : 1
         * playerimage : null
         * isfree : 1
         * courseDesc : 学生是民族的未来和希望，是社会的花朵。然而，在生活中，暴力伤害、财产损害等侵害未成年人的犯罪行为时有发生，学生容易成为受犯罪威胁的高危人群。就此，王朝勇提供专业法制教育经验，让广大中学生能切实提高应对违法犯罪的能力喝水平。
         * userDesc : 现为北京市京师律师事务所战略规划与案件指导部主任、虚假诉讼法律事务部主任；京师律师学院执行院长；京师中国企业重大法律事务解决中心副主任；京师疑难案件中心秘书长。
         */

        private String adminName;
        private int peoples;
        private int id;
        private int userId;
        private String streamId;
        private String groupid;
        private String title;
        private String nickname;
        private String headpic;
        private String frontcover;
        private String location;
        private String pushUrl;
        private int status;
        private int likeCount;
        private int viewerCount;
        private int checkStatus;
        private Object forbidflag;
        private long createTime;
        private String playUrl;
        private String flvPlayUrl;
        private String hlsPlayUrl;
        private int isPlayback;
        private int duration;
        private long startTime;
        private double price;
        private int createUserid;
        private int courseType;
        private int isEnd;
        private Object playerimage;
        private int isfree;
        private String courseDesc;
        private String userDesc;
        private List<TapesBean> tapes;

        public String getAdminName() {
            return adminName;
        }

        public void setAdminName(String adminName) {
            this.adminName = adminName;
        }

        public int getPeoples() {
            return peoples;
        }

        public void setPeoples(int peoples) {
            this.peoples = peoples;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getStreamId() {
            return streamId;
        }

        public void setStreamId(String streamId) {
            this.streamId = streamId;
        }

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public String getFrontcover() {
            return frontcover;
        }

        public void setFrontcover(String frontcover) {
            this.frontcover = frontcover;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPushUrl() {
            return pushUrl;
        }

        public void setPushUrl(String pushUrl) {
            this.pushUrl = pushUrl;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getViewerCount() {
            return viewerCount;
        }

        public void setViewerCount(int viewerCount) {
            this.viewerCount = viewerCount;
        }

        public int getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(int checkStatus) {
            this.checkStatus = checkStatus;
        }

        public Object getForbidflag() {
            return forbidflag;
        }

        public void setForbidflag(Object forbidflag) {
            this.forbidflag = forbidflag;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public String getFlvPlayUrl() {
            return flvPlayUrl;
        }

        public void setFlvPlayUrl(String flvPlayUrl) {
            this.flvPlayUrl = flvPlayUrl;
        }

        public String getHlsPlayUrl() {
            return hlsPlayUrl;
        }

        public void setHlsPlayUrl(String hlsPlayUrl) {
            this.hlsPlayUrl = hlsPlayUrl;
        }

        public int getIsPlayback() {
            return isPlayback;
        }

        public void setIsPlayback(int isPlayback) {
            this.isPlayback = isPlayback;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getCreateUserid() {
            return createUserid;
        }

        public void setCreateUserid(int createUserid) {
            this.createUserid = createUserid;
        }

        public int getCourseType() {
            return courseType;
        }

        public void setCourseType(int courseType) {
            this.courseType = courseType;
        }

        public int getIsEnd() {
            return isEnd;
        }

        public void setIsEnd(int isEnd) {
            this.isEnd = isEnd;
        }

        public Object getPlayerimage() {
            return playerimage;
        }

        public void setPlayerimage(Object playerimage) {
            this.playerimage = playerimage;
        }

        public int getIsfree() {
            return isfree;
        }

        public void setIsfree(int isfree) {
            this.isfree = isfree;
        }

        public String getCourseDesc() {
            return courseDesc;
        }

        public void setCourseDesc(String courseDesc) {
            this.courseDesc = courseDesc;
        }

        public String getUserDesc() {
            return userDesc;
        }

        public void setUserDesc(String userDesc) {
            this.userDesc = userDesc;
        }

        public List<TapesBean> getTapes() {
            return tapes;
        }

        public void setTapes(List<TapesBean> tapes) {
            this.tapes = tapes;
        }

        @Override
        public String toString() {
            return "LiveCourseBean{" +
                    "adminName='" + adminName + '\'' +
                    ", peoples=" + peoples +
                    ", id=" + id +
                    ", userId=" + userId +
                    ", streamId='" + streamId + '\'' +
                    ", groupid='" + groupid + '\'' +
                    ", title='" + title + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", headpic='" + headpic + '\'' +
                    ", frontcover='" + frontcover + '\'' +
                    ", location='" + location + '\'' +
                    ", pushUrl='" + pushUrl + '\'' +
                    ", status=" + status +
                    ", likeCount=" + likeCount +
                    ", viewerCount=" + viewerCount +
                    ", checkStatus=" + checkStatus +
                    ", forbidflag=" + forbidflag +
                    ", createTime=" + createTime +
                    ", playUrl='" + playUrl + '\'' +
                    ", flvPlayUrl='" + flvPlayUrl + '\'' +
                    ", hlsPlayUrl='" + hlsPlayUrl + '\'' +
                    ", isPlayback=" + isPlayback +
                    ", duration=" + duration +
                    ", startTime=" + startTime +
                    ", price=" + price +
                    ", createUserid=" + createUserid +
                    ", courseType=" + courseType +
                    ", isEnd=" + isEnd +
                    ", playerimage=" + playerimage +
                    ", isfree=" + isfree +
                    ", courseDesc='" + courseDesc + '\'' +
                    ", userDesc='" + userDesc + '\'' +
                    ", tapes=" + tapes +
                    '}';
        }

        public static class TapesBean {
            /**
             * id : 66
             * courseId : 55
             * duration : 14
             * playUrl : http://1253521423.vod2.myqcloud.com/e45d4c03vodtransgzp1253521423/eb6485e99031868222982350556/f0.f20.mp4
             * hlsPlayUrl :
             * fileSize : 726111
             * startTime : 1498528215000
             * endTime : 1498528220000
             * videoId : 210001775_2c76405dce5d49fb999d1ca09e74c9e7
             * fileId : 9031868222992144387
             * fileFormat : mp4
             * vod2flag : 0
             * recordFileId : 9031868222992144387
             * streamParam : bizid=8982&record=mp4&record_interval=5400&txSecret=6f3f939e312982e894c47d2ccf944990&txTime=59530A2E
             */

            private int id;
            private int courseId;
            private int duration;
            private String playUrl;
            private String hlsPlayUrl;
            private String fileSize;
            private long startTime;
            private long endTime;
            private String videoId;
            private String fileId;
            private String fileFormat;
            private int vod2flag;
            private String recordFileId;
            private String streamParam;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public String getHlsPlayUrl() {
                return hlsPlayUrl;
            }

            public void setHlsPlayUrl(String hlsPlayUrl) {
                this.hlsPlayUrl = hlsPlayUrl;
            }

            public String getFileSize() {
                return fileSize;
            }

            public void setFileSize(String fileSize) {
                this.fileSize = fileSize;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public String getFileId() {
                return fileId;
            }

            public void setFileId(String fileId) {
                this.fileId = fileId;
            }

            public String getFileFormat() {
                return fileFormat;
            }

            public void setFileFormat(String fileFormat) {
                this.fileFormat = fileFormat;
            }

            public int getVod2flag() {
                return vod2flag;
            }

            public void setVod2flag(int vod2flag) {
                this.vod2flag = vod2flag;
            }

            public String getRecordFileId() {
                return recordFileId;
            }

            public void setRecordFileId(String recordFileId) {
                this.recordFileId = recordFileId;
            }

            public String getStreamParam() {
                return streamParam;
            }

            public void setStreamParam(String streamParam) {
                this.streamParam = streamParam;
            }
        }
    }
}
