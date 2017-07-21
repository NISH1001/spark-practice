package com.codingparadox.spark;

import org.apache.spark.SparkConf;

/**
 * A factory method that generates singleton object
 *
 */
public class SparkSingletonConfigGenerator {
	
	private static SparkConfig sparkConfig;
	
	private SparkSingletonConfigGenerator() {
	}
	
	public static SparkConfig getSingletonInstance() {
		if(sparkConfig == null) {
			sparkConfig = new SparkConfig();
		}
		return sparkConfig;
	}

	public static SparkConfig getSingletonInstance(SparkConf sparkConf) {
		if(sparkConfig == null) {
			sparkConfig = new SparkConfig(sparkConf);
		}
		return sparkConfig;
	}
}
