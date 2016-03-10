package org.paces.Stata.StringUtils.Similarity;

import com.stata.sfi.*;
import info.debatty.java.stringsimilarity.*;
import org.paces.Stata.MetaData.Meta;

import java.util.*;

/**
 * Class provides a wrapper to string utilities in the Apache Commons
 * Language library specifically focusing on string distance methods.
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class DistanceMetrics {

	private Cosine cos;
	private Damerau damerau;
	private Jaccard jaccard;
	private JaroWinkler jw;
	private Levenshtein lev;
	private LongestCommonSubsequence longestSubsequence;
	private MetricLCS metricLCS;
	private NGram ngrams;
	private NormalizedLevenshtein normalizedLev;
	private QGram qgrams;
	private SorensenDice dice;
	private Locale loc;
	private Integer fd;
	private Meta m;
	private Boolean cosineSim = false;
	private Boolean cosineDist = false;
	private Boolean damerauDist = false;
	private Boolean jaccardSim = false;
	private Boolean jaccardDist = false;
	private Boolean jwSim = false;
	private Boolean jwDist = false;
	private Boolean levDist = false;
	private Boolean longsubDist = false;
	private Boolean metricDist = false;
	private Boolean ngDist = false;
	private Boolean normLevSim = false;
	private Boolean normLevDist = false;
	private Boolean qgDist = false;
	private Boolean sorensenSim = false;
	private Boolean sorensenDist = false;


	/**
	 * Class constructor that automatically dispatches methods to return
	 * distance metrics to Stata
	 * args[0] Locale
	 * args[1] Cosine Sim                   -   double
	 * args[2] Cosine Dist                  -   double
	 * args[3] Cosine Shingles              -   config
	 * args[4] Damerau Distance             -   double
	 * args[5] Jaccard Sim                  -   double
	 * args[6] Jaccard Dist                 -   double
	 * args[7] Jaccard Shingles             -   config
	 * args[8] JaroWinkler Sim              -   double
	 * args[9] JaroWinkler Dist             -   double
	 * args[10] JaroWinkler Threshold       -   config
	 * args[11] Levenshtein Dist            -   double
	 * args[12] LongestSubSequence Dist     -   double
	 * args[13] MetricLCS Dist              -   double
	 * args[14] NGram Distance              -   double
	 * args[15] NGram Size                  -   config
	 * args[16] NormalLevenshtein Sim       -   double
	 * args[17] NormalLevenshtein Dist      -   double
	 * args[18] QGram Dist                  -   double
	 * args[19] QGram Size                  -   config
	 * args[20] SorensenDice Sim            -   double
	 * args[21] SorensenDice Dist           -   double
	 * args[22] SorensenDice Shingles       -   config
	 * @param args Args passed from args parameter of the javacall command
	 */
	public DistanceMetrics(String[] args) {
		this.loc = Locality.getLocale(args[0]);
		this.m = new Meta();
		createDistanceObjects(args);
		List<Integer> newVarIndices = new ArrayList<>();
		if (!args[1].isEmpty()) {
			Data.addVarDouble(args[1]);
			newVarIndices.add(0, Data.getVarIndex(args[1]));
			Data.setVarLabel(newVarIndices.get(0), "Cosine String Similarity");
			this.cosineSim = true;
		} else {
			newVarIndices.add(0, -99);
		}
		if (!args[2].isEmpty()) {
			Data.addVarDouble(args[2]);
			newVarIndices.add(1, Data.getVarIndex(args[2]));
			Data.setVarLabel(newVarIndices.get(1), "Cosine String Distance");
			this.cosineDist = true;
		} else {
			newVarIndices.add(1, -99);
		}
		if (!args[4].isEmpty()) {
			Data.addVarDouble(args[4]);
			newVarIndices.add(2, Data.getVarIndex(args[4]));
			Data.setVarLabel(newVarIndices.get(2), "Damerau String Distance");
			this.damerauDist = true;
		} else {
			newVarIndices.add(2, -99);
		}
		if (!args[5].isEmpty()) {
			Data.addVarDouble(args[5]);
			newVarIndices.add(3, Data.getVarIndex(args[5]));
			Data.setVarLabel(newVarIndices.get(3), "Jaccard String Similarity");
			this.jaccardSim = true;
		} else {
			newVarIndices.add(3, -99);
		}
		if (!args[6].isEmpty()) {
			Data.addVarDouble(args[6]);
			newVarIndices.add(4, Data.getVarIndex(args[6]));
			Data.setVarLabel(newVarIndices.get(4), "Jaccard String Distance");
			this.jaccardDist = true;
		} else {
			newVarIndices.add(4, -99);
		}
		if (!args[8].isEmpty()) {
			Data.addVarDouble(args[8]);
			newVarIndices.add(5, Data.getVarIndex(args[8]));
			Data.setVarLabel(newVarIndices.get(5), "Jaro Winkler String Similarity");
			this.jwSim = true;
		} else {
			newVarIndices.add(5, -99);
		}
		if (!args[9].isEmpty()) {
			Data.addVarDouble(args[9]);
			newVarIndices.add(6, Data.getVarIndex(args[9]));
			Data.setVarLabel(newVarIndices.get(6), "Jaro Winkler String " +
				"Distance");
			this.jwDist = true;
		} else {
			newVarIndices.add(6, -99);
		}
		if (!args[11].isEmpty()) {
			Data.addVarDouble(args[11]);
			newVarIndices.add(7, Data.getVarIndex(args[11]));
			Data.setVarLabel(newVarIndices.get(7), "Levenshtein String " +
				"Distance");
			this.levDist = true;
		} else {
			newVarIndices.add(7, -99);
		}
		if (!args[12].isEmpty()) {
			Data.addVarDouble(args[12]);
			newVarIndices.add(8, Data.getVarIndex(args[12]));
			Data.setVarLabel(newVarIndices.get(8), "Longest Common Substring Distance");
			this.longsubDist = true;
		} else {
			newVarIndices.add(8, -99);
		}
		if (!args[13].isEmpty()) {
			Data.addVarDouble(args[13]);
			newVarIndices.add(9, Data.getVarIndex(args[13]));
			Data.setVarLabel(newVarIndices.get(9), "Bakkelund String Distance");
			this.metricDist = true;
		} else {
			newVarIndices.add(9, -99);
		}
		if (!args[14].isEmpty()) {
			Data.addVarDouble(args[14]);
			newVarIndices.add(10, Data.getVarIndex(args[14]));
			Data.setVarLabel(newVarIndices.get(10), "N-Gram String Distance");
			this.ngDist = true;
		} else {
			newVarIndices.add(10, -99);
		}
		if (!args[16].isEmpty()) {
			Data.addVarDouble(args[16]);
			newVarIndices.add(11, Data.getVarIndex(args[16]));
			Data.setVarLabel(newVarIndices.get(11), "Normalized Levenshtein String Similarity");
			this.normLevSim = true;
		} else {
			newVarIndices.add(11, -99);
		}

		if (!args[17].isEmpty()) {
			Data.addVarDouble(args[17]);
			newVarIndices.add(12, Data.getVarIndex(args[17]));
			Data.setVarLabel(newVarIndices.get(12), "Normalized Levenshtein String Distance");
			this.normLevDist = true;
		} else {
			newVarIndices.add(12, -99);
		}

		if (!args[18].isEmpty()) {
			Data.addVarDouble(args[18]);
			newVarIndices.add(13, Data.getVarIndex(args[18]));
			Data.setVarLabel(newVarIndices.get(13), "Q-Gram String Distance");
			this.qgDist = true;
		} else {
			newVarIndices.add(13, -99);
		}

		if (!args[20].isEmpty()) {
			Data.addVarDouble(args[20]);
			newVarIndices.add(14, Data.getVarIndex(args[20]));
			Data.setVarLabel(newVarIndices.get(14), "Sorensen Dice String Similarity");
			this.sorensenSim = true;
		} else {
			newVarIndices.add(14, -99);
		}

		if (!args[21].isEmpty()) {
			Data.addVarDouble(args[21]);
			newVarIndices.add(15, Data.getVarIndex(args[21]));
			Data.setVarLabel(newVarIndices.get(15), "Sorensen Dice String Distance");
			this.sorensenDist = true;
		} else {
			newVarIndices.add(15, -99);
		}

		setDistances(newVarIndices, getMetricList());

	}


	private void createDistanceObjects(String[] args) {
		if (!args[3].isEmpty()) this.cos = new Cosine(Integer.valueOf(args[3]));
		else this.cos = new Cosine();

		if (!args[7].isEmpty()) this.jaccard = new Jaccard(Integer.valueOf(args[7]));
		else this.jaccard = new Jaccard();

		if (!args[10].isEmpty()) this.jw = new JaroWinkler(Double.valueOf(args[10]));
		else this.jw = new JaroWinkler();

		if (!args[15].isEmpty()) this.ngrams = new NGram(Integer.valueOf(args[15]));
		else this.ngrams = new NGram();

		if (!args[19].isEmpty()) this.qgrams = new QGram(Integer.valueOf(args[19]));
		else this.qgrams = new QGram();

		if (!args[22].isEmpty()) this.dice = new SorensenDice(Integer.valueOf(args[22]));
		else this.dice = new SorensenDice();
		this.damerau = new Damerau();
		this.lev = new Levenshtein();
		this.longestSubsequence = new LongestCommonSubsequence();
		this.metricLCS = new MetricLCS();
		this.normalizedLev = new NormalizedLevenshtein();
	}


	public List<Boolean> getMetricList() {
		List<Boolean> metrics = new ArrayList<>();
		metrics.add(0, this.cosineSim);
		metrics.add(1, this.cosineDist);
		metrics.add(2, this.damerauDist);
		metrics.add(3, this.jaccardSim);
		metrics.add(4, this.jaccardDist);
		metrics.add(5, this.jwSim);
		metrics.add(6, this.jwDist);
		metrics.add(7, this.levDist);
		metrics.add(8, this.longsubDist);
		metrics.add(9, this.metricDist);
		metrics.add(10, this.ngDist);
		metrics.add(11, this.normLevSim);
		metrics.add(12, this.normLevDist);
		metrics.add(13, this.qgDist);
		metrics.add(14, this.sorensenSim);
		metrics.add(15, this.sorensenDist);
		return metrics;
	}

	/**
	 * Method that returns string distance metric values
	 * @param varidx A list of Integer variable indices
	 * @param metrics A List of Booleans indicating whether or not the
	 *                   variable was created/needs to be populated
	 */
	private void setDistances(List<Integer> varidx, List<Boolean> metrics) {

		// Loop over observations
		for (Long i : this.m.getObsindex()) {
			String from = Data.getStr(this.m.getVarindex().get(0), i).toLowerCase(this.loc);
			String to = Data.getStr(this.m.getVarindex().get(1), i).toLowerCase(this.loc);

			if (metrics.get(0) && varidx.get(0) != -99) {
				Data.storeNum(varidx.get(0), i, this.cos.similarity(from, to));
			}

			if (metrics.get(1) && varidx.get(0) != -99) {
				Data.storeNum(varidx.get(1), i, this.cos.distance(from, to));
			}

			if (metrics.get(2) && varidx.get(2) != -99) {
				Data.storeNum(varidx.get(2), i, this.damerau.distance(from, to));
			}

			if (metrics.get(3) && varidx.get(3) != -99) {
				Data.storeNum(varidx.get(3), i, this.jaccard.similarity(from, to));
			}

			if (metrics.get(4) && varidx.get(4) != -99) {
				Data.storeNum(varidx.get(4), i, this.jaccard.distance(from, to));
			}

			if (metrics.get(5) && varidx.get(5) != -99) {
				Data.storeNum(varidx.get(5), i, this.jw.similarity(from, to));
			}

			if (metrics.get(6) && varidx.get(6) != -99) {
				Data.storeNum(varidx.get(6), i, this.jw.distance(from, to));
			}

			if (metrics.get(7) && varidx.get(7) != -99) {
				Data.storeNum(varidx.get(7), i, this.lev.distance(from, to));
			}

			if (metrics.get(8) && varidx.get(8) != -99) {
				Data.storeNum(varidx.get(8), i, this.longestSubsequence.distance(from, to));
			}

			if (metrics.get(9) && varidx.get(9) != -99) {
				Data.storeNum(varidx.get(9), i, this.metricLCS.distance(from, to));
			}

			if (metrics.get(10) && varidx.get(10) != -99) {
				Data.storeNum(varidx.get(10), i, this.ngrams.distance(from, to));
			}

			if (metrics.get(11) && varidx.get(11) != -99) {
				Data.storeNum(varidx.get(11), i, this.normalizedLev.similarity(from, to));
			}

			if (metrics.get(12) && varidx.get(12) != -99) {
				Data.storeNum(varidx.get(12), i, this.normalizedLev.distance(from, to));
			}

			if (metrics.get(13) && varidx.get(13) != -99) {
				Data.storeNum(varidx.get(13), i, this.qgrams.distance(from, to));
			}

			if (metrics.get(14) && varidx.get(14) != -99) {
				Data.storeNum(varidx.get(14), i, this.dice.similarity(from, to));
			}

			if (metrics.get(15) && varidx.get(15) != -99) {
				Data.storeNum(varidx.get(15), i, this.dice.distance(from, to));
			}

		}
	}



}
