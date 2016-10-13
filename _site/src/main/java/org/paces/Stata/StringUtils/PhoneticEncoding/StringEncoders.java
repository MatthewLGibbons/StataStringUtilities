package org.paces.Stata.StringUtils.PhoneticEncoding;

import com.stata.sfi.Data;
import org.paces.Stata.MetaData.Meta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * Class used to phonetically encode strings
 * See http://commons.apache.org/proper/commons-codec/apidocs/index.html
 * for additional information.
 * @author Billy Buchanan
 * @version 0.0.0
 */
public class StringEncoders {

	/**
	 * String reference used to initialize Caverphone1 class object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Caverphone1.html
	 * for additional information.
	 */
	public final String cav1 = "org.apache.commons.codec.language.Caverphone1";

	/**
	 * String reference used to initialize Caverphone2 class object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Caverphone2.html
	 * for additional information.
	 */
	public final String cav2 = "org.apache.commons.codec.language.Caverphone2";

	/**
	 * String reference used to initialize Cologne Phonetic encoding class
	 * objects.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/ColognePhonetic.html
	 * for additional information.
	 */
	public final String koln = "org.apache.commons.codec.language.ColognePhonetic";

	/**
	 * String reference used to initialize Daitch Mokotoff Soundex class
	 * object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/DaitchMokotoffSoundex.html
	 * for additional information.
	 */
	public final String dmSoundex = "org.apache.commons.codec.language.DaitchMokotoffSoundex";

	/**
	 * String reference used to initialize Double Metaphone class object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/DoubleMetaphone.html
	 * for additional information.
	 */
	public final String dblMetaphone = "org.apache.commons.codec.language.DoubleMetaphone";

	/**
	 * String reference used to initialize Match Rating Approach encoder.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/MatchRatingApproachEncoder.html
	 * for additional information
	 */
	public final String matchRating = "org.apache.commons.codec.language.MatchRatingApproachEncoder";

	/**
	 * String reference used to initialize Metaphone class object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Metaphone.html
	 * for additional information
	 */
	public final String metaphone = "org.apache.commons.codec.language.Metaphone";

	/**
	 * String reference used to initialize Nysiis class object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Nysiis.html
	 * for additional information
	 */
	public final String nysiis = "org.apache.commons.codec.language.Nysiis";

	/**
	 * String reference used to initialize Beider Morse class object.  See
	 * http://commons.apache.org/proper/commons-codec/apidocs/index.html
	 * for additional information
	 */
	public final String bmEncode = "org.apache.commons.codec.language.bm.BeiderMorseEncoder";

	/**
	 * Object used to retrieve data from the dataset that is active in memory
	 */
	private Meta metaData;

	/**
	 * Class constructor
	 * @param metadata A meta class object used to access the data that is
	 *                    active in memory in Stata.
	 */
	public StringEncoders(Meta metadata) {
		this.metaData = metadata;
	}

	/**
	 * Method that returns a Match Rating Approach encoded string
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void matchRating(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, matchRating);
	}


	/**
	 * Method that returns a Beider Morse Encoded String
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void beiderMorse(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, bmEncode);
	}

	/**
	 * Method that returns a Nysiis Encoded String
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void nysiis(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, nysiis);
	}

	/**
	 * Method that returns a Metaphone Encoded String
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void metaphone(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, metaphone);
	}

	/**
	 * Method that returns a Double Metaphone Encoded String
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void doubleMetaphone(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, dblMetaphone);
	}



	/**
	 * Method that returns a Daitch Mokotoff Soundex encoded string
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void daitchMokotoff(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, dmSoundex);
	}

	/**
	 * Method that returns a Cologne Phonetic Encoded string
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void koln(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, koln);
	}

	/**
	 * Method that returns a Caverphone v 1.0 Encoded String
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void caverphone1(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, cav1);
	}

	/**
	 * Method that returns a Caverphone v 2.0 Encoded String
	 * @param varname A variable name to use when initializing the variable
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void caverphone2(String varname)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {
		encoder(varname, cav2);
	}

	/**
	 * Method used to dynamically encode the string using the appropriate
	 * algorthem
	 * @param varname The variable name to push the results into
	 * @param clsName The name of the class to use for the encoding
	 * @throws ClassNotFoundException Error thrown if the codec class is not
	 * found
	 * @throws NoSuchMethodException Error thrown if the codec class is not
	 * found (each of the classes implements the method encode that accepts a
	 * string argument)
	 * @throws IllegalAccessException Error thrown by the reflections
	 * implementation
	 * @throws InstantiationException Error thrown if there is an issue
	 * creating a new instance of the class object
	 * @throws InvocationTargetException Error thrown if there is an issue
	 * invoking the encode method of the object
	 */
	public void encoder(String varname, String clsName)
			throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException {

		if (!varname.isEmpty()) {

			// Creates the caverphone variable
			Data.addVarStr(varname, 5);

			// Get the variable index value for the variable used to store the
			Integer newvaridx = Data.getVarIndex(varname);

			// Loop over observations
			for (Number i : this.metaData.getObsindex()) {

				// Build a string with values from varlist
				StringJoiner s = new StringJoiner(" ");

				// Loops over the variable list
				for (Integer j : this.metaData.getVarindex()) {

					// Adds string data to the string
					s.add(Data.getStr(j, i.longValue()));

				} // Ends loop over the string

				// Initializes new class object based on the static names
				Class<?> cls = Class.forName(clsName);

				// Initializes a new object of that class
				Object enc = cls.newInstance();

				// gets the method used for encoding the string
				Method getString = cls.getDeclaredMethod("encode", Class.forName("java.lang.String"));

				// Encodes the string value and returns the caverphone 1 string
				Data.storeStr(newvaridx, i.longValue(),
					(String) getString.invoke(enc, s.toString()));

			} // End Loop over observations

		} // End IF Block for valid case

	} // End of Method declaration

} // End of Class declaration
