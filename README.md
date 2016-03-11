[![Project Status: Active - The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active)

# Stata String Utilities
This package contains two Stata programs that are wrappers for Java plugins: `phoneticenc` and `strdist`.  

The `phoneticenc` command provides users with alternatives to the [soundex](http://www.stata.com/manuals14/fnstringfunctions.pdf) and [soundex_nara](http://www.stata.com/manuals14/fnstringfunctions.pdf) functions native to Stata 14.  
These include the [Beider-Morse](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/bm/BeiderMorseEncoder.html), [Caverphone 1](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/Caverphone1.html), [Caverphone 2](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/Caverphone2.html), [Daitch-Mokotoff](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/DaitchMokotoffSoundex.html), [Double Metaphone](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/DoubleMetaphone.html), 
[Kölner Phonetik](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/ColognePhonetic.html), [Match Rating Approach](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/MatchRatingApproachEncoder.html), [Metaphone](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/Metaphone.html), and [Nysiis](https://commons.apache.org/proper/commons-codec/archives/1.10/apidocs/org/apache/commons/codec/language/Nysiis.html) phonetic encoding algorithms.


The `strdist` command provides users with several different string similarity and distance metrics including: 
Cosine similarity/distance, Damerau distance, Jaccard similarity/distance, Jaro-Winkler similarity/distance, 
Jaro similarity/distance, Levenshtein edit distance, Longest Common Subsequence distance, Bakkelund Longest Common Subsequence distance, 
N-Gram distance, Normalized Levenshtein similarity/distance, Q-Gram distance, and the Sorensen Dice similarity/distance _metrics_.    


# Examples

## Phonetic String Encoding
The example below shows how the strutil command can be used to generate several different phonetic encodings of a given string.  

```
. sysuse auto.dta, clear
. phoneticenc make, caverphone1(cav1) caverphone2(cav2) col(kolner) dms(daitch) dblm(dblmeta) metap(metaphone) nys(nysiis) beiderm(bmencode) matchrating(mrating)
. li make cav1 cav2 kolner daitch in 1/5

     +---------------------------------------------------------------------------------+
     | make              cav1         cav2                             kolner   daitch |
     |---------------------------------------------------------------------------------|
  1. | AMC Concord     AMKNKT   AMKNKTNNNN   06846472656565656565656565656565   064649 |
  2. | AMC Pacer       AMKPSN   AMKPSNNNNN     068187656565656565656565656565   064749 |
  3. | AMC Spirit      AMKSPR   AMKSPRTNNN    0688172656565656565656565656565   064793 |
  4. | Buick Century   PKSNTR   PKSNTRNNNN     148627656565656565656565656565   754639 |
  5. | Buick Electra   PKLKTR   PKLKTRNNNN     145827656565656565656565656565   758439 |
     +---------------------------------------------------------------------------------+

. li make dblmeta metaphone nysiis mrating in 1/5

     +-------------------------------------------------------+
     | make            dblmeta   metaph~e   nysiis   mrating |
     |-------------------------------------------------------|
  1. | AMC Concord        AMKN       AMKK   ANCANC    AMCLNL |
  2. | AMC Pacer          AMKP       AMKP   ANCPAC    AMCLNL |
  3. | AMC Spirit         AMKS       AMKS   ANCSPA    AMCLNL |
  4. | Buick Century      PKSN       BKSN   BACANT    BCKLNL |
  5. | Buick Electra      PKLK       BKLK   BACALA    BCKLNL |
     +-------------------------------------------------------+

. li make bmencode in 1/5

     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
  1. |                                                                                                 make                                                                                                           |
     |                                                                                                 AMC Concord                                                                                                    |
     |----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     | bmencode                                                                                                                                                                                                       |
     | amgzonkordnulnulnulnulnulnulnulnulnulnulnulnul|amgzonzordnulnulnulnulnulnulnulnulnulnulnulnul|amkonkordnulnulnulnulnulnulnulnulnulnulnulnul|amkonkurdnulnulnulnulnulnulnulnulnulnulnulnul|amkontsordnulnulnu.. |
     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
  2. |                                                                                                 make                                                                                                           |
     |                                                                                                 AMC Pacer                                                                                                      |
     |----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     | bmencode                                                                                                                                                                                                       |
     | amkpakirnulnulnulnulnulnulnulnulnulnulnulnul|amkpasirnulnulnulnulnulnulnulnulnulnulnulnul|amkpatsirnulnulnulnulnulnulnulnulnulnulnulnul|amkpazirnulnulnulnulnulnulnulnulnulnulnulnul|amkpokirnulnulnulnulnul.. |
     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
  3. |                                                                                                 make                                                                                                           |
     |                                                                                                 AMC Spirit                                                                                                     |
     |----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     | bmencode                                                                                                                                                                                                       |
     | amkspirinulnulnulnulnulnulnulnulnulnulnulnul|amkspiritnulnulnulnulnulnulnulnulnulnulnulnul|amtspiritnulnulnulnulnulnulnulnulnulnulnulnul|amzspiritnulnulnulnulnulnulnulnulnulnulnulnul|ankspirinulnulnulnuln.. |
     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
  4. |                                                                                                 make                                                                                                           |
     |                                                                                                 Buick Century                                                                                                  |
     |----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     | bmencode                                                                                                                                                                                                       |
     | bDknturinulnulnulnulnulnulnulnulnulnulnulnul|bDksnturinulnulnulnulnulnulnulnulnulnulnulnul|bDktsnturinulnulnulnulnulnulnulnulnulnulnulnul|bDtsksnturinulnulnulnulnulnulnulnulnulnulnulnul|bDtsktsnturinulnul.. |
     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
  5. |                                                                                                 make                                                                                                           |
     |                                                                                                 Buick Electra                                                                                                  |
     |----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     | bmencode                                                                                                                                                                                                       |
     | bDkiliktranulnulnulnulnulnulnulnulnulnulnulnul|bDkiliktronulnulnulnulnulnulnulnulnulnulnulnul|bDkilitstranulnulnulnulnulnulnulnulnulnulnulnul|bDkilitstronulnulnulnulnulnulnulnulnulnulnulnul|bDkliktranulnu.. |
     +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

```

## String Distance
These examples are based on similar examples in the help file for the [jarowinkler](https://github.com/jamesfeigenbaum/jarowinkler-ado) program developed by James Feigenbaum and available from the SSC archives.

```
. sysuse census, clear
(1980 Census data by state)

. keep state state2

. // Get all of the different distance and similarity metrics
. strdist state state2, coss(cosine_sim) cosd(cosine_dist) damerau(dam)            ///
> jaccards(jaccard_sim) jaccardd(jaccard_dist) lev(levenshtein)                    ///
> longsubstr(longsubstring) met(metriclcs) ngramd(ngram_distance) ngramc(4)        ///
> normlevs(normlev_similarity) normlevd(normlev_distance) qgramd(qgram_dist)       ///
> qgramc(4) dices(sorensen_similarity) diced(sorensen_distance)                    ///
> jarowinklers(jw_sim) jarowinklerd(jw_dist)

. // Get the Jaro only metrics
. strdist state state2, jarowinklers(jaro_sim) jarowinklerd(jaro_dist) jarowinklerc("-1")

. // Describe the data set
. desc

Contains data from C:\Program Files (x86)\Stata14\ado\base/c/census.dta
  obs:            50                          1980 Census data by state
 vars:            20                          6 Apr 2014 15:43
 size:         8,000
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
              storage   display    value
variable name   type    format     label      variable label
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
state           str14   %-14s                 State
state2          str2    %-2s                  Two-letter state abbreviation
cosine_sim      double  %10.0g                Cosine String Similarity
cosine_dist     double  %10.0g                Cosine String Distance
dam             double  %10.0g                Damerau String Distance
jaccard_sim     double  %10.0g                Jaccard String Similarity
jaccard_dist    double  %10.0g                Jaccard String Distance
jw_sim          double  %10.0g                Jaro Winkler String Similarity
jw_dist         double  %10.0g                Jaro Winkler String Distance
levenshtein     double  %10.0g                Levenshtein String Distance
longsubstring   double  %10.0g                Longest Common Substring Distance
metriclcs       double  %10.0g                Bakkelund String Distance
ngram_distance  double  %10.0g                N-Gram String Distance
normlev_simil~y double  %10.0g                Normalized Levenshtein String Similarity
normlev_dista~e double  %10.0g                Normalized Levenshtein String Distance
qgram_dist      double  %10.0g                Q-Gram String Distance
sorensen_simi~y double  %10.0g                Sorensen Dice String Similarity
sorensen_dist~e double  %10.0g                Sorensen Dice String Distance
jaro_sim        double  %10.0g                Jaro String Similarity
jaro_dist       double  %10.0g                Jaro String Distance
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Sorted by:
     Note: Dataset has changed since last saved.

. // Display some of the metrics along side their respective strings
. li state state2 jw_dist jaro_dist jw_sim jaro_sim in 1/5, ab(40)

     +---------------------------------------------------------------------+
     | state        state2     jw_dist   jaro_dist      jw_sim    jaro_sim |
     |---------------------------------------------------------------------|
  1. | Alabama      AL       .19047624   .19047624   .80952376   .80952376 |
  2. | Alaska       AK       .44444442   .39999998   .55555558   .60000002 |
  3. | Arizona      AZ       .21428573   .21428573   .78571427   .78571427 |
  4. | Arkansas     AR       .19999999   .19999999   .80000001   .80000001 |
  5. | California   CA       .21333331   .21333331   .78666669   .78666669 |
     +---------------------------------------------------------------------+

. li state state2 dam jaccard* levenshtein in 1/5, ab(40)

     +----------------------------------------------------------------------+
     | state        state2   dam   jaccard_sim   jaccard_dist   levenshtein |
     |----------------------------------------------------------------------|
  1. | Alabama      AL         5             0              1             5 |
  2. | Alaska       AK         4             0              1             4 |
  3. | Arizona      AZ         5             0              1             5 |
  4. | Arkansas     AR         6             0              1             6 |
  5. | California   CA         8             0              1             8 |
     +----------------------------------------------------------------------+

. li state state2 longsubstring metriclcs norm*  in 1/5, ab(40)

     +-----------------------------------------------------------------------------------------+
     | state        state2   longsubstring   metriclcs   normlev_similarity   normlev_distance |
     |-----------------------------------------------------------------------------------------|
  1. | Alabama      AL                   5   .71428571            .28571429          .71428571 |
  2. | Alaska       AK                   4   .66666667            .33333333          .66666667 |
  3. | Arizona      AZ                   5   .71428571            .28571429          .71428571 |
  4. | Arkansas     AR                   6         .75                  .25                .75 |
  5. | California   CA                   8          .8                   .2                 .8 |
     +-----------------------------------------------------------------------------------------+

. li state state2 ngram* qgram* sorensen* in 1/5, ab(40)

     +---------------------------------------------------------------------------------------------+
     | state        state2   ngram_distance   qgram_dist   sorensen_similarity   sorensen_distance |
     |---------------------------------------------------------------------------------------------|
  1. | Alabama      AL             .2857143            4                     0                   1 |
  2. | Alaska       AK            .16666667            3                     0                   1 |
  3. | Arizona      AZ            .14285715            4                     0                   1 |
  4. | Arkansas     AR                  .25            5                     0                   1 |
  5. | California   CA                   .2            7                     0                   1 |
     +---------------------------------------------------------------------------------------------+

```

# Additional Information
__Requires JRE 1.8 or later__
