

&lt;testSuite&gt;


> 

&lt;tests&gt;


> > 

&lt;test id="ordinal.Jahrhundert" language="de"&gt;


> > > 

&lt;input&gt;

Er starb im 19. Jahrhundert.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Er⁍ ⁌starb⁍ ⁌im⁍ ⁌19⁍ ⁌.⁍ ▶ ◀⁌Jahrhundert⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point mis-detected as sentence boundary.

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Er⁍ ⁌starb⁍ ⁌im⁍ ⁌19.⁍ ⁌Jahrhundert⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - Ordinal number point is part of number token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Er⁍ ⁌starb⁍ ⁌im⁍ ⁌19⁍ ⁌.⁍ ⁌Jahrhundert⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point is separate token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="ordinal.Mann" language="de"&gt;


> > > 

&lt;input&gt;

Und dann kam der 3. Mann ins Spiel.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Und⁍ ⁌dann⁍ ⁌kam⁍ ⁌der⁍ ⁌3⁍ ⁌.⁍ ▶ ◀⁌Mann⁍ ⁌ins⁍ ⁌Spiel⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point mis-detected as sentence boundary.

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Und⁍ ⁌dann⁍ ⁌kam⁍ ⁌der⁍ ⁌3.⁍ ⁌Mann⁍ ⁌ins⁍ ⁌Spiel⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - Ordinal number point is part of number token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="ordinal.Platz" language="de"&gt;


> > > 

&lt;input&gt;

Sie stehen zurzeit auf dem 15. Platz der Rangliste.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Sie⁍ ⁌stehen⁍ ⁌zurzeit⁍ ⁌auf⁍ ⁌dem⁍ ⁌15⁍ ⁌.⁍ ▶ ◀⁌Platz⁍ ⁌der⁍ ⁌Rangliste⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point mis-detected as sentence boundary.

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Sie⁍ ⁌stehen⁍ ⁌zurzeit⁍ ⁌auf⁍ ⁌dem⁍ ⁌15.⁍ ⁌Platz⁍ ⁌der⁍ ⁌Rangliste⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - Ordinal number point is part of number token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Sie⁍ ⁌stehen⁍ ⁌zurzeit⁍ ⁌auf⁍ ⁌dem⁍ ⁌15⁍ ⁌.⁍ ⁌Platz⁍ ⁌der⁍ ⁌Rangliste⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point is separate token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="ordinal.Weltkrieg" language="de"&gt;


> > > 

&lt;input&gt;

Der 1. Weltkrieg dauerte 4 Jahre.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌1⁍ ⁌.⁍ ▶ ◀⁌Weltkrieg⁍ ⁌dauerte⁍ ⁌4⁍ ⁌Jahre⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point mis-detected as sentence boundary and is separate token.

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌1.⁍ ⁌Weltkrieg⁍ ⁌dauerte⁍ ⁌4⁍ ⁌Jahre⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - Ordinal number point is part of number token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="ordinal.date" language="de"&gt;


> > > 

&lt;input&gt;

Der erste Weltkrieg begann mit dem Attentat von Sarajevo am 28. Juni 1914.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌erste⁍ ⁌Weltkrieg⁍ ⁌begann⁍ ⁌mit⁍ ⁌dem⁍ ⁌Attentat⁍ ⁌von⁍ ⁌Sarajevo⁍ ⁌am⁍ ⁌28⁍ ⁌.⁍ ▶ ◀⁌Juni⁍ ⁌1914⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point mis-detected as sentence boundary.

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌erste⁍ ⁌Weltkrieg⁍ ⁌begann⁍ ⁌mit⁍ ⁌dem⁍ ⁌Attentat⁍ ⁌von⁍ ⁌Sarajevo⁍ ⁌am⁍ ⁌28.⁍ ⁌Juni⁍ ⁌1914.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - Ordinal number point is part of number token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌erste⁍ ⁌Weltkrieg⁍ ⁌begann⁍ ⁌mit⁍ ⁌dem⁍ ⁌Attentat⁍ ⁌von⁍ ⁌Sarajevo⁍ ⁌am⁍ ⁌28⁍ ⁌.⁍ ⁌Juni⁍ ⁌1914⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - Ordinal number point is separate token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="abbreviation.M\_Sc\_" language="de"&gt;


> > > 

&lt;input&gt;

Der akademische Titel M.Sc. Informatik berechtigt zur Promotion.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌akademische⁍ ⁌Titel⁍ ⁌M.Sc⁍ ⁌.⁍ ▶ ◀⁌Informatik⁍ ⁌berechtigt⁍ ⁌zur⁍ ⁌Promotion⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - dot closing abbreviation mis-detected as sentence boundary

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Der⁍ ⁌akademische⁍ ⁌Titel⁍ ⁌M⁍ ⁌.⁍ ⁌Sc⁍ ⁌.⁍ ▶ ◀⁌Informatik⁍ ⁌berechtigt⁍ ⁌zur⁍ ⁌Promotion⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - dot closing abbreviation mis-detected as sentence boundary and abbreviation falls apart

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="abbreviation.middle.initial" language="de"&gt;


> > > 

&lt;input&gt;

Christian M. Meyer wird demnächst seine Dissertation fertig stellen.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Christian⁍ ⁌M.⁍ ⁌Meyer⁍ ⁌wird⁍ ⁌demnächst⁍ ⁌seine⁍ ⁌Dissertation⁍ ⁌fertig⁍ ⁌stellen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - middle initial dot not separated, single sentence

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Christian⁍ ⁌M⁍ ⁌.⁍ ▶ ◀⁌Meyer⁍ ⁌wird⁍ ⁌demnächst⁍ ⁌seine⁍ ⁌Dissertation⁍ ⁌fertig⁍ ⁌stellen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - closing dot mis-detected as sentence boundary and is separated from abbreviation

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Christian⁍ ⁌M.⁍ ▶ ◀⁌Meyer⁍ ⁌wird⁍ ⁌demnächst⁍ ⁌seine⁍ ⁌Dissertation⁍ ⁌fertig⁍ ⁌stellen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - closing dot  mis-detected as sentence boundary and abbreviation falls apart

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Christian⁍ ⁌M⁍ ⁌.⁍ ⁌Meyer⁍ ⁌wird⁍ ⁌demnächst⁍ ⁌seine⁍ ⁌Dissertation⁍ ⁌fertig⁍ ⁌stellen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - closing dot is separated from abbreviation

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="directspeech.question.smartquotes" language="de"&gt;


> > > 

&lt;input&gt;

„Wird der Splitter das hier meistern?“, wollte er wissen.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌„⁍ ⁌Wird⁍ ⁌der⁍ ⁌Splitter⁍ ⁌das⁍ ⁌hier⁍ ⁌meistern⁍ ⁌?⁍ ▶ ◀⁌“⁍ ⁌,⁍ ⁌wollte⁍ ⁌er⁍ ⁌wissen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - the two quotes end up in different sentences

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌„Wird⁍ ⁌der⁍ ⁌Splitter⁍ ⁌das⁍ ⁌hier⁍ ⁌meistern⁍ ⁌?“,⁍ ▶ ◀⁌wollte⁍ ⁌er⁍ ⁌wissen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - two sentences and punctuation cloggs together

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌„⁍ ⁌Wird⁍ ⁌der⁍ ⁌Splitter⁍ ⁌das⁍ ⁌hier⁍ ⁌meistern⁍ ⁌?⁍ ⁌“⁍ ⁌,⁍ ⁌wollte⁍ ⁌er⁍ ⁌wissen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - one sentence

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="directspeech.question.doublequotes" language="de"&gt;


> > > 

&lt;input&gt;

"Wird der Splitter das hier meistern?", wollte er wissen.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌"⁍ ⁌Wird⁍ ⁌der⁍ ⁌Splitter⁍ ⁌das⁍ ⁌hier⁍ ⁌meistern⁍ ⁌?⁍ ⁌"⁍ ▶ ◀⁌,⁍ ⁌wollte⁍ ⁌er⁍ ⁌wissen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - two sentences

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌"Wird⁍ ⁌der⁍ ⁌Splitter⁍ ⁌das⁍ ⁌hier⁍ ⁌meistern⁍ ⁌?",⁍ ▶ ◀⁌wollte⁍ ⁌er⁍ ⁌wissen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - two sentences and punctuation cloggs together

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌"⁍ ⁌Wird⁍ ⁌der⁍ ⁌Splitter⁍ ⁌das⁍ ⁌hier⁍ ⁌meistern⁍ ⁌?⁍ ⁌"⁍ ⁌,⁍ ⁌wollte⁍ ⁌er⁍ ⁌wissen⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - one sentence

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="number.version.underspecified" language="en"&gt;


> > > 

&lt;input&gt;

John loves Windows 3.x and DOS.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3⁍ ⁌.⁍ ⁌x⁍ ⁌and⁍ ⁌DOS⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - version split into multiple tokens

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3.x⁍ ⁌and⁍ ⁌DOS.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - sentence marker is not a separate token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

 ◀⁌John⁍ ⁌loves⁍ ⁌Windows⁍ ⁌3⁍ ⁌.⁍ ▶ ◀⁌x⁍ ⁌and⁍ ⁌DOS⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - version separator misdetected as sentence separator

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="namedentity.ampersand" language="en"&gt;


> > > 

&lt;input&gt;

I called the AT&amp;T support today.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌I⁍ ⁌called⁍ ⁌the⁍ ⁌AT⁍ ⁌&amp;⁍ ⁌T⁍ ⁌support⁍ ⁌today⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - "AT&amp;T" is split

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌I⁍ ⁌called⁍ ⁌the⁍ ⁌AT&amp;T⁍ ⁌support⁍ ⁌today⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - "AT&amp;T" is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="number.n-th" language="en"&gt;


> > > 

&lt;input&gt;

We travel to the n-th dimension.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌We⁍ ⁌travel⁍ ⁌to⁍ ⁌the⁍ ⁌n-th⁍ ⁌dimension⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - "n-th" is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="namedentity.location.compound" language="en"&gt;


> > > 

&lt;input&gt;

We visit Barton-upon-Humber in summer.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌We⁍ ⁌visit⁍ ⁌Barton-upon-Humber⁍ ⁌in⁍ ⁌summer⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - "Barton-upon-Humber" is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="time.decade" language="en"&gt;


> > > 

&lt;input&gt;

The '20s had been a tough time.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌'⁍ ⁌20s⁍ ⁌had⁍ ⁌been⁍ ⁌a⁍ ⁌tough⁍ ⁌time⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - the apostrophe is split off

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌'20s⁍ ⁌had⁍ ⁌been⁍ ⁌a⁍ ⁌tough⁍ ⁌time⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - the apostrophe is not split off

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="number.range" language="en"&gt;


> > > 

&lt;input&gt;

We get 10-20 of these each day.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌We⁍ ⁌get⁍ ⁌10⁍ ⁌-⁍ ⁌20⁍ ⁌of⁍ ⁌these⁍ ⁌each⁍ ⁌day⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - the range is split into multiple tokens

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌We⁍ ⁌get⁍ ⁌10-20⁍ ⁌of⁍ ⁌these⁍ ⁌each⁍ ⁌day⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - the range is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="number.percentage" language="en"&gt;


> > > 

&lt;input&gt;

The car is 20% off today.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌car⁍ ⁌is⁍ ⁌20⁍ ⁌%⁍ ⁌off⁍ ⁌today⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - "20%" is split into two tokens

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌car⁍ ⁌is⁍ ⁌20%⁍ ⁌off⁍ ⁌today⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - "20%" is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="wisp" language="en"&gt;


> > > 

&lt;input&gt;

The elusive will-o'-the-wisp haunts the forest.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌elusive⁍ ⁌will-o⁍ ⁌'⁍ ⁌-⁍ ⁌the-wisp⁍ ⁌haunts⁍ ⁌the⁍ ⁌forest⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - "will-o'-the-wisp" is split into multiple tokens

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌elusive⁍ ⁌will-o⁍ ⁌'⁍ ⁌-the-wisp⁍ ⁌haunts⁍ ⁌the⁍ ⁌forest⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - "will-o'-the-wisp" is split into multiple tokens

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌elusive⁍ ⁌will-o'-the-wisp⁍ ⁌haunts⁍ ⁌the⁍ ⁌forest⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - "will-o'-the-wisp" is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="adjective.compound" language="en"&gt;


> > > 

&lt;input&gt;

Let us visit the Museum of Afro-American History in Boston.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌Let⁍ ⁌us⁍ ⁌visit⁍ ⁌the⁍ ⁌Museum⁍ ⁌of⁍ ⁌Afro-American⁍ ⁌History⁍ ⁌in⁍ ⁌Boston⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - compound is one token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;


> > 

&lt;test id="apostrophe.possessive" language="en"&gt;


> > > 

&lt;input&gt;

The next question is Debanjan's.

&lt;/input&gt;


> > > 

&lt;possibleOutputs&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌next⁍ ⁌question⁍ ⁌is⁍ ⁌Debanjan⁍ ⁌'s⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

GOOD - possessive marker is separate token

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌next⁍ ⁌question⁍ ⁌is⁍ ⁌Debanjan⁍ ⁌'⁍ ⁌s⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - possessive marker is split into two tokens

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;


> > > > 

&lt;possibleOutput&gt;


> > > > > 

&lt;output&gt;

◀⁌The⁍ ⁌next⁍ ⁌question⁍ ⁌is⁍ ⁌Debanjan's⁍ ⁌.⁍ ▶

&lt;/output&gt;


> > > > > 

&lt;description&gt;

BAD - possessive marker is not split off

&lt;/description&gt;



> > > > 

&lt;/possibleOutput&gt;



> > > 

&lt;/possibleOutputs&gt;



> > 

&lt;/test&gt;



> 

&lt;/tests&gt;




&lt;/testSuite&gt;

