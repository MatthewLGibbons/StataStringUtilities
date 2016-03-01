package org.paces.Stata.StringUtils;

import com.stata.sfi.SFIToolkit;
import org.paces.Stata.MetaData.Meta;
import org.paces.Stata.StringUtils.PhoneticEncoding.StringEncoders;
import org.paces.Stata.StringUtils.Similarity.DistanceMetrics;

import java.lang.reflect.InvocationTargetException;

/**
 * Package for string manipulation in Stata
 *
 * @author William R Buchanan
 * @version 0.0.0-SNAPSHOT
 */
public class StringUtilities {

	/**
	 * Method that dispatches the string encoding methods
	 * @param args Arguments passed from the javacall, args() option
	 * @return The method must return an integer value to conform to the Java
	 * API expectations.  Non-zero values trigger errors (much the same way
	 * that non-zero returns in other compiled languages often indicate errors)
	 */
	public static int strutil(String[] args) {
		StringEncoders sencode = new StringEncoders(new Meta(args));
		try {
			if (!args[0].isEmpty()) sencode.caverphone1(args[0]);
			if (!args[1].isEmpty()) sencode.caverphone2(args[1]);
			if (!args[2].isEmpty()) sencode.koln(args[2]);
			if (!args[3].isEmpty()) sencode.daitchMokotoff(args[3]);
			if (!args[4].isEmpty()) sencode.doubleMetaphone(args[4]);
			if (!args[5].isEmpty()) sencode.metaphone(args[5]);
			if (!args[6].isEmpty()) sencode.nysiis(args[6]);
			if (!args[7].isEmpty()) sencode.beiderMorse(args[7]);
			if (!args[8].isEmpty()) sencode.matchRating(args[8]);
			return 0;
		} catch (ClassNotFoundException | NoSuchMethodException |
				IllegalAccessException | InstantiationException |
				InvocationTargetException e) {
			SFIToolkit.errorln(SFIToolkit.stackTraceToString(e));
			return 1;
		}
	}

	/**
	 * Method that implements string distance metrics
	 * @param args Args passed from args parameter of Java Call.  Only
	 *                optional Locale setting
	 * @return A success indicator
	 */
	public static int distance(String[] args) {
		new DistanceMetrics(args);
		return 0;
	}

} // End of Class declaration
