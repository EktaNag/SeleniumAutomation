package baseTest;

import org.testng.annotations.Test;
import pageObjectModel.GitHubUptimePage;
import pageObjectModel.GithubstatusLogin;

public class GithubWebsiteTest extends BaseTest{

    @Test
    public void getDetailsGitStatusPage()
    {
        driver.get("https://www.githubstatus.com/");
        GithubstatusLogin obj=new GithubstatusLogin(driver);
        obj.printHeadings();
    }

    @Test
    public void getStatusGitHUb()
    {
        driver.get("https://www.githubstatus.com/uptime");
        GitHubUptimePage obj=new GitHubUptimePage(driver);
        obj.getOutageDetails();

    }

}
