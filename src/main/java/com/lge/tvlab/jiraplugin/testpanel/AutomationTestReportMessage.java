package com.lge.tvlab.jiraplugin.testpanel;

import com.atlassian.jira.plugin.issuetabpanel.IssueAction;

import java.util.Date;

/**
 * Created by sunjoo on 2015. 3. 9..
 */
public class AutomationTestReportMessage implements IssueAction{
    private String issueKey = "";

    public Date getTimePerformed(){
        return null;
    }

    public void setIssueKey(String key){
        issueKey = key;
    }
    public String getHtml(){
        return "<p style=\"font-family:verdana\">This area is used for display test results</p>"
                + "<p style=\"font-family:verdana\">Sunjoo Park, allessunjoo.park@lge.com</p>"
                + "<p style=\"font-family:verdana\">"+issueKey+"</p>";
    }
    public  boolean isDisplayActionAllTab(){
        return true;
    }
}
