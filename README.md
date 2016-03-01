[![Project Status: Active - The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active)

# strutil
Package providing string manipulation utilities in Stata.  Currently, provides phonetic encoding methods for strings.

# Examples

## Phonetic String Encoding
The example below shows how the strutil command can be used to generate several different phonetic encodings of a given string.  

```
. sysuse auto.dta, clear
. strutil make, caverphone1(cav1) caverphone2(cav2) col(kolner) dms(daitch) dblm(dblmeta) metap(metaphone) nys(nysiis) beiderm(bmencode) matchrating(mrating)
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
This example shows some string distance implementations with the example dataset from the [ggeocode](https://github.com/wbuchanan/StataJSON) command.

```
clear 
input str11 city1 str12 city2 
"Robbinsdale" "robbinsdale"
"Ridgeland" "RIDGELAND"
"Seattle" "se@ttle"
"Providence" "Prahvidence"
"Cranston" "crnstin"
"Attleboro" "Attleborough"
"Warwick" "Warick"
"Providence" "Prov"
end

. strdist city1 city2, f j l

. li

     +-------------------------------------------------------------+
     |       city1          city2   fuzzyd~e   jarowi~r   levens~e |
     |-------------------------------------------------------------|
  1. | Robbinsdale    robbinsdale         31          1          1 |
  2. |   Ridgeland      RIDGELAND         25          1          8 |
  3. |     Seattle        se@ttle          4         .9          2 |
  4. |  Providence    Prahvidence          4        .92          2 |
  5. |    Cranston        crnstin         11        .87          3 |
     |-------------------------------------------------------------|
  6. |   Attleboro   Attleborough         25        .95          3 |
  7. |     Warwick         Warick         14        .97          1 |
  8. |  Providence           Prov         10        .88          6 |
     +-------------------------------------------------------------+

```

You can also combine results by first phonetically encoding the data, then estimating the distances between the encoded variabels:

```

. strutil city1, caverphone1(c1a) caverphone2(c2a) col(kolner1a) dms(daitch1a) dblm(dblmeta1a) metap(metaphone1a) nys(nys1a) matchrating(mr1a)

. strutil city2, caverphone1(c1b) caverphone2(c2b) col(kolner1b) dms(daitch1b) dblm(dblmeta1b) metap(metaphone1b) nys(nys1b) matchrating(mr1b)

. 
. loc dvars fuzzydistance jarowinkler levenshtein_distance

. drop `dvars'

. loc compvars c1 c2 kolner1 daitch1 dblmeta1 metaphone1 nys1 mr1

. loc c1 Caverphone1 Encoding

. loc c2 Caverphone2 Encoding

. loc kolner1 Cologne Phonetic Encoding

. loc daitch1 Daitch Mokotoff Soundex Encoding 

. loc dblmeta1 Double Metaphone Encoding 

. loc metaphone1 Metaphone Encoding

. loc nys1 Nysiis Encoding

. loc mr1 Match Rating Approach Encoding

. 
. foreach v of loc compvars {
  2. di _n(2) `"``v'' String Distance Comparison "'
  3. strdist `v'a `v'b, f j l
  4. li `v'*  `dvars'
  5. drop `dvars'
  6. }


Caverphone1 Encoding String Distance Comparison 

     +--------------------------------------------------+
     |    c1a      c1b   fuzzyd~e   jarowi~r   levens~e |
     |--------------------------------------------------|
  1. | RPNSTL   RPNSTL         16          1          0 |
  2. | RKLNTR   RKLNTR         16          1          0 |
  3. | STLSTL   STLSTL         16          1          0 |
  4. | PRFTNS   PRFTNS         16          1          0 |
  5. | KRNSTN   KRNSTN         16          1          0 |
     |--------------------------------------------------|
  6. | ATLPRT   ATLPRT         16          1          0 |
  7. | WWKWRK   WWKWRK         16          1          0 |
  8. | PRFTNS   PRFTNS         16          1          0 |
     +--------------------------------------------------+


Caverphone2 Encoding String Distance Comparison 

     +----------------------------------------------------------+
     |        c2a          c2b   fuzzyd~e   jarowi~r   levens~e |
     |----------------------------------------------------------|
  1. | RPNSTLRPNS   RPNSTLRPNS         28          1          0 |
  2. | RKLNTRKLNT   RKLNTRKLNT         28          1          0 |
  3. | STLSTLNNNN   STLSTLNNNS         25        .96          1 |
  4. | PRFTNSPRFT   PRFTNSPRFT         28          1          0 |
  5. | KRNSTNKNST   KRNSTNKNST         28          1          0 |
     |----------------------------------------------------------|
  6. | ATLPRTLPRN   ATLPRTLPRN         28          1          0 |
  7. | WWKWRKNNNN   WWKWRKNNNK         25        .96          1 |
  8. | PRFTNSPRFN   PRFTNSPRFN         28          1          0 |
     +----------------------------------------------------------+


Cologne Phonetic Encoding String Distance Comparison 

     +-----------------------------------------------------------------------------------------------------------------+
     |             kolner1a                                                  kolner1b   fuzzyd~e   jarowi~r   levens~e |
     |-----------------------------------------------------------------------------------------------------------------|
  1. | 71682571682565656565    716825716825656565716825716825716871687168716871656565         52        .87         34 |
  2. | 72456272456265656565      7245627245626565657456277456274562756756724572456565         52        .87         32 |
  3. |       82582565656565              82582565656582582582582568258825882588256565         34        .84         30 |
  4. | 17326817326865656565    173268173268656565173268173268173217321732173217356565         52        .86         34 |
  5. | 47682687682665656565   4768268768266565654768264768264682476847688768287656565         52        .86         35 |
     |-----------------------------------------------------------------------------------------------------------------|
  6. |   025172517465656565             025172517465656525172251725176251251251256565         46        .86         27 |
  7. |      373437465656565               3734374656565343743437467473734373837356565         37        .83         28 |
  8. |    17326817365656565       173268173656565173268173268173617321732173217356565         43        .85         34 |
     +-----------------------------------------------------------------------------------------------------------------+


Daitch Mokotoff Soundex Encoding String Distance Comparison 

     +------------------------------------------------------+
     | daitch1a   daitch1b   fuzzyd~e   jarowi~r   levens~e |
     |------------------------------------------------------|
  1. |   976438     976438         16          1          0 |
  2. |   935863     935863         16          1          0 |
  3. |   438438     438438         16          1          0 |
  4. |   797364     797364         16          1          0 |
  5. |   496436     496436         16          1          0 |
     |------------------------------------------------------|
  6. |   038793     038793         16          1          0 |
  7. |   797579     797579         16          1          0 |
  8. |   797364     797364         16          1          0 |
     +------------------------------------------------------+


Double Metaphone Encoding String Distance Comparison 

     +------------------------------------------------------+
     | dblme~1a   dblme~1b   fuzzyd~e   jarowi~r   levens~e |
     |------------------------------------------------------|
  1. |     RPNS       RPNS         10          1          0 |
  2. |     RJLN       RJLN         10          1          0 |
  3. |     STLS       STLS         10          1          0 |
  4. |     PRFT       PRFT         10          1          0 |
  5. |     KRNS       KRNS         10          1          0 |
     |------------------------------------------------------|
  6. |     ATLP       ATLP         10          1          0 |
  7. |     ARKR       ARKR         10          1          0 |
  8. |     PRFT       PRFT         10          1          0 |
     +------------------------------------------------------+


Metaphone Encoding String Distance Comparison 

     +------------------------------------------------------+
     | metap~1a   metap~1b   fuzzyd~e   jarowi~r   levens~e |
     |------------------------------------------------------|
  1. |     RBNS       RBNS         10          1          0 |
  2. |     RJLN       RJLN         10          1          0 |
  3. |     STLS       STLS         10          1          0 |
  4. |     PRFT       PRFT         10          1          0 |
  5. |     KRNS       KRNS         10          1          0 |
     |------------------------------------------------------|
  6. |     ATLB       ATLB         10          1          0 |
  7. |     WRWK       WRWK         10          1          0 |
  8. |     PRFT       PRFT         10          1          0 |
     +------------------------------------------------------+


Nysiis Encoding String Distance Comparison 

     +--------------------------------------------------+
     |  nys1a    nys1b   fuzzyd~e   jarowi~r   levens~e |
     |--------------------------------------------------|
  1. | RABANS   RABANS         16          1          0 |
  2. | RADGAL   RADGAL         16          1          0 |
  3. | SATLAS   SATLAS         16          1          0 |
  4. | PRAVAD   PRAVAD         16          1          0 |
  5. | CRANST   CRANST         16          1          0 |
     |--------------------------------------------------|
  6. | ATLABA   ATLABA         16          1          0 |
  7. | WARWAC   WARWAC         16          1          0 |
  8. | PRAVAD   PRAVAD         16          1          0 |
     +--------------------------------------------------+


Match Rating Approach Encoding String Distance Comparison 

     +--------------------------------------------------+
     |   mr1a     mr1b   fuzzyd~e   jarowi~r   levens~e |
     |--------------------------------------------------|
  1. | RBNLNL   RBNLNL         16          1          0 |
  2. | RDGLNL   RDGLNL         16          1          0 |
  3. | STLLNL   STLLNL         16          1          0 |
  4. | PRVLNL   PRVLNL         16          1          0 |
  5. | CRNLNL   CRNLNL         16          1          0 |
     |--------------------------------------------------|
  6. | ATLLNL   ATLLNL         16          1          0 |
  7. | WRWLNL   WRWLNL         16          1          0 |
  8. | PRVLNL   PRVLNL         16          1          0 |
     +--------------------------------------------------+

```


# Additional Information
__Requires JRE 1.8 or later__
If you have the Apache Commons Codec library on your classpath use the binary that does not include `-jar-with-dependencies.jar` as part of the file name.  
