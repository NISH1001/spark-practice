package com.codingparadox.spark;

/**
 * A factory method that generates singleton object
 *
 */
public class SparkSingletonConfigGenerator {
	
	private static SparkConfig sparkConfig;
	
	private SparkSingletonConfigGenerator() {
	}
	
	public static SparkConfig getSingletonInstance(SparkConfigType sparkConfigType) {
		if(sparkConfig == null) {
			System.out.println("Creating SparkConfig object...");
				sparkConfig = new SparkConfig(sparkConfigType);
		}
		return sparkConfig;
	}
}
