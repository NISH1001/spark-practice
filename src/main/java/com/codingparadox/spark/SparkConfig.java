package com.codingparadox.spark;

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
	private SparkConf sparkConf;

	public SparkConfig() {
		this.sparkConf = new SparkConf().setAppName("test").setMaster("local[*]");
		initialize();
	}
	
	public SparkConfig(SparkConf sparkConf) {
		this.sparkConf = sparkConf;
		initialize();
	}

	public void initialize() {
		this.sparkContext = new SparkContext(this.sparkConf);
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

	public SparkConf getSparkConf() {
		return sparkConf;
	}

	public void setSparkConf(SparkConf sparkConf) {
		this.sparkConf = sparkConf;
	}

}
