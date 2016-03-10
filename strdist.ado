/******************************************************************************
*                                                                             *
* DESCRIPTION:                                                                *
*   Add information about what the strdist command does.                      *
*   Ex.                                                                       *
*   This program calls the distance method of the StringUtilities class used  *
*   to estimate the distance between strings using either a fuzzy distance,   *
*   jaro-winkler distance, or the levenshtein edit distance metrics.          *
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
cap prog drop strdist

// Define program
prog def strdist

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
	syntax varlist(min=2 max=2 string) [if] [in] [, LOCale(string asis)      ///
	COSSim(string asis) COSDist(string asis) COSConf(string asis)			 ///
	Damerau(string asis) JACCARDSim(string asis) JACCARDDist(string asis)	 ///
	JACCARDConf(string asis) JAROWINKLERSim(string asis)					 ///
	JAROWINKLERDist(string asis) JAROWINKLERConf(string asis)				 ///
	LEVenshtein(string asis) LONGSUBSTRing(string asis)						 ///
	METriclcs(string asis) NGRAMDist(string asis) NGRAMConf(string asis)	 ///
	NORMLEVSim(string asis) NORMLEVDist(string asis) QGRAMDist(string asis)  ///
	QGRAMConf(string asis) DICESim(string asis) DICEDist(string asis)		 ///
	DICEConf(string asis) ]

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
	if `"`locale'"' == "" loc locale `""""'
	if `"`cossim'"' == "" loc cossim `""""'
	if `"`cosdist'"' == "" loc cosdist  `""""'
	if `"`cosconf'"' == "" loc cosconf `""""'
	if `"`damerau'"' == "" loc damerau `""""'
	if `"`jaccardsim'"' == "" loc jaccardsim `""""'
	if `"`jaccarddist'"' == "" loc jaccarddist `""""'
	if `"`jaccardconf'"' == "" loc jaccardconf `""""'
	if `"`jarowinklersim'"' == "" loc jarowinklersim `""""'
	if `"`jarowinklerdist'"' == "" loc jarowinklerdist `""""'
	if `"`jarowinklerconf'"' == "" loc jarowinklerconf `""""'
	if `"`levenshtein'"' == "" loc levenshtein `""""'
	if `"`levenshtein'"' == "" loc levenshtein `""""'
	if `"`longsubstring'"' == "" loc longsubstring  `""""'
	if `"`metriclcs'"' == "" loc metriclcs `""""'
	if `"`ngramdist'"' == "" loc ngramdist `""""'
	if `"`ngramconf'"' == "" loc ngramconf `""""'
	if `"`normlevsim'"' == "" loc normlevsim `""""'
	if `"`normlevdist'"' == "" loc normlevdist `""""'
	if `"`qgramdist'"' == "" loc qgramdist `""""'
	if `"`qgramconf'"' == "" loc qgramconf `""""'
	if `"`dicesim'"' == "" loc dicesim `""""'
	if `"`dicedist'"' == "" loc dicedist `""""'
	if `"`diceconf'"' == "" loc diceconf `""""'

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
    javacall org.paces.Stata.StringUtils.StringUtilities distance `varlist'  ///
    `if' `in', args(`locale' `cossim' `cosdist' `cosconf' `damerau'			 ///
    `jaccardsim' `jaccarddist' `jaccardconf' `jarowinklersim'				 ///
    `jarowinklerdist' `jarowinklerconf' `levenshtein' `longsubstring'		 ///
    `metriclcs' `ngramdist' `ngramconf' `normlevsim' `normlevdist'			 ///
    `qgramdist' `qgramconf' `dicesim' `dicedist' `diceconf' )

// End of subroutine
end

