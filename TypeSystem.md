<h1>DKPro Core Type System</h1>

This graphics gives an overview of the most important types in the DKPro Core type system. All types shown here inherit from the UIMA `Annotation` type which provides `start` and `end` offsets.

![https://dkpro-core-asl.googlecode.com/svn/wiki/images/DKProCoreTypeSystem.png](https://dkpro-core-asl.googlecode.com/svn/wiki/images/DKProCoreTypeSystem.png)


<a href='Hidden comment: 
<h3>Segmentation

Unknown end tag for &lt;/h3&gt;



<h4> Compound 

Unknown end tag for &lt;/h4&gt;



This type represents a decompounding word, i.e.: <i>flowerpot

Unknown end tag for &lt;/i&gt;

. Each Compound one have at least two Splits.

<h4> Split 

Unknown end tag for &lt;/h4&gt;



This type represents a part of a decompounding word. A Split can be either a !CompoundPart or a !LinkingMorpheme.

<h4> !LinkingMorpheme 

Unknown end tag for &lt;/h4&gt;



This type represents a linking morpheme between two !CompoundParts.

<h4> !CompoundPart 

Unknown end tag for &lt;/h4&gt;



A !CompoundPart represents one fragment from the compounding word. Besides that, it can store other !CompoundParts if it can be split again. The way it stores a decompounding word represents a decompounding tree. I.e.:

<i> Getränkautomat 

Unknown end tag for &lt;/i&gt;



```
(Compound:
   coveredText: getränkeautomat
   splits:
     (CompoundPart
        coveredText: getränk
        splits:())
     (LinkingMorpheme
        coveredText: e)
     (CompoundPart
        coveredText: automat
        splits:
           (CompoundPart
               coveredText: auto
               splits:())
           (CompoundPart
               coveredText: mat
               splits:())
     )
)
```
'></a>