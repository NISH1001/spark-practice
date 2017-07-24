package com.codingparadox.core;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;

/**
 * A class that stores:
 * 	spark session
 * 	spark context
 * 	spark conf
 */
public class SparkConfig {

	private SparkContext sparkContext;
	private SparkSession sparkSession;

	public SparkConfig() {
	}
	
	public SparkConfig(SparkConfigType sparkConfigType) {
		this.initialize(sparkConfigType);
	}
	
	public void initialize(SparkConfigType sparkConfigType) {
		if(sparkConfigType == SparkConfigType.LOCAL) {
			SparkConf sparkConf = new SparkConf().setAppName("local").setMaster("local[*]");
			this.sparkContext = new SparkContext(sparkConf);
		} else {
			this.sparkContext = SparkContext.getOrCreate();
		}
		
		this.sparkSession = new SparkSession(this.sparkContext);
	}
	

	public SparkContext getSparkContext() {
		return sparkContext;
	}

	public void setSparkContext(SparkContext sparkContext) {
		this.sparkContext = sparkContext;
	}

	public SparkSession getSparkSession() {
		return sparkSession;
	}

	public void setSparkSession(SparkSession sparkSession) {
		this.sparkSession = sparkSession;
	}
}
