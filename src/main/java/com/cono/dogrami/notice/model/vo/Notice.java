package com.cono.dogrami.notice.model.vo;

import com.cono.dogrami.member.model.vo.Member;

import java.sql.Date;

public class Notice implements java.io.Serializable {
    private static final long serialVersionUID = 3763756693025717541L;
    private int notice_no;
    private String notice_title;
    private String notice_writer;
    private String notice_content;
    private String notice_old_file;
    private String notice_new_file;
    private Date notice_date;
    private int notice_count;
    private Member member;

    public Notice() {
    }

    public Notice(int notice_no, String notice_title, String notice_writer, String notice_content, String notice_old_file, String notice_new_file, Date notice_date, int notice_count, Member member) {
        this.notice_no = notice_no;
        this.notice_title = notice_title;
        this.notice_writer = notice_writer;
        this.notice_content = notice_content;
        this.notice_old_file = notice_old_file;
        this.notice_new_file = notice_new_file;
        this.notice_date = notice_date;
        this.notice_count = notice_count;
        this.member = member;
    }

    public int getNotice_no() {
        return notice_no;
    }

    public void setNotice_no(int notice_no) {
        this.notice_no = notice_no;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_writer() {
        return notice_writer;
    }

    public void setNotice_writer(String notice_writer) {
        this.notice_writer = notice_writer;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_old_file() {
        return notice_old_file;
    }

    public void setNotice_old_file(String notice_old_file) {
        this.notice_old_file = notice_old_file;
    }

    public String getNotice_new_file() {
        return notice_new_file;
    }

    public void setNotice_new_file(String notice_new_file) {
        this.notice_new_file = notice_new_file;
    }

    public Date getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(Date notice_date) {
        this.notice_date = notice_date;
    }

    public int getNotice_count() {
        return notice_count;
    }

    public void setNotice_count(int notice_count) {
        this.notice_count = notice_count;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_no=" + notice_no +
                ", notice_title='" + notice_title + '\'' +
                ", notice_writer='" + notice_writer + '\'' +
                ", notice_content='" + notice_content + '\'' +
                ", notice_old_file='" + notice_old_file + '\'' +
                ", notice_new_file='" + notice_new_file + '\'' +
                ", notice_date=" + notice_date +
                ", notice_count=" + notice_count +
                ", member=" + member +
                '}';
    }
}
