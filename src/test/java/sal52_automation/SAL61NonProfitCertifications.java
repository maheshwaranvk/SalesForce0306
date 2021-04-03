package sal52_automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL61NonProfitCertifications extends ProjectSpecificMethods{

	@Test
	public void NonProfitCertification() {
		
		List<String> nonProfitCertificates = new ArrayList<String>();
		
		nonProfitCertificates.add(" ASP/SaaS ");
		nonProfitCertificates.add(" C5 (ISAE 3000) ");
		nonProfitCertificates.add(" CS Gold Mark ");
		nonProfitCertificates.add(" Disaster Recovery & BCP ");
		nonProfitCertificates.add(" External Security Assessments ");
		nonProfitCertificates.add(" GDPR ");
		nonProfitCertificates.add(" ISO 27001 ");
		nonProfitCertificates.add(" ISO 27017 ");
		nonProfitCertificates.add(" ISO 27018 ");
		nonProfitCertificates.add(" PCI DSS ");
		nonProfitCertificates.add(" PrivacyMark ");
		nonProfitCertificates.add(" Privacy Shield ");
		nonProfitCertificates.add(" Salesforce BCRs ");
		nonProfitCertificates.add(" SOC 1 ");
		nonProfitCertificates.add(" SOC 2 ");
		nonProfitCertificates.add(" SOC 3 ");
		nonProfitCertificates.add(" Standard Questionnaires, FAQ's and Whitepapers ");
		nonProfitCertificates.add(" TRUSTe APEC Processor Seal ");
		nonProfitCertificates.add(" TRUSTe Privacy Verified Seal ");
		nonProfitCertificates.add(" UK Cyber Essentials Plus ");	
		
		
		
		while(!(driver.findElementByXPath("//span[text()='See System Status']").isDisplayed())){
			driver.findElementByXPath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']").click();
		}

		driver.findElementByXPath("//span[text()='See System Status']/following::span[text()='Get Started']").click();
		getwindows(1);
		driver.findElementByXPath("//p[@class='site-label' and text()='Home']").click();
		driver.findElementByXPath("//p[@class='site-label' and text()='   Compliance']").click();
		
		driver.findElementByXPath("//button[@class='slds-button slds-button_neutral' and text()=' Show filters ']").click();
		
		driver.findElementByXPath("//label[@for='Nonprofit']").click();
		List<WebElement> nonProfitCert = driver.findElementsByXPath("//h2[@class='f5 mb2 lh-title']");
		List<String> nonProfitStr = new ArrayList<String>();
		
		for (WebElement webElement : nonProfitCert) {
			nonProfitStr.add(webElement.getText());
		}
		
		as.assertTrue(nonProfitCertificates.equals(nonProfitStr));

	}
	
	
}
