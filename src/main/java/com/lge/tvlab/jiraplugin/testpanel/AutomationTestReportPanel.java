package com.lge.tvlab.jiraplugin.testpanel;

import com.atlassian.crowd.embedded.api.User;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.issuetabpanel.IssueAction;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanelModuleDescriptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjoo on 2015. 3. 9..
 */
public class AutomationTestReportPanel implements IssueTabPanel{
    public void init(IssueTabPanelModuleDescriptor descriptor){

    }

    public  boolean showPanel(Issue issue, User remoteUser){
        String projectKey = issue.getProjectObject().getKey();
        if ( projectKey.equals("SPG")
                || projectKey.equals("CMB")
        )
        {
            return true;
        }else {
            return false;
        }
    }

    public List<IssueAction> getActions(Issue issue, User remoteUser){
        List<IssueAction> displayedAction = new ArrayList<IssueAction>();
        AutomationTestReportMessage test1 = new AutomationTestReportMessage();
        String testMessage = issue.getKey() + "/"
                + issue.getProjectObject().getKey() + "/"
               + issue.getAssignee() ;
        test1.setIssueKey(testMessage);
        displayedAction.add(test1);
        return displayedAction;
    }
}
