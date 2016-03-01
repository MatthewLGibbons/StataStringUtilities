{smcl}
{* *! version 0.0.1 01mar2016}{...}
{cmd:help strdist}
{hline}

{marker strdist}{p 2 2 2}{title:String Distance Metrics}{p_end}

{p 4 4 4}{hi:strdist {hline 2}} program that provides access to string
distance algorithms from the
{browse "http://commons.apache.org/proper/commons-lang/":Apache Commons Lang Java Library}. {p_end}

{marker syntax}{p 2 2 2}{title:Syntax}{p_end}

{p 4 4 4}{cmd:strdist} {varlist} {ifin} [, {cmdab:loc:ale(}{it:string}{opt )}
{cmdab:f:uzzy} {cmdab:j:aro} {cmdab:l:evenshtein}]

{p 4 4 8} the command requires two variables be passed to the varlist, the
baseline (from) string and the comparison (to) string variables.{p_end}

{marker opts}{p 2 2 2}{title:Options}{p_end}

{p 4 4 8}{cmdab:loc:ale} used to specify a different locality from the
default locality that Java will identify on your system. {p_end}

{p 4 4 8}{cmdab:f:uzzy} used to estimate a fuzzy string distance metric.
See {browse "http://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringUtils.html#getFuzzyDistance(java.lang.CharSequence,%20java.lang.CharSequence,%20java.util.Locale)"} for
additional information. {p_end}

{p 4 4 8}{cmdab:j:aro} used to estimate the Jaro Winkler distance.
See {browse "http://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringUtils.html#getJaroWinklerDistance(java.lang.CharSequence,%20java.lang.CharSequence)"} for
additional information. {p_end}

{p 4 4 8}{cmdab:l:evenshtein} used to estimate the Levenshtein edit distance.
See {browse "http://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/StringUtils.html#getLevenshteinDistance(java.lang.CharSequence,%20java.lang.CharSequence)"} for
additional information. {p_end}

{marker examples}{p 2 2 2}{title:Examples}{p_end}

{p 4 4 4}Make sample data. {p_end}

{p 8 8 12}clear{p_end}
{p 8 8 12}input str5 housenum str13 street str10 city str2 state str5 zip{p_end}
{p 8 8 12}"4287" "46th Ave N" "Robbinsdale" "MN" "55422"{p_end}
{p 8 8 12}"6675" "Old Canton Rd" "Ridgeland" "MS" "39157"{p_end}
{p 8 8 12}"12313" "33rd Ave NE" "Seattle" "WA" "98125"{p_end}
{p 8 8 12}"310" "Cahir St" "Providence" "RI" "02903"{p_end}
{p 8 8 12}"22" "Oaklawn Ave" "Cranston" "RI" "02920"{p_end}
{p 8 8 12}"61 " "Pine St" "Attleboro" "MA" "02703"{p_end}
{p 8 8 12}" 10" "Larkspur Rd" "Warwick" "RI" "02886"{p_end}
{p 8 8 12}"91" "Fallon Ave" "Providence" "RI" "02908"{p_end}
{p 8 8 12}"1 9 5" "Arlington Ave" "Providence" "RI" "02906"
{p 8 8 12}end{p_end}

{p 8 8 12}{stata strdist street city, f j l}{p_end}

{marker issues}{p 2 2 2}{title:Issues, Bugs, and Enhancement Requests}{p_end}

{p 4 4 4}Please submit any issues, bugs, and future enhancement requests to
the project respository: {p_end}

{p 12 12 12}{browse "https://github.com/wbuchanan/StataStringUtilities/issues"}{p_end}

{marker author}{p 2 2 2}{title:Author}{p_end}
{p 4 4 4}William R Buchanan{p_end}
{p 4 4 4}Performing Arts & Creative Education Solutions Consulting{p_end}
{p 4 4 4}william@williambuchanan.net{p_end}

