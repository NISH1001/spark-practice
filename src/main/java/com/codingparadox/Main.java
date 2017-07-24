package com.codingparadox;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.codingparadox.junk.ExperienceTest;
import com.codingparadox.junk.KMeansTest;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("I am paradox");

		String inputPath = "/home/lt83/junkcodes/spark/"
				+ "part-00000-tid-5143429543632982224-dd4be96b-c52b-48b0-9cd8-21a1e62ceccd-0-c000.json";

		String inputPath1 = "/home/lt83/junkcodes/spark/"
				+ "ds_dump_AD_1.jl";
		
		ExperienceTest experienceTest = new ExperienceTest();
		Dataset<Row> experienceData = experienceTest.processExperience(inputPath);
		experienceData.show(20, false);
		
		KMeansTest kmeans = new KMeansTest();
		kmeans.cluster(experienceData);
	}
}
