[![Project Status: Active - The project has reached a stable, usable state and is being actively developed.](http://www.repostatus.org/badges/latest/active.svg)](http://www.repostatus.org/#active)

# strutil
Package providing string manipulation utilities in Stata.  Currently, provides phonetic encoding methods for strings.

# Examples
Get alternate string encodings

```
sysuse auto.dta, clear
strutil make, caverphone1(cav1) caverphone2(cav2) col(kolner) dms(daitch) dblm(dblmeta) metap(metaphone) nys(nysiis) beiderm(bmencode) matchrating(mrating)

```

# Additional Information
__Requires JRE 1.8 or later__
If you have the Apache Commons Codec library on your classpath use the binary that does not include `-jar-with-dependencies.jar` as part of the file name.  
