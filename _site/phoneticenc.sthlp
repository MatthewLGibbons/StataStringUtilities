{smcl}
{* *! version 0.0.1 11mar2016}{...}
{cmd:help phoneticenc}
{hline}

{marker phoneticenc}{p 2 2 2}{title:phoneticenc}{p_end}

{p 4 4 4}{hi:phoneticenc {hline 2}} program that provides access to phonetic
string encoding algorithms from the
{browse "http://commons.apache.org/proper/commons-codec/":Apache Commons Codec Java Library}. {p_end}

{marker syntax}{p 2 2 2}{title:Syntax}{p_end}

{p 4 4 4}{cmd:phoneticenc} {varlist} {ifin} [,
{cmd:caverphone1(}{it:varname}{opt )}
{cmd:caverphone2(}{it:varname}{opt )}
{cmdab:col:ogne(}{it:varname}{opt )}
{cmdab:dms:oundex(}{it:varname}{opt )}
{cmdab:dblm:etaphone(}{it:varname}{opt )}
{cmdab:metap:hone(}{it:varname}{opt )}
{cmdab:nys:iis(}{it:varname}{opt )}
{cmdab:beiderm:orse(}{it:varname}{opt )}
{cmdab:matchr:ating(}{it:varname}{opt )}]

{p 4 4 8} the command can accept one or more variables to encode.  When a
varlist is passed, the strings are concatenated with a space between the
variable values.{p_end}

{marker opts}{p 2 2 2}{title:Options}{p_end}

{p 4 4 8}{cmd:caverphone1} used to define the variable where the
Caverphone v. 1 encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Caverphone1.html"} for
additional information. {p_end}

{p 4 4 8}{cmd:caverphone2} used to define the variable where the
Caverphone v. 2 encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Caverphone2.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:col:ogne} used to define the variable where the Cologne
Phonetic encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/ColognePhonetic.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:dms:oundex} used to define the variable where the Daitch
Mokotoff Soundex encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/DaitchMokotoffSoundex.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:dblm:etaphone} used to define the variable where the
Double Metaphone encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/DoubleMetaphone.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:metap:hone} used to define the variable where the
Metaphone encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Metaphone.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:nys:iis} used to define the variable where the Nysiis encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/Nysiis.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:beiderm:orse} used to define the variable where the
Beider Morse encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See {browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/bm/BeiderMorseEncoder.html"} for
additional information. {p_end}

{p 4 4 8}{cmdab:matchr:ating} used to define the variable where the Match
Rating Approach encoded strings will be stored.  Passing an argument to the
parameter triggers encoding the data with this algorithm.  See
{browse "http://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/language/MatchRatingApproachEncoder.html"} for
additional information.{p_end}

{marker examples}{p 2 2 2}{title:Examples}{p_end}

{p 4 4 4}Encoding car models/makes using all algorithms. {p_end}

{p 8 8 12}{stata phoneticenc make, caverphone1(cav1) caverphone2(cav2) col(kolner) dms(daitch) dblm(dblmeta) metap(metaphone) nys(nysiis) beiderm(bmencode) matchrating(mrating)}{p_end}

{marker issues}{p 2 2 2}{title:Issues, Bugs, and Enhancement Requests}{p_end}

{p 4 4 4}Please submit any issues, bugs, and future enhancement requests to
the project respository: {p_end}

{p 12 12 12}{browse "https://github.com/wbuchanan/StataStringUtilities/issues"}{p_end}

{marker author}{p 2 2 2}{title:Author}{p_end}
{p 4 4 4}William R Buchanan{p_end}
{p 4 4 4}Performing Arts & Creative Education Solutions Consulting{p_end}
{p 4 4 4}william@williambuchanan.net{p_end}

