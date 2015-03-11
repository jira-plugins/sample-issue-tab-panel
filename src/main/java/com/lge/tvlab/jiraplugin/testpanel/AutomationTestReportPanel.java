package com.lge.tvlab.jiraplugin.testpanel;

import com.atlassian.crowd.embedded.api.User;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.comments.Comment;
import com.atlassian.jira.issue.comments.CommentManager;
import com.atlassian.jira.issue.fields.renderer.wiki.AtlassianWikiRenderer;
import com.atlassian.jira.plugin.issuetabpanel.IssueAction;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanelModuleDescriptor;
import com.atlassian.jira.util.velocity.VelocityRequestContextFactory;

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
                || projectKey.equals("TP")
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

        CommentManager myCommentManager = ComponentAccessor.getCommentManager();

        EventPublisher eventPublisher = ComponentAccessor.getOSGiComponentInstanceOfType(EventPublisher.class);
        VelocityRequestContextFactory velocityRequestContextFactory = ComponentAccessor.getOSGiComponentInstanceOfType(VelocityRequestContextFactory.class);
        ApplicationProperties applicationProperties = ComponentAccessor.getApplicationProperties();
        AtlassianWikiRenderer atlassianWikiRenderer = new AtlassianWikiRenderer(eventPublisher,applicationProperties,velocityRequestContextFactory);

        List<Comment> comments  = myCommentManager.getComments(issue);
        for (Comment c : comments) {
            testMessage= testMessage+ "\n"  + c.getBody() + "\n----";
        }

        test1.setIssueKey(atlassianWikiRenderer.render(testMessage,null).toString());

        displayedAction.add(test1);
        return displayedAction;
    }
}
