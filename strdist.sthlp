{smcl}
{* *! version 0.0.1 01mar2016}{...}
{cmd:help strdist}
{hline}

{marker strdist}{p 2 2 2}{title:String Distance Metrics}{p_end}

{p 4 4 4}{hi:strdist {hline 2}} is a wrapper around the 
{browse "https://github.com/tdebatty/java-string-similarity":java-string-similarity} library developed by
{browse "http://debatty.info/":Thibault Debatty}{p_end}

{marker syntax}{p 2 2 2}{title:Syntax}{p_end}

{p 4 4 4}{cmd:strdist} {varlist} {ifin} [, {cmdab:loc:ale(}{it:string}{opt )}
{cmdab:coss:im(}{it:varname}{opt )} {cmdab:cosd:ist(}{it:varname}{opt )}
{cmdab:cosc:onf(}{it:integer}{opt )} {cmdab:d:amerau(}{it:varname}{opt )}
{cmdab:jaccards:im(}{it:varname}{opt )} {cmdab:jaccardd:ist(}{it:varname}{opt )}
{cmdab:jaccardc:onf(}{it:integer}{opt )} {cmdab:jarowinklers:im(}{it:varname}{opt )}
{cmdab:jarowinklerd:ist(}{it:varname}{opt )} {cmdab:jarowinklerc:onf(}{it:string}{opt )}
{cmdab:lev:enshtein(}{it:varname}{opt )} {cmdab:longsubs:equence(}{it:varname}{opt )}
{cmdab:met:riclcs(}{it:varname}{opt )} {cmdab:ngramd:ist(}{it:varname}{opt )}
{cmdab:ngramc:onf(}{it:integer}{opt )} {cmdab:normlevs:im(}{it:varname}{opt )}
{cmdab:normlevd:ist(}{it:varname}{opt )} {cmdab:qgramd:ist(}{it:varname}{opt )}
{cmdab:qgramc:onf(}{it:integer}{opt )} {cmdab:dices:im(}{it:varname}{opt )}
{cmdab:diced:ist(}{it:varname}{opt )} {cmdab:dicec:onf(}{it:integer}{opt )}

{p 4 4 8} the command requires two variables be passed to the varlist, the
baseline (from) string and the comparison (to) string variables.{p_end}

{marker opts}{p 2 2 2}{title:Options}{p_end}

{p 4 4 8}{cmdab:loc:ale} used to specify a different locality from the
default locality that Java will identify on your system. {p_end}

{p 4 4 8}{cmdab:coss:im} is an option used to define the variable where the 
Cosine string similarity will be stored.{p_end}

{p 4 4 8}{cmdab:cosd:ist} is an option used to define the variable where the 
Cosine string distance will be stored.{p_end}

{p 4 4 8}{cmdab:cosc:onf} is an option used define the size of the k-shingles, 
or n-grams, to be used when transforming the strings.{p_end}

{p 4 4 8}{cmdab:d:amerau} is an option used to define the variable where the 
Damerau string distance will be stored.{p_end}

{p 4 4 8}{cmdab:jaccards:im} is an option used to define the variable where the 
Jaccard string similarity will be stored.{p_end}

{p 4 4 8}{cmdab:jaccardd:ist} is an option used to define the variable where the
Jaccard string distance will be stored.{p_end}

{p 4 4 8}{cmdab:jaccardc:onf} is an option used define the size of the k-shingles, 
or n-grams, to be used when transforming the strings. A default value of 3 is 
used if no value is provided by the user.{p_end}

{p 4 4 8}{cmdab:jarowinklers:im} is an option used to define the variable where 
the Jaro-Winkler string similarity will be stored.{p_end}

{p 4 4 8}{cmdab:jarowinklerd:ist} is an option used to define the variable where 
the Jaro-Winkler string distance will be stored.{p_end}

{p 4 4 8}{cmdab:jarowinklerc:onf} is an option used to set the threshold determining 
when the Winkler bonus will be applied.  If a negative number is passed to this 
option it will result in the Jaro similarity/distance metrics.{p_end}

{p 4 4 8}{cmdab:lev:enshtein} is an option used to define the variable where the 
Levenshtein Edit distance will be stored.{p_end}

{p 4 4 8}{cmdab:longsubs:equence} is an option used to define the variable where
the Longest Common Subsequence distance will be stored.{p_end}

{p 4 4 8}{cmdab:met:riclcs} is an option used to define the variable where the 
Bakkelund string distance will be stored.{p_end}

{p 4 4 8}{cmdab:ngramd:ist} is an option used to define the variable where the 
N-Gram string distance will be stored.{p_end}

{p 4 4 8}{cmdab:ngramc:onf} is an option used to specify the size of the k-shingles when estimating the N-gram distance{p_end}

{p 4 4 8}{cmdab:normlevs:im} is an option used to define the variable where the 
Normalized Levenshtein string similarity will be stored. {p_end}

{p 4 4 8}{cmdab:normlevd:ist} is an option used to define the variable where the 
Normalized Levenshtein string distance will be stored.{p_end}

{p 4 4 8}{cmdab:qgramd:ist} is an option used to define the variable where the 
Q-Gram string distance will be stored.  This is the a lower bound on the 
Levenshtein Edit Distance.{p_end}

{p 4 4 8}{cmdab:qgramc:onf} is an option used to specify the size of the k-shingles,
 or n-grams, used when estimating the Q-Gram distance.{p_end}

{p 4 4 8}{cmdab:dices:im} is an option used to define the variable where the 
Sorensen Dice similarity will be stored.{p_end}

{p 4 4 8}{cmdab:diced:ist} is an option used to define the variable where the 
Sorensen Dice distance will be stored.{p_end}

{p 4 4 8}{cmdab:dicec:onf} is an option used to specify the size of the k-shingles,
 or n-grams, used when estimating the Sorensen Dice indices.{p_end}

{marker examples}{p 2 2 2}{title:Examples}{p_end}
{p 8 8 12}{stata sysuse census, clear}{p_end}
{p 8 8 12}strdist state state2, coss(cosine_sim) cosd(cosine_dist) damerau(dam) jaccards(jaccard_sim) jaccardd(jaccard_dist)
lev(levenshtein) longsubstr(longsubstring) met(metriclcs) ngramd(ngram_distance) ngramc(4)
normlevs(normal_levenshtein_similarity) normlevd(normal_levenshtein_distance) qgramd(qgram_distance) qgramc(4)
dices(sorensen_similarity) diced(sorensen_distance) jarowinklers(jw_sim) jarowinklerd(jw_dist){p_end}

{marker issues}{p 2 2 2}{title:Issues, Bugs, and Enhancement Requests}{p_end}

{p 4 4 4}Please submit any issues, bugs, and future enhancement requests to
the project respository: {p_end}

{p 12 12 12}{browse "https://github.com/wbuchanan/StataStringUtilities/issues"}{p_end}

{marker refs}{p 2 2 2}{title:References}{p_end}
{p 4 8 8}Bakkelund, D. (2009).  {it:An LCS-based string metric}.  {browse "http://heim.ifi.uio.no/~danielry/StringMetric.pdf":Retrieved from: http://heim.ifi.uio.no/~danielry/StringMetric.pdf}.  Retrieved on: 10mar2016.{p_end}
{p 4 8 8}Kondrak, G. (2005).  N-gram similarity and distance.  In {it:Proceedings of the 12th International Conference on String Processing and Information Retrieval, Buenos Aires, Argentina}.  pages 115-126,
{browse "http://webdocs.cs.ualberta.ca/~kondrak/papers/spire05.pdf":Retrieved from: http://webdocs.cs.ualberta.ca/~kondrak/papers/spire05.pdf}, Retrieved on 10mar2016.{p_end}



{marker author}{p 2 2 2}{title:Author}{p_end}
{p 4 4 4}William R Buchanan{p_end}
{p 4 4 4}Performing Arts & Creative Education Solutions Consulting{p_end}
{p 4 4 4}william@williambuchanan.net{p_end}

