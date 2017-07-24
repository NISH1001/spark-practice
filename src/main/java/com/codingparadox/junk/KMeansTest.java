package com.codingparadox.junk;

import org.apache.spark.ml.clustering.KMeans;
import org.apache.spark.ml.clustering.KMeansModel;
import org.apache.spark.ml.feature.HashingTF;
import org.apache.spark.ml.feature.IDF;
import org.apache.spark.ml.feature.IDFModel;
import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.codingparadox.core.SparkConfigType;
import com.codingparadox.core.SparkSingletonConfigGenerator;

public class KMeansTest {
	
	public void cluster(Dataset<Row> data) {
		System.out.println("Clustering using kmeans...");

		SparkSession sparkSession = SparkSingletonConfigGenerator
				.getSingletonInstance(SparkConfigType.LOCAL)
				.getSparkSession();
		
		HashingTF hashingTF = new HashingTF()
				.setInputCol("experience_words")
				.setOutputCol("tf")
				.setNumFeatures(5);
		
		Dataset<Row> experienceFeatures = hashingTF.transform(data);
		
		IDF idf = new IDF().setInputCol("tf").setOutputCol("features");
		IDFModel idfModel = idf.fit(experienceFeatures);
		
		Dataset<Row> rescaledData = idfModel.transform(experienceFeatures);
		
		KMeans kmeans = new KMeans().setK(5).setSeed(1L);
		KMeansModel model = kmeans.fit(rescaledData);
		
		double WSSSE = model.computeCost(rescaledData);
		System.out.println("WSSE :: " + WSSSE);
		
		Vector[] centers = model.clusterCenters();
		for(Vector center: centers ) {
			System.out.println(center);
		}

//		Vector dv = Vectors.dense(0.013003095975232198,0.06666666666666667,0.0022703818369453044,0.004540763673890609,0.08317853457172342,0.02063983488132095,0.005159958720330237,1.0, 0.0, 3.0);
//		Vector v = Vectors.dense(0.013003095975232198,0.06666666666666667,0.0022703818369453044,0.004540763673890609,0.08317853457172342,0.02063983488132095,0.005159958720330237,0.026006191950464396,0.029308565531475747,0.0173374613003096,0.008462332301341588,0.016924664602683177,0.10175438596491228,0.0026831785345717233,0.11186790505675955,0.18968008255933952,0.03508771929824561,0.006604747162022704,0.026212590299277604,0.005779153766769866,0.004953560371517028,0.03199174406604747,0.04251805985552116,0.006398348813209494,0.0041279669762641896,0.00804953560371517,0.005985552115583075,0.0392156862745098,0.01197110423116615,0.013622291021671826,0.006191950464396284,0.006398348813209494,0.019814241486068113,0.008255933952528379,0.017750257997936017,0.14530443756449948,0.03859649122807018,0.0035087719298245615,0.005985552115583075,0.010113519091847266,0.0,0.0043343653250774,0.005985552115583075,0.00392156862745098,0.011764705882352941,0.09948400412796697,0.019814241486068113,0.007017543859649123,0.005572755417956656,0.05779153766769866,0.11517027863777089,0.010113519091847266,0.01671826625386997,0.0,0.0086687306501548,0.010939112487100102,0.04643962848297214,0.06893704850361197,0.009907120743034056,0.009700722394220845,0.0,0.012383900928792569,0.0740970072239422,0.011764705882352941,0.02002063983488132,0.029721362229102165,0.013209494324045407,0.008255933952528379,0.009700722394220845,0.007430340557275541,0.04437564499484004,0.0282765737874097,0.08152734778121774,0.014447884416924664,0.049535603715170275,0.005159958720330237,0.013003095975232198,0.10505675954592363,0.030753353973168213,0.016924664602683177,0.0043343653250774,0.010732714138286893,0.02063983488132095,0.00804953560371517,0.014447884416924664,0.025593395252837978,0.07636738906088751,0.01630546955624355,0.0076367389060887515,0.005779153766769866,0.0041279669762641896,0.01217750257997936,0.021465428276573786,0.011764705882352941,0.012383900928792569,0.03611971104231166,0.010113519091847266,0.0346749226006192,0.2134158926728586,0.043343653250773995);
		Vector vec = Vectors.dense(0.2,
				0.1,
				0.2,
				0.6,
				0.15);
		

		int c = model.predict(vec);
		System.out.println(c);
		
	}

}
