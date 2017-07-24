package com.codingparadox.junk;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;

import org.apache.spark.ml.feature.StopWordsRemover;
import org.apache.spark.ml.feature.Tokenizer;

import com.codingparadox.core.SparkConfigType;
import com.codingparadox.core.SparkSingletonConfigGenerator;

public class ExperienceTest {
	
	public Dataset<Row> processExperience(String inputPath) {
		SparkSession sparkSession = SparkSingletonConfigGenerator
				.getSingletonInstance(SparkConfigType.LOCAL)
				.getSparkSession();
		
		Dataset<Row> data = sparkSession.read().format("json").load(inputPath);
		
		data = data.select(col("compLinkedin_id"), col("experience_raw"));

/*		data.createOrReplaceTempView("processedData");
		sparkSession.sql("SELECT compLinkedin_id, experience_raw FROM processedData "
				+ "WHERE experience_raw is not null").createOrReplaceTempView("processedData");
*/	
		
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.setInputCol("experience_raw").setOutputCol("experience_tokens");
		
		data = tokenizer.transform(data);
		
		StopWordsRemover stopWordsRemover = new StopWordsRemover()
				.setInputCol("experience_tokens")
				.setOutputCol("experience_words");
		
		data = stopWordsRemover.transform(data).drop("experience_raw").drop("experience_tokens");
		
//		experienceProcessed.coalesce(1).write().format("json").save("/home/lt83/junkcodes/experience.json");
		return data;
	
	}
}
