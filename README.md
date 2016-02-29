[![Project Status: Active - The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active)

# strutil
Package providing string manipulation utilities in Stata.  Currently, provides phonetic encoding methods for strings.

# Examples
Get alternate string encodings

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

# Additional Information
__Requires JRE 1.8 or later__
If you have the Apache Commons Codec library on your classpath use the binary that does not include `-jar-with-dependencies.jar` as part of the file name.  
