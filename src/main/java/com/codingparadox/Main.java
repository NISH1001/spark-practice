package com.codingparadox;

import org.apache.spark.sql.SparkSession;

import com.codingparadox.spark.SparkConfigType;
import com.codingparadox.spark.SparkSingletonConfigGenerator;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("I am paradox");
		SparkSession sparkSession = SparkSingletonConfigGenerator
				.getSingletonInstance(SparkConfigType.LOCAL)
				.getSparkSession();
	}

}
