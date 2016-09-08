package com.ys.rx_project;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class MovieInfo {

    public int count;
    public int start;
    public int total;
    public String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SubjectsBean> subjects;
    public static class SubjectsBean {

        public RatingBean rating;
        public String title;
        public int collect_count;
        public String original_title;
        public String subtype;
        public String year;


        public ImagesBean images;
        public String alt;
        public String id;
        public List<String> genres;

        public List<CastsBean> casts;

        public List<DirectorsBean> directors;
        public static class RatingBean {
            public int max;
            public double average;
            public String stars;
            public int min;

        }

        public static class ImagesBean {
            public String small;
            public String large;
            public String medium;

        }

        public static class CastsBean {
            public String alt;

            public AvatarsBean avatars;
            public String name;
            public String id;
            public static class AvatarsBean {
                public String small;
                public String large;
                public String medium;
            }
        }
        public static class DirectorsBean {
            public String alt;

            public AvatarsBean avatars;
            public String name;
            public String id;

            public static class AvatarsBean {
                public String small;
                public String large;
                public String medium;

                @Override
                public String toString() {
                    return "AvatarsBean{" +
                            "small='" + small + '\'' +
                            ", large='" + large + '\'' +
                            ", medium='" + medium + '\'' +
                            '}';
                }
            }
        }
    }
    @Override
    public String toString() {
        return "MovieInfo{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
