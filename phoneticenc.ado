/******************************************************************************
*                                                                             *
* DESCRIPTION:                                                                *
*   Add information about what the strutil command does.                      *
*   Ex.                                                                       *
*   This program calls the strutil of the StringUtilities class.  This        *
*   method does a thing that I find useful and believe will help others as    *
*   well.                                                                     *
*                                                                             *
* DATA REQUIREMENTS:                                                          *
*   Does the program require any specific types of data/formatting?  If so,   *
*   make a note of it so you'll remember when debugging/helping users.        *
*                                                                             *
* JAVA REQUIREMENTS:                                                          *
*   The Stata Java API binary will already be on the class path.  But that    *
*   doesn't mean that users will have all of the binaries on their classpath  *
*   if it requires Java binaries that you can't distribute.  List these here  *
*   along with the JDK used for the build.                                    *
*   Requires JDK 1.8 or higher                                                *
*                                                                             *
* SYSTEM REQUIREMENTS:                                                        *
*   Does the user need any special permissions/system configurations (e.g.,   *
*   a commonly defined DSN for an ODBC connection, admin permissions,         *
*   a private network connection, etc...).  If so, list that information      *
*                                                                             *
* INPUT REQUIREMENTS:                                                         *
*   If the program requires any specific variables and/or other elements to   *
*   operate on, you should list them here.  For example, if the program looks *
*   for files in a specific directory tree structure, you should include that *
*   here.                                                                     *
*                                                                             *
* OUTPUT:                                                                     *
*   What values/variables/results should the user expect?  List them here.    *
*                                                                             *
******************************************************************************/

// Drop program from memory of previously loaded
cap prog drop phoneticenc

// Define program
prog def phoneticenc

	// Set version for Stata interpretation
	version 14.1

	/*
	Set program syntax
	This contains nearly all the parameter types and their options on separate
	lines of code.  This is to make it easier to copy/paste parameter types and
	argument definitions to build out your own customized syntax with greater
	speed and efficiency.  It also provides an immediate overview of the
	options available using the syntax command to parse the command.  For some
	options you will still need to consult the syntax help documentation to
	make sure there aren't cases where your options create incompatability
	issues.
	*/
	syntax [varlist(min=1 string)] [if] [in] [, caverphone1(string asis)     ///
    caverphone2(string asis) COLogne(string asis) DMSoundex(string asis)     ///
    DBLMetaphone(string asis) METAPhone(string asis) NYSiis(string asis)     ///
    BEIDERMorse(string asis) MATCHRating(string asis) ]

	// Deal with the if/in qualifiers after this you can use the reference
	// if `touse' to handle any/all if/in arguments.
	marksample touse

	/*
	Stata logic and commands for processing the wrapper go here.
	For example, what is the difference between using and not using the
	optional parameter option above?  It's also helpful to annotate what you
	are doing/why you are doing it with the logic so you can have a handy
	reminder when/if working on the project in the future.
	*/
	if `"`caverphone1'"' == "" loc caverphone1 `""""'
	if `"`caverphone2'"' == "" loc caverphone2 `""""'
	if `"`cologne'"' == "" loc cologne `""""'
	if `"`dmsoundex'"' == "" loc dmsoundex `""""'
	if `"`dblmetaphone'"' == "" loc dblmetaphone `""""'
	if `"`metaphone'"' == "" loc metaphone `""""'
	if `"`nysiis'"' == "" loc nysiis `""""'
	if `"`beidermorse'"' == "" loc beidermorse `""""'
	if `"`matchrating'"' == "" loc matchrating `""""'

    /*
    Call the java plugin from Stata.
    I'd suggest passing in as many arguments as possible to the arguments option
    since it will make your Java plugin a bit less reliant on Stata for testing
    and debugging purposes (e.g., the args() option is the Stata version of the
    main(String[] args) method for a Java class).  If all the arguments are
    passed via the args parameter you should be able to throw a main method
    into the same class to test and debug the plugin from the command line
    independently of Stata.
    */
    javacall org.paces.Stata.StringUtils.StringUtilities strutil `if' `in',  ///
    args(`caverphone1' `caverphone2' `cologne' `dmsoundex' `dblmetaphone'    ///
    `metaphone' `nysiis' `beidermorse' `matchrating')

    /*
    Process returned values here.
    If your plugin needs to return many values, into something like a return
    matrix there is an example that shows one approach to doing so from your
    Java plugin in: https://github.com/wbuchanan/StatajMetrik/.
    The Mata functions in that repository are used to process the scalar values,
    arrange them into matrices, and return the matrices to the user.
    */


// End of subroutine
end


