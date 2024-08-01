package com.glendale.testUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.asynchttpclient.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class TestUtils {
	
	static ExtentReports extent;

	//Extend report code to generate good test report
	public static ExtentReports getReporterObject() {
		String path = System.getProperty("user.dir") + "/src/test/resources/Reports";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Pawan Rewatkar");
		reporter.config().setDocumentTitle("Automation Test Result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Arista", "Glendale");
		//extent.setSystemInfo("Arista", "Shopify");
		return extent;
		
	}
	
	//Screenshot code for fail test cases
	public String getScreenShotPath(String testCaseName,ChromeDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationField=System.getProperty("user.dir")+"/src/test/resources/Screenshot"+
		testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationField));
		return destinationField;
	}
	public void sendReportToEmail() throws IOException {
        String sendGridApiKey = "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"; // Replace with your SendGrid API Key
        String fromEmail = "pavan@aristasystems.in";
        //String toEmail = "pawanrewatkar28@gmail.com"; //send Email to one Mail ID
        List<String> recipients = List.of(
                "pawanrewatkar28@gmail.com",
                "nupesh@aristasystems.in"
            );
        
        String subject = "Automation Test Report";
        String contentText = "Please find the attached Automation test report for Rebecca Taylor.";
        String attachmentPath = System.getProperty("user.dir") + "/src/test/resources/Reports/index.html";

        Email from = new Email(fromEmail);
        //Email to = new Email(toEmail);
        Content content = new Content("text/plain", contentText);
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);

         // Add multiple recipients
        for (String emailAddress :  recipients) {
            Email to = new Email(emailAddress);
            Personalization personalization = new Personalization();
            personalization.addTo(to);
            mail.addPersonalization(personalization);
        }
        
        //Add attachment
        Attachments attachments = new Attachments();
        byte[] fileContent;
        fileContent = Files.readAllBytes(Paths.get(attachmentPath));
        String encodedContent = Base64.getEncoder().encodeToString(fileContent);
        attachments.setContent(encodedContent);
        attachments.setType("text/html");
        attachments.setFilename("ExtentReport.html");
        attachments.setDisposition("attachment");
        mail.addAttachments(attachments);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = (Response) sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(((Request) response).getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
	

}
