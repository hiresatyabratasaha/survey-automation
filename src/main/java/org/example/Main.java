package org.example;

import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Map<String, String>> data = getDataFromCSV();
        if (data != null) {
            for (Map<String, String> row : data) {
                fillSurvey(row);
            }
        } else {
            System.out.println("Failed to read CSV data.");
        }


    }


    public static List<Map<String, String>> getDataFromCSV() {
        String csvFile = Paths.get("").toAbsolutePath().toString() + "/data.csv";
        List<Map<String, String>> csvData = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFile));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())){

            for (CSVRecord record : csvParser) {
                Map<String, String> rowData = new LinkedHashMap<>(); // Preserve column order
                for (String header : csvParser.getHeaderNames()) {
                    rowData.put(header, record.get(header)); // Map header to value
                }
                csvData.add(rowData);
            }

            return csvData;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void fillSurvey(Map<String, String> row) throws InterruptedException {
        WebDriver driver = null;
        try {
            int timeout = 1000;
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://crwn.in/s/8481cb04bb");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            Thread.sleep(3000);
            driver.findElement(By.linkText("Proceed")).click();
            //Language
            driver.findElement(By.xpath("//*[starts-with(text(), '" + row.get("language".toUpperCase()) + "')]")).click();
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Name
            driver.findElement(By.xpath("//div[@data-quesid='480566']//textarea")).sendKeys(row.get("name".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Employee Code
            driver.findElement(By.xpath("//div[@data-quesid='481792']//textarea")).sendKeys(row.get("emp_id".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //EmailID
            driver.findElement(By.xpath("//div[@data-quesid='483240']//input")).sendKeys(row.get("email".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //PhoneNumber
            driver.findElement(By.xpath("//div[@data-quesid='480281']//input")).sendKeys(row.get("mobile_no".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Gender - Male
            driver.findElement(By.xpath("//*[starts-with(text(), '" + row.get("gender".toUpperCase()) + "')]/..")).click();
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Gender - Company
            driver.findElement(By.xpath("//*[starts-with(text(), '" + row.get("company".toUpperCase()) + "')]")).click();
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //What was the challenge the customer faced?
            driver.findElement(By.xpath("//div[@data-quesid='480285']//textarea")).sendKeys(row.get("Q1_CHALLENGE".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //What was the solution that delighted the customer?
            driver.findElement(By.xpath("//div[@data-quesid='480286']//textarea")).sendKeys(row.get("Q2_SOLUTION".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Do you or your colleague have a testimonial for the story?
            driver.findElement(By.xpath("//*[starts-with(text(), '" + row.get("TESTIMONIAL".toUpperCase()) + "')]")).click();
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //State
            driver.findElement(By.xpath("//div[@data-quesid='480332']//input")).sendKeys(row.get("state".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//*[starts-with(text(), '" + row.get("state".toUpperCase()) + "')]")).click();
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Manager
            driver.findElement(By.xpath("//div[@data-quesid='480296']//textarea")).sendKeys(row.get("manager".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Manager EmailID
            driver.findElement(By.xpath("//div[@data-quesid='480289']//input")).sendKeys(row.get("MANAGER_EMAILID".toUpperCase()));
            Thread.sleep(timeout);
            driver.findElement(By.xpath("//input[@value='Next']")).click();
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
            //Thank You
            if (driver.findElements(By.xpath("//p[text()='Thank You']")).size() == 1) {
                driver.findElement(By.xpath("//p[text()='Thank You']")).click();
            }
            //Confirm
            if (driver.findElements(By.className("grid-confirm")).size() == 1) {
                driver.findElement(By.className("grid-confirm")).click();
            }
        }
        catch(Exception ex) {
            System.err.println("Error occurred for: " + row.get("name".toUpperCase()) + " - " + ex.getMessage());
            writeErrorToCSV(row, "failed_survey_entries.csv");
        }
        finally {
            driver.close();
            driver.quit();
        }

    }

    public static void writeErrorToCSV(Map<String, String> row, String fileName) {
        String filePath = Paths.get("").toAbsolutePath().toString() + "/" + fileName;
        boolean fileExists = Files.exists(Paths.get(filePath));

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

            // Write header if file is newly created
            if (!fileExists) {
                csvPrinter.printRecord(row.keySet());
            }

            // Write failed row data
            csvPrinter.printRecord(row.values());

            System.out.println("Error logged for: " + row.get("name".toUpperCase()) + " in " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}