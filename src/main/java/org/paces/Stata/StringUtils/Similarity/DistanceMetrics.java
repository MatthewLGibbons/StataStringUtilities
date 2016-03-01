package org.paces.Stata.StringUtils.Similarity;

import com.stata.sfi.Data;
import org.apache.commons.lang3.StringUtils;
import org.paces.Stata.MetaData.Meta;

import java.util.Locale;

/**
 * Class provides a wrapper to string utilities in the Apache Commons
 * Language library specifically focusing on string distance methods.
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class DistanceMetrics {

	private Locale loc;
	private Integer fd;
	private Integer jw;
	private Integer lv;
	private Meta m;
	private Boolean fdist;
	private Boolean jdist;
	private Boolean ldist;

	/**
	 * Class constructor that automatically dispatches methods to return
	 * distance metrics to Stata
	 * @param args Args passed from args parameter of the javacall command
	 */
	public DistanceMetrics(String[] args) {
		this.loc = Locality.getLocale(args[0]);
		this.m = new Meta(args);
		if (!args[1].isEmpty()) {
			Data.addVarInt("fuzzydistance");
			this.fd = Data.getVarIndex("fuzzydistance");
			this.fdist = true;
		}

		if (!args[2].isEmpty()) {
			Data.addVarDouble("jarowinkler");
			this.jw = Data.getVarIndex("jarowinkler");
			this.jdist = true;
		}

		if (!args[3].isEmpty()) {
			Data.addVarDouble("levenshtein_distance");
			this.lv = Data.getVarIndex("levenshtein_distance");
			this.ldist = true;
		}
		setDistances(this.fdist, this.jdist, this.ldist);
	}

	/**
	 * Method that returns string distance metric values
	 * @param f Boolean indicating if fuzzy distance should be returned
	 * @param j Boolean indicating if Jaro Winkler distance should be returned
	 * @param l Boolean indicating if Levenshtein distance should be returned
	 */
	private void setDistances(Boolean f, Boolean j, Boolean l) {
		// Loop over observations
		for (Long i : this.m.getObsindex()) {
			String from = Data.getStr(this.m.getVarindex().get(0), i).toLowerCase(this.loc);
			String to = Data.getStr(this.m.getVarindex().get(1), i).toLowerCase(this.loc);
			if (f) Data.storeNum(this.fd, i, StringUtils.getFuzzyDistance(from, to, this.loc));
			if (j) Data.storeNum(this.jw, i, StringUtils.getJaroWinklerDistance(from, to));
			if (l) Data.storeNum(this.lv, i, StringUtils.getLevenshteinDistance(from, to));
		}
	}



}
