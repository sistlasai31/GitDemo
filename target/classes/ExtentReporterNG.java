package res;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;
	public static ExtentReports getExtentReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter e= new ExtentSparkReporter(path);
		e.config().setReportName("Web automation results");
		e.config().setDocumentTitle("Test results");
		
		extent=new ExtentReports();
		extent.attachReporter(e);
		extent.setSystemInfo("Tester", "Ramya");
		return extent;
	}
}
